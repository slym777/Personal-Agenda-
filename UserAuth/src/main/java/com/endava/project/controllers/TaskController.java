package com.endava.project.controllers;

import com.endava.project.models.Task;
import com.endava.project.proxies.TaskProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskProxy userServiceProxy;

    @Autowired
    public TaskController(TaskProxy userServiceProxy){
        this.userServiceProxy = userServiceProxy;
    }

    @GetMapping("/getAll")
    public List<Task> getAllTasks(){
        return userServiceProxy.getTasks();
    }

    @GetMapping("/reminders")
    public List<Task> getMYReminders(){
        return userServiceProxy.getMyReminders();
    }

    @GetMapping("/dateReminders/{date}")
    public List<Task> getDateReminders(@PathVariable Date date){
        return userServiceProxy.getDateReminders(date);
    }

    @GetMapping("/todayReminders")
    public List<Task> getTodayReminders(){
        return userServiceProxy.getDateReminders(Date.valueOf(LocalDate.now()));
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task){
        userServiceProxy.addTask(task);
    }
}
