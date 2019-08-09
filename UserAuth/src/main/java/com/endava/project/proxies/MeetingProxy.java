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
import java.sql.Time;
import java.util.List;

@Service
public class MeetingProxy {
    private RestTemplate restTemplate;

    @Autowired
    public MeetingProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${task.service.url}")
    private String taskServiceUrl;

    public void addMeeting(Meeting meeting){
        meeting.setUsername(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        String url = taskServiceUrl + "/meeting/add";
        restTemplate.postForLocation(url, meeting);
    }

//    public List<Meeting> getMyWeekMeetings(){
//        String url = taskServiceUrl + "/meeting/week/" +
//                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        return restTemplate.getForObject(url, List.class);
//    }

    public List<Meeting> getTodayMeetings(){
        String url = taskServiceUrl + "/meeting/today/" +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public List<Meeting> getDateMeetings(Date date){
        String url = taskServiceUrl + "/meeting/date/" + date + "/" +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return restTemplate.getForObject(url, List.class);
    }

    public void update(){

    }

    public void delete(int id){
        String url = taskServiceUrl + "/meeting/delete/" + id;
        restTemplate.delete(url);
    }

    public void updateName(int id, String name){
        String url = taskServiceUrl + "/meeting/updateName/" + id + "/" + name;
        restTemplate.postForLocation(url, null);
    }

    public void updateDate(int id, Date date){
        String url = taskServiceUrl + "/meeting/updateDate/" + id + "/" + date;
        restTemplate.postForLocation(url, null);
    }

    public void updateRoom(int id, String room){
        String url = taskServiceUrl + "/meeting/updateRoom/" + id + "/" + room;
        restTemplate.postForLocation(url, null);
    }

    public void updateEndTime(int id, Time time){
        String url = taskServiceUrl + "/meeting/updateEndTime/" + id + "/" + time;
        restTemplate.postForLocation(url,null);
    }

    public void updateStartTime(int id, Time time){
        String url = taskServiceUrl + "/meeting/updateStartTime" + id + "/" + time;
        restTemplate.postForLocation(url,null);
    }

    public void updateDetails(int id, String details){
        String url = taskServiceUrl + "/meeting/updateDetails/" + id + "/" + details;
    }
}
