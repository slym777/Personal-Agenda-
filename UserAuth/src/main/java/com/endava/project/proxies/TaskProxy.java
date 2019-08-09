package com.endava.project.proxies;

import com.endava.project.models.Meeting;
import com.endava.project.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;

@Service
public class TaskProxy {

    private RestTemplate restTemplate;

    @Autowired
    public TaskProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${task.service.url}")
    private String taskServiceUrl;

    public List<Task> getTasks(){
        String url = taskServiceUrl + "/task/all";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Task> getMyReminders(){
        String url = taskServiceUrl + "/task/reminders/" +
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public List<Task> getDateReminders(Date date){
        String url = taskServiceUrl + "/task/reminders/" + date + "/" +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public void addTask(Task task){
        task.setUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        String url = taskServiceUrl + "/task/add";
        restTemplate.postForLocation(url, task);
    }
}
