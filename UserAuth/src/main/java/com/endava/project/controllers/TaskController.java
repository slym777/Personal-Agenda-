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

    private TaskProxy taskProxy;

    @Autowired
    public TaskController(TaskProxy userServiceProxy){
        this.taskProxy = userServiceProxy;
    }

    @GetMapping("/getAll")
    public List<Task> getAllTasks(){
        return taskProxy.getTasks();
    }

    @GetMapping("/reminders")
    public List<Task> getMYReminders(){
        return taskProxy.getMyReminders();
    }

    @GetMapping("/dateReminders/{date}")
    public List<Task> getDateReminders(@PathVariable Date date){
        return taskProxy.getDateReminders(date);
    }

    @GetMapping("/todayReminders")
    public List<Task> getTodayReminders(){
        return taskProxy.getDateReminders(Date.valueOf(LocalDate.now()));
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task){
        taskProxy.addTask(task);
    }

    @PostMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){
        taskProxy.delete(id);
    }
}
