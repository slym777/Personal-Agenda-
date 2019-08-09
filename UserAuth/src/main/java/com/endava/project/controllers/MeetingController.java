package com.endava.project.controllers;

import com.endava.project.models.Meeting;
import com.endava.project.proxies.MeetingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
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

//    @GetMapping("/getAll")
//    public List<Meeting> getMyMeetings(){
//        return meetingProxy.getMyWeekMeetings();
//    }

    @GetMapping("/today")
    public List<Meeting> getTodayMeetings(){
        return meetingProxy.getTodayMeetings();
    }

    @GetMapping("/date/{date}")
    public List<Meeting> getDateMeetings(@PathVariable Date date){
        return meetingProxy.getDateMeetings(date);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        meetingProxy.delete(id);
    }

    @PostMapping("/updateName/{id}/{name}")
    public void updateName(@PathVariable int id, @PathVariable String name) {
        meetingProxy.updateName(id, name);
    }

    @PostMapping("/updateDate/{id}/{date}")
    public void updateDate(@PathVariable int id, @PathVariable Date date) {
        meetingProxy.updateDate(id,date);
    }

    @PostMapping("/updateRoom/{id}/{room}")
    public void updateRoom(@PathVariable int id, @PathVariable String room) {
       meetingProxy.updateRoom(id,room);
    }

    @PostMapping("/updateStartTime/{id}/{time}")
    public void updateStartTime(@PathVariable int id, @PathVariable Time time) {
        meetingProxy.updateStartTime(id,time);
    }

    @PostMapping("/updateEndTime/{id}/{time}")
    public void updateEndTime(@PathVariable int id, @PathVariable Time time) {
        meetingProxy.updateEndTime(id,time);
    }

    @PostMapping("/updateDetails/{id}/{details}")
    public void updateDetails(@PathVariable int id, @PathVariable String details) {
        meetingProxy.updateDetails(id,details);
    }
}
