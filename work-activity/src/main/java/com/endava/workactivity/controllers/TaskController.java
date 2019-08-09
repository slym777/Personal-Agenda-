package com.endava.workactivity.controllers;


import com.endava.workactivity.entities.Task;
import com.endava.workactivity.respositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @GetMapping("/all")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/reminders/{date}/{username}")
    public List<Task> getReminders(@PathVariable Date date, @PathVariable String username) {
        return taskRepository.findTasksByDueDateAndUsername(date, username);
    }

    @GetMapping("/reminders/{username}")
    public List<Task> getReminders(@PathVariable String username) {
        return taskRepository.getTasksByUsername(username);
    }


}
