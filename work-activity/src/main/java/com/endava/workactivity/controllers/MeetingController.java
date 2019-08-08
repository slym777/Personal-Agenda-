package com.endava.workactivity.controllers;

import com.endava.workactivity.entities.Meeting;
import com.endava.workactivity.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

   @GetMapping("/week/{username}")
    public List<Meeting> getWeekMeetings(@PathVariable String username) {
        return meetingService.getWeeksMeetings(username);
   }
}
