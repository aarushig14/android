package com.example.agupta1409.announcements.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by a.gupta1409 on 03-09-2016.
 */
public class Announ {

    String msgId;
//    String date;
//    String time;
    String message;
    int seen;

    public Announ(String msgId,String message, int seen) {
//        this.date = date;
        this.msgId = msgId;
//        this.time = time;
        this.message = message;
        this.seen = seen;
    }

    public String getMsgId() {
        return msgId;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public String getTime() {
//        return time;
//    }

    public String getMessage() {
        return message;
    }

    public int getSeen() {
        return seen;
    }
}
