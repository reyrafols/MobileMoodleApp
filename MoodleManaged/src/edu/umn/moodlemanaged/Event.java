package edu.umn.moodlemanaged;

import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event>{
    public String text; // E.g. CSCI 5115: Development Complete (1:30PM)*
    public String courseName;
    public boolean isChecked; // Stores whether the event has been checked off
    public Date time;
    public String event_type;
    public int id;
    public int cid;
    public int percentage;
    public double total;
    public boolean isFinal;
    public double score = -1;
    public Event(String t, boolean b) {
        this.text = t;
        this.isChecked = b;
    }
    public Event(String name, String courseName, boolean b , String due,String event_type){
        this.id =0 ;
        this.text = name;
        this.courseName = courseName;
        this.event_type = event_type;
        this.isChecked = b;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            time = sd.parse(due);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Event(String name, String courseName, boolean b, String due,String event_type,int id,int cid,int percentage,double total){
        this.id = id;
        this.text = name;
        this.courseName = courseName;
        this.event_type = event_type;
        this.isChecked = b;
        this.isFinal = isFinal;
        this.cid = cid;
        this.percentage = percentage;
        this.total = total;
        this.score = score;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            time = sd.parse(due);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Event(String name, String courseName, boolean b, String due,String event_type,int id,int cid,int percentage,double total, double score, boolean isFinal){
        this.id = id;
        this.text = name;
        this.courseName = courseName;
        this.event_type = event_type;
        this.isChecked = b;
        this.isFinal = isFinal;
        this.cid = cid;
        this.percentage = percentage;
        this.total = total;
        this.score = score;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            time = sd.parse(due);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Event(String name, String courseName, boolean b, String due,String event_type,int id,int cid){
        this.id = id;
        this.text = name;
        this.courseName = courseName;
        this.event_type = event_type;
        this.isChecked = b;
        this.cid = cid;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            time = sd.parse(due);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Event(Cursor cursor){
        this.text = cursor.getString(cursor.getColumnIndex("name"));
        this.courseName = cursor.getString(cursor.getColumnIndex("course_name"));
        this.event_type=cursor.getString(cursor.getColumnIndex("event_type"));
        this.isChecked= (cursor.getString(cursor.getColumnIndex("done")).equals("True"));
        this.time= new Date(cursor.getString(cursor.getColumnIndex("due")));
    }

    @Override
    public int compareTo(Event event) {
       return this.time.compareTo(event.time);
    }
}
