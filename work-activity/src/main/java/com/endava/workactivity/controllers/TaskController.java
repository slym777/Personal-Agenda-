package com.endava.workactivity.controllers;


import com.endava.workactivity.entities.Task;
import com.endava.workactivity.respositories.TaskRepository;
import com.endava.workactivity.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @PostMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id) {
        taskRepository.deleteById(id);
    }

    @PostMapping("/deleteResolved/{username}")
    @Transactional
    public void deleteResolved(@PathVariable String username) {
        taskRepository.deleteAllResolvedTasks(username);
    }

    @GetMapping("/reminders/{date}/{username}")
    public List<Task> getReminders(@PathVariable Date date, @PathVariable String username) {
        return taskRepository.findTasksByDueDateAndUsername(date, username);
    }

    @GetMapping("/getDailyTasks/{username}")
    public List<Task> getDailyTasks(@PathVariable String username) {
        return taskService.getDailyTasks(username);
    }

    @PostMapping("/changeStatus/resolved/{id}")
    @Transactional
    public void changeStatusResolved(@PathVariable int id) {
        taskRepository.chngeStatusToResolved(id);
    }

    @PostMapping("/changeStatus/unresolved/{id}")
    @Transactional
    public void changeStatusUnresolved(@PathVariable int id) {
        taskRepository.chngeStatusToUnresolved(id);
    }

    @PostMapping("updateSetDay/{id}/{date}")
    @Transactional
    public void updateSetDay(@PathVariable int id, @PathVariable Date date) {
        taskRepository.updateSetDay(id, date);
    }

    @PostMapping("updateDueDate/{id}/{date}")
    public void updateDueDate(@PathVariable int id, @PathVariable Date date) {
        taskRepository.updateDueDate(id, date);
    }

    @PostMapping("updateDueHour/{id}/{hour}")
    @Transactional
    public void updateDueHour(@PathVariable int id, @PathVariable Time hour) {
        taskRepository.updateDueHour(id, hour);
    }

    @PostMapping("updateDueDate/{id}")
    @Transactional
    public void updateDueDate(@PathVariable int id, @RequestBody String description) {
        taskRepository.updateDescription(id, description);
    }
}
