package com.service.workout.controller;

import com.service.workout.dto.WorkoutRequest;
import com.service.workout.dto.WorkoutResponse;
import com.service.workout.service.WorkoutService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("workout")
@Slf4j
@AllArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkout(@RequestBody WorkoutRequest request){
        log.info("Workoutcontroller: New Workout Create request {]", request);
        workoutService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkoutResponse> GetAllWorkouts(){
        log.info("Get All Workouts");
        return workoutService.getAll();
    }

    @GetMapping
    @RequestMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        return "test";
    }
}
