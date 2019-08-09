package com.endava.project.controllers;

import com.endava.project.models.Meeting;
import com.endava.project.proxies.MeetingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    private MeetingProxy meetingProxy;

    @Autowired
    public MeetingController(MeetingProxy meetingProxy){
        this.meetingProxy = meetingProxy;
    }

    @PostMapping("/add")
    public void addMeeting(@RequestBody Meeting meeting){
        meetingProxy.addMeeting(meeting);
    }

    @GetMapping("/getAll")
    public List<Meeting> getMyMeetings(){
        return meetingProxy.getMyWeekMeetings();
    }

    @GetMapping("/update")
    public void update(){

    }
}
