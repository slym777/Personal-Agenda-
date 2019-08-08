package com.endava.workactivity.services;

import com.endava.workactivity.entities.Meeting;
import com.endava.workactivity.respositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getTodaysMeetings(Date date, String username){
        return meetingRepository.getMeetingsByDateAndUsername(date, username);
    }

    public List<Meeting> getWeeksMeetings(String username){
        List<Meeting> weekMetings = new ArrayList<>();
        List<Meeting> all = meetingRepository.getMeetingsByUsername(username);
        LocalDate date = LocalDate.now();

        for(Meeting m: all) {
            if(m.getDate().after(Date.valueOf(date)) && m.getDate().before(Date.valueOf(date.plusDays(5)))) {
                weekMetings.add(m);
            }
        }

        return weekMetings;
    }
}
