package com.pod2.wastewise.utility;

import com.pod2.wastewise.model.enums.VehicleType;
import com.pod2.wastewise.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;

    public String generateRoleId() {
        long count = roleRepository.countAll();
        return String.format("%02d", count + 1);
    }

    public String generateWorkerId() {
        long count = workerRepository.countAll();
        return String.format("%04d", count + 1);
    }

    public String generateZoneId() {
        long count = zoneRepository.countAll();
        return String.format("%03d", count + 1);
    }

    public String generateRouteId() {
        long count = routeRepository.countAll();
        return String.format("%03d", count + 1);
    }

    public String generateVehicleId(VehicleType type) {
        long count = vehicleRepository.countByType(type);
        String prefix = type == VehicleType.ROUTE ? "RT" : "PT";
        return prefix + String.format("%03d", count + 1);
    }

    public String generateAssignmentId() {
        long count = assignmentRepository.countAll();
        return String.format("%03d", count + 1);
    }
}
