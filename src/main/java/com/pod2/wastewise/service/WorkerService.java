package com.pod2.wastewise.service;

import com.pod2.wastewise.exception.WorkerNotFoundException;
import com.pod2.wastewise.model.Worker;
import com.pod2.wastewise.repository.WorkerRepository;
import com.pod2.wastewise.utility.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private IdGenerator idGenerator;

    private static final Logger logger = LoggerFactory.getLogger(WorkerService.class);

    private WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    public Worker createWorker(Worker worker){
        String id = idGenerator.generateWorkerId();
        worker.setWorkerId(id);
        logger.info("Creating worker with id: {}", id);
        return workerRepository.save(worker);
    }

    public Worker findWorker(String id) throws WorkerNotFoundException {
        logger.info("Finding worker with id {}", id);
        Optional<Worker> optionalWorker =  workerRepository.findById(id);
        if(optionalWorker.isEmpty()){
            logger.info("Worker with id {}, not found", id);
            throw new WorkerNotFoundException("Worker with id: " + id + " does not exist");
        }
        return optionalWorker.get();
    }
}
