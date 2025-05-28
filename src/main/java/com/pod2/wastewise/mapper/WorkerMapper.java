package com.pod2.wastewise.mapper;

import com.pod2.wastewise.dto.WorkerDTO;
import com.pod2.wastewise.model.Worker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
    WorkerDTO toDTO(Worker worker);

    Worker toEntity(WorkerDTO workerDTO);
}
