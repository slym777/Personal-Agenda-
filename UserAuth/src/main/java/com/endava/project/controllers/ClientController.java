package com.endava.project.controllers;

import com.endava.project.models.Task;
import com.endava.project.services.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private UserServiceProxy userServiceProxy;

    public ClientController(UserServiceProxy userServiceProxy){
        this.userServiceProxy = userServiceProxy;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks(){
        return userServiceProxy.getTasks();
    }

    @GetMapping("/reminders")
    public List<Task> getReminders(){
        return userServiceProxy.getMyTodayReminders();
    }
}
