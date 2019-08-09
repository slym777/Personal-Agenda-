package com.endava.project.services;

import com.endava.project.models.Meeting;
import com.endava.project.models.Task;
import com.sun.source.util.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceProxy {

    private RestTemplate restTemplate;

    @Autowired
    public UserServiceProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${task.service.url}")
    private String taskServiceUrl;

    public List<Task> getTasks(){
        String url = taskServiceUrl + "/task/all";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Task> getMyTodayReminders(){
        String url = taskServiceUrl + "/task/reminders/" + Date.valueOf(LocalDate.now()) + "/" +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public List<Meeting> getMyWeekMeetings(){
        String url = taskServiceUrl + "/meeting/week/" +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public void addTask(Task task){
        task.setUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        String url = taskServiceUrl + "/task/add";
        restTemplate.postForLocation(url, task);
    }

    public void addMeeting(Meeting meeting){
        meeting.setUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        String url = taskServiceUrl + "/meeting/add";
        restTemplate.postForLocation(url, meeting);
    }
}
