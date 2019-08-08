package com.endava.workactivity.respositories;

import com.endava.workactivity.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    List<Meeting> getMeetingsByDateAndUsername(Date d, String u);
    List<Meeting> getMeetingsByStartTimeAndDate(Time t, Date d);
    List<Meeting> getMeetingsByUsername(String username);

}
