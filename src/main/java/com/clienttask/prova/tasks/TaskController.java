package com.clienttask.prova.tasks;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @PostMapping("{clientId}")
    public ResponseEntity<Task> save(@RequestBody Task task, @PathVariable("clientId") Long clientId){

        Task task1 = taskService.save(clientId, task);

        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }

    @GetMapping("{clientId}")
    public ResponseEntity<List<Task>> findTaskByClient(@PathVariable("clientId") Long clientId){

        List<Task> tasks = taskService.findTaskByClient(clientId);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
