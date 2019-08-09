package com.endava.project.controllers;

import com.endava.project.entities.Client;
import com.endava.project.models.Meeting;
import com.endava.project.models.Task;
import com.endava.project.services.ClientService;
import com.endava.project.services.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private UserServiceProxy userServiceProxy;
    private ClientService clientService;

    @Autowired
    public ClientController(UserServiceProxy userServiceProxy, ClientService clientService){
        this.userServiceProxy = userServiceProxy;
        this.clientService = clientService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/myInfo")
    public Client myInfo(){
        return clientService.getMyInfo().get();
    }

    @GetMapping("/myContacts")
    public List<Client> mycontacts(){
        return clientService.getMyContacts();
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks(){
        return userServiceProxy.getTasks();
    }

    @GetMapping("/reminders")
    public List<Task> getReminders(){
        return userServiceProxy.getMyTodayReminders();
    }

    @GetMapping("/myMeetings")
    public List<Meeting> getMyMeetings(){
        return userServiceProxy.getMyWeekMeetings();
    }

    @PostMapping("/addTask")
    public void addTask(@RequestBody Task task){
        userServiceProxy.addTask(task);
    }

    @PostMapping("/addMeeting")
    public void addMeeting(@RequestBody Meeting meeting){
        userServiceProxy.addMeeting(meeting);
    }
}
