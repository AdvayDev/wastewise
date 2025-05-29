package com.pod2.wastewise.service.impl;

import com.pod2.wastewise.dto.PickupScheduleCreateDTO;
import com.pod2.wastewise.dto.PickupStatusDTO;
import com.pod2.wastewise.exception.*;
import com.pod2.wastewise.model.*;
import com.pod2.wastewise.model.enums.PickupStatus;
import com.pod2.wastewise.repository.*;
import com.pod2.wastewise.service.PickupScheduleService;
import com.pod2.wastewise.utility.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PickupScheduleServiceImpl implements PickupScheduleService {

    private static final Logger log = LoggerFactory.getLogger(PickupScheduleServiceImpl.class);

    private final PickupScheduleRepository scheduleRepo;
    private final ZoneRepository zoneRepo;
    private final WorkerRepository workerRepo;
    private final VehicleRepository vehicleRepo;
    private final IdGenerator idGen;

    public PickupScheduleServiceImpl(PickupScheduleRepository scheduleRepo,
                                     ZoneRepository zoneRepo,
                                     WorkerRepository workerRepo,
                                     VehicleRepository vehicleRepo,
                                     IdGenerator idGen) {
        this.scheduleRepo = scheduleRepo;
        this.zoneRepo = zoneRepo;
        this.workerRepo = workerRepo;
        this.vehicleRepo = vehicleRepo;
        this.idGen = idGen;
    }

    @Override
    @Transactional
    public String createSchedule(PickupScheduleCreateDTO dto) {
        log.info("[CREATE] {}", dto);

        Zone zone = zoneRepo.findById(dto.getZoneId())
                .orElseThrow(() -> new ZoneNotFoundException(dto.getZoneId()));
        Worker worker = workerRepo.findById(dto.getWorkerId())
                .orElseThrow(() -> new WorkerNotFoundException(dto.getWorkerId()));
        Vehicle vehicle = vehicleRepo.findById(dto.getVehicleId())
                .orElseThrow(() -> new VehicleNotFoundException(dto.getVehicleId()));

        String[] parts = dto.getTimeSlot().split("-");
        if (parts.length != 2) throw new InvalidTimeSlotException("Expected HH:mm-HH:mm");

        Timestamp start, end;
        try {
            start = Timestamp.valueOf(LocalDate.now() + " " + parts[0] + ":00");
            end   = Timestamp.valueOf(LocalDate.now() + " " + parts[1] + ":00");
        } catch (DateTimeParseException e) {
            throw new InvalidTimeSlotException("Cannot parse time slot: " + dto.getTimeSlot());
        }

        Timestamp bufStart = Timestamp.from(start.toInstant().minusSeconds(1800));
        Timestamp bufEnd   = Timestamp.from(end.toInstant().plusSeconds(1800));

        boolean conflictExists = !scheduleRepo
                .findByVehicle_VehicleIdAndTimeSlot(
                        dto.getVehicleId(), bufStart, bufEnd)
                .isEmpty();

        if (conflictExists) {
            throw new VehicleBusyException();
        }

        String id = idGen.generatePickupId();
        PickupSchedule sched = new PickupSchedule();
        sched.setScheduleId(id);
        sched.setFrequency(dto.getFrequency());
        sched.setPickupLocation(dto.getPickupLocation());
        sched.setTimeSlotStartTime(start);
        sched.setTimeSlotEndTime(end);
        sched.setStatus(PickupStatus.AT_BASE);
        sched.setZone(zone);
        sched.setWorker(worker);
        sched.setVehicle(vehicle);

        scheduleRepo.save(sched);
        log.info("[CREATE] Saved schedule {}", id);
        return id;
    }

    @Override
    @Transactional
    public PickupSchedule deleteSchedule(String scheduleId) {
        log.info("[DELETE] {}", scheduleId);
        PickupSchedule sched = scheduleRepo.findById(scheduleId)
                .orElseThrow(() -> new PickupScheduleNotFoundException(scheduleId));
        scheduleRepo.delete(sched);
        log.info("[DELETE] Removed schedule {}", scheduleId);
        return sched;
    }

    @Override
    public List<PickupStatusDTO> listAllStatuses() {
        log.debug("[LIST] statuses");
        return scheduleRepo.findAll().stream()
                .map(p -> new PickupStatusDTO(
                        p.getVehicle().getVehicleId(),
                        p.getStatus(),
                        p.getScheduleId(),
                        p.getPickupLocation(),
                        p.getTimeSlotStartTime(),
                        p.getTimeSlotEndTime()))
                .collect(Collectors.toList());
    }

    @Override
    public PickupSchedule getById(String scheduleId) {
        log.debug("[GET] {}", scheduleId);
        return scheduleRepo.findById(scheduleId)
                .orElseThrow(() -> new PickupScheduleNotFoundException(scheduleId));
    }
}