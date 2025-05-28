package com.pod2.wastewise.mapper;

import com.pod2.wastewise.dto.WorkerRequestDTO;
import com.pod2.wastewise.model.Worker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
    WorkerRequestDTO toDTO(Worker worker);

    Worker toEntity(WorkerRequestDTO workerRequestDTO);
}
