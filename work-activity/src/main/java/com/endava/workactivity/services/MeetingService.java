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

    public enum AddedDays{
        MONDAY (7), TUESDAY (6), WEDNESDAY (5),
        THURSDAY (4), FRIDAY (3), SATURDAY (2), SUNDAY (1);
        private final int value;

        AddedDays (int value) {
            this.value = value;
        }

        public int getvalue() {
            return this.value;
        }
    }

    public List<Meeting> getTodaysMeetings(String username){
        List<Meeting> weekMetings = new ArrayList<>();
        List<Meeting> all = meetingRepository.getMeetingsByUsername(username);
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        int noOfDays = AddedDays.valueOf(day.toString()).getvalue();


        for(Meeting m: all) {
            if(m.getDate().after(Date.valueOf(date.minusDays(1))) &&
                m.getDate().before(Date.valueOf(date.plusDays(noOfDays)))) {
                    weekMetings.add(m);
                }
            }
            return weekMetings;
        }

        public void deleteOldMeetings(){
            LocalDate date = LocalDate.now();
            meetingRepository.deleteOldMeetings(Date.valueOf(date));
        }
}
