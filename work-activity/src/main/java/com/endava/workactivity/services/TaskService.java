package com.endava.workactivity.services;

import com.endava.workactivity.entities.Task;
import com.endava.workactivity.respositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getDailyTasks(String username) {
        LocalDate date = LocalDate.now();
        return taskRepository.getUnresolvedTasks(Date.valueOf(date), username);
    }

}
