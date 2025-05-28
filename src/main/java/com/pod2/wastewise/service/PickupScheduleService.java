package com.pod2.wastewise.service;


import com.pod2.wastewise.dto.PickupScheduleCreateDTO;
import com.pod2.wastewise.dto.PickupStatusDTO;
import com.pod2.wastewise.model.PickupSchedule;

import java.util.List;

public interface PickupScheduleService {

    String createSchedule(PickupScheduleCreateDTO pickupScheduleCreateDTO);

    PickupSchedule deleteSchedule(String scheduleId);

    List<PickupStatusDTO> listAllStatuses();

    PickupSchedule getById(String scheduleId);
}
