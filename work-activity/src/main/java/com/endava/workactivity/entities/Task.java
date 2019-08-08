package com.endava.workactivity.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "set_day")
    private Date setDay;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "due_hour")
    private Time hour;

    private String description;

    private String status;

    private String username;

    public Date getSetDay() {
        return setDay;
    }

    public void setSetDay(Date setDay) {
        this.setDay = setDay;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
