package com.example.agupta1409.todo_list.models;

import java.util.Date;

/**
 * Created by a.gupta1409 on 16-07-2016.
 */
public class tasks {

    int id;
    String task;
    Date date;
    String status;

    public tasks(int id, String task, Date date, String status) {
        this.id = id;
        this.task = task;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
