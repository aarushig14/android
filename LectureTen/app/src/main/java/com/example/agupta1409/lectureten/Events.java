package com.example.agupta1409.lectureten;

/**
 * Created by a.gupta1409 on 05-07-2016.
 */
public class Events {
    String name;
    String location;
    String type;
    String topic;

    public Events(String name, String location, String type, String topic) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}