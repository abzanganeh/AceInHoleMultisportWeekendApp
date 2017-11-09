package edu.pcc.alizanganeh.aihmultisportweekendapp.models;

import org.parceler.Parcel;

/**
 * Created by ABZanganeh on 10/19/17.
 */
@Parcel
public class Event {

    private String name;
    private String day;
    private String time;
    private int price;
    private String swim;
    private String bike;
    private String run;

    public Event(){

    }

    public Event(String name, String day, String time, int price, String swim, String bike, String run) {
        this.name = name;
        this.day = day;
        this.time = time;
        this.price = price;
        this.swim = swim;
        this.bike = bike;
        this.run = run;
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

    public int getPrice() {
        return price;
    }

    public String getSwim() {
        return swim;
    }

    public String getBike() {
        return bike;
    }

    public String getRun() {
        return run;
    }
}
