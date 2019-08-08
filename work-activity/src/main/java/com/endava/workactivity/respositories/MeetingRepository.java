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

    @Query("DELETE FROM Meeting m WHERE m.date<:date")
    @Modifying
    void update(@Param("date") Date date);

}
