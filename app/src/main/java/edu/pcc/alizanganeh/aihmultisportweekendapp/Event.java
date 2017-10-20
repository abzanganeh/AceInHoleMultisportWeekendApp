package edu.pcc.alizanganeh.aihmultisportweekendapp;

/**
 * Created by ABZanganeh on 10/19/17.
 */

public class Event {
    private String name;
    private String day;
    private String time;
    private Class activityName;
    private int price;


    public Event(String name, String day, String time, Class activityName, int price) {
        this.name = name;
        this.day = day;
        this.time = time;
        this.activityName = activityName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public Class getActivityName() {
        return activityName;
    }

    public int getPrice() {
        return price;
    }


}
