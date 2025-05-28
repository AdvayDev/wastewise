package com.pod2.wastewise.service;

import com.pod2.wastewise.model.Worker;
import com.pod2.wastewise.repository.WorkerRepository;
import com.pod2.wastewise.utility.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private IdGenerator idGenerator;

    private WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    public Worker createWorker(Worker worker){
        worker.setWorkerId(idGenerator.generateWorkerId());
        return workerRepository.save(worker);
    }
}
