package com.endava.workactivity.controllers;

import com.endava.workactivity.entities.Meeting;
import com.endava.workactivity.respositories.MeetingRepository;
import com.endava.workactivity.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingRepository meetingRepository;

    @PostMapping("/add")
    public void addMeeting(@RequestBody Meeting meeting) {
        meetingRepository.save(meeting);
    }

   @GetMapping("/week/{username}")
    public List<Meeting> getWeekMeetings(@PathVariable String username) {
        return meetingService.getWeeksMeetings(username);
   }

    @GetMapping("/today/{username}")
    public List<Meeting> getTodayMeetings(@PathVariable String username) {
        return meetingService.getTodaysMeetings(username);
    }

    @GetMapping("/update")
    public void update() {
        meetingService.update();
    }


}
