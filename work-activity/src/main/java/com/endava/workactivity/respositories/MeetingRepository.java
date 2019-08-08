package com.endava.workactivity.respositories;

import com.endava.workactivity.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    List<Meeting> getMeetingsByDateAndUsername(Date d, String u);

    List<Meeting> getMeetingsByUsername(String username);

    void deleteById(int id);

    @Query("DELETE FROM Meeting m WHERE m.date<:date")
    @Modifying
    void deleteOldMeetings(Date date);

    @Query("UPDATE Meeting m SET m.date=:newDate WHERE m.id=:id")
    @Modifying
    void updateMeetingDate(int id,  Date newDate);

    @Query("UPDATE Meeting m SET m.name=:newName WHERE m.id=:id")
    @Modifying
    void updateMeetingName(int id, String newName);

    @Query("UPDATE Meeting m SET m.room=:newRoom WHERE m.id=:id")
    @Modifying
    void updateMeetingRoom( int id, String newRoom);

    @Query("UPDATE Meeting m SET m.startTime=:time WHERE m.id=:id")
    @Modifying
    void updateMeetingEndTime( int id, Time time);

    @Query("UPDATE Meeting m SET m.endTime=:time WHERE m.id=:id")
    @Modifying
    void updateMeetingStartTime( int id, Time time);

    @Query("UPDATE Meeting m SET m.details=:details WHERE m.id=:id")
    @Modifying
    void updateMeetingDetails( int id, String details);


}
