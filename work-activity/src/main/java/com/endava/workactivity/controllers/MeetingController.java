package com.endava.workactivity.controllers;

import com.endava.workactivity.entities.Meeting;
import com.endava.workactivity.respositories.MeetingRepository;
import com.endava.workactivity.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
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

//   @GetMapping("/week/{username}")
//    public List<Meeting> getWeekMeetings(@PathVariable String username) {
//        return meetingService.
//   }

    @GetMapping("/today/{username}")
    public List<Meeting> getTodayMeetings(@PathVariable String username) {
        return meetingService.getTodaysMeetings(username);
    }

    @GetMapping("/date/{date}/{username}")
    public List<Meeting> getDateMeetings(@PathVariable Date date, @PathVariable String username){
        return meetingRepository.getMeetingsByDateAndUsername(date, username);
    }

    @GetMapping("/update")
    public void update() {
        meetingService.deleteOldMeetings();
    }

    @PostMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id) {
        meetingRepository.deleteById(id);
    }

    @PostMapping("/updateName/{id}/{name}")
    @Transactional
    public void updateName(@PathVariable int id, @PathVariable String name) {
        meetingRepository.updateMeetingName(id, name);
    }

    @PostMapping("/updateDate/{id}/{date}")
    @Transactional
    public void updateDate(@PathVariable int id, @PathVariable Date date) {
        meetingRepository.updateMeetingDate(id, date);
    }

    @PostMapping("/updateRoom/{id}/{room}")
    @Transactional
    public void updateRoom(@PathVariable int id, @PathVariable String room) {
        meetingRepository.updateMeetingRoom(id, room);
    }

    @PostMapping("/updateStartTime/{id}/{time}")
    @Transactional
    public void updateStartTime(@PathVariable int id, @PathVariable Time time) {
        meetingRepository.updateMeetingStartTime(id, time);
    }

    @PostMapping("/updateEndTime/{id}/{time}")
    @Transactional
    public void updateEndTime(@PathVariable int id, @PathVariable Time time) {
        meetingRepository.updateMeetingEndTime(id, time);
    }

    @PostMapping("/updateDetails/{id}/{details}")
    @Transactional
    public void updateDetails(@PathVariable int id, @PathVariable String details) {
        meetingRepository.updateMeetingDetails(id, details);
    }

}
