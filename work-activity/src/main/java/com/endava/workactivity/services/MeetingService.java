package com.endava.workactivity.services;

import com.endava.workactivity.entities.Meeting;
import com.endava.workactivity.respositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getTodaysMeetings(String username){
        LocalDate date = LocalDate.now();
        return meetingRepository.getMeetingsByDateAndUsername(Date.valueOf(date), username);
    }

    public List<Meeting> getWeeksMeetings(String username){
        List<Meeting> weekMetings = new ArrayList<>();
        List<Meeting> all = meetingRepository.getMeetingsByUsername(username);
        LocalDate date = LocalDate.now();

        for(Meeting m: all) {
            if(m.getDate().after(Date.valueOf(date.minusDays(1))) &&
                    m.getDate().before(Date.valueOf(date.plusDays(addDays(date.getDayOfWeek()))))) {
                weekMetings.add(m);
            }
        }

        return weekMetings;
    }


    @Transactional
    public void update(){
        LocalDate date = LocalDate.now();
        meetingRepository.update(Date.valueOf(date));
    }


    public int addDays(DayOfWeek day) {
        switch (day) {
            case MONDAY:
                return 6;
            case TUESDAY:
                return  5;
            case WEDNESDAY:
                return 4;
            case THURSDAY:
                return 3;
            case FRIDAY:
                return 2;
            case SATURDAY:
                return 1;
             default:
                 return 0;
        }
    }
}
