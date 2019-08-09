package com.endava.workactivity.respositories;

import com.endava.workactivity.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findTasksByDueDateAndUsername(Date date, String username);
    List<Task> getTasksByUsername(String username);
}
