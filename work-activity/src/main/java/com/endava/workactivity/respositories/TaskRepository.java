package com.endava.workactivity.respositories;

import com.endava.workactivity.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findTasksByDueDateAndUsername(Date date, String username);

    void deleteById(int id);

    @Query("SELECT t FROM Task t WHERE t.setDay=:date or t.setDay<:date or t.dueDate=:date " +
            "and t.username=:username and t.status='unresolved' ORDER BY t.dueDate")
    @Modifying
    List<Task> getUnresolvedTasks(Date date, String username);

    @Query("UPDATE Task t SET t.status='resolved' WHERE t.id=:id")
    @Modifying
    void chngeStatusToResolved(int id);

    @Query("UPDATE Task t SET t.status='unresolved' WHERE t.id=:id")
    @Modifying
    void chngeStatusToUnresolved(int id);

    @Query("UPDATE Task t SET t.setDay=:newDate WHERE t.id=:id")
    @Modifying
    void updateSetDay(int id, Date newDate);

    @Query("UPDATE Task t SET t.dueDate=:newDate WHERE t.id=:id")
    @Modifying
    void updateDueDate(int id, Date newDate);

    @Query("UPDATE Task t SET t.hour=:hour WHERE t.id=:id")
    @Modifying
    void updateDueHour(int id, Time hour);

    @Query("UPDATE Task t SET t.description=:description WHERE t.id=:id")
    @Modifying
    void updateDescription(int id, String description);

    @Query("DELETE FROM Task t WHERE t.status='resolved' and t.username=:username")
    @Modifying
    void deleteAllResolvedTasks(String username);
}
