package com.pod2.wastewise.exception;

import com.pod2.wastewise.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Centralized mapping of exceptions to HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ZoneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Map<String,String>> zoneNotFound(ZoneNotFoundException ex) {
        log.error(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(WorkerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Map<String,String>> workerNotFound(WorkerNotFoundException ex) {
        log.error(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Map<String,String>> vehicleNotFound(VehicleNotFoundException ex) {
        log.error(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(PickupScheduleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Map<String,String>> scheduleNotFound(PickupScheduleNotFoundException ex) {
        log.error(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(VehicleBusyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<Map<String,String>> busy(VehicleBusyException ex) {
        log.warn(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(InvalidTimeSlotException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Map<String,String>> invalidSlot(InvalidTimeSlotException ex) {
        log.error(ex.getMessage());
        return new ApiResponse<>(ex.getMessage(), Map.of());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Map<String,String>> validation(MethodArgumentNotValidException ex) {
        log.error("Validation failed", ex);
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return new ApiResponse<>("Validation Failed", errors);
    }
}