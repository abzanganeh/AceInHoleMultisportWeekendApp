package edu.pcc.alizanganeh.aihmultisportweekendapp.models;

import java.util.ArrayList;

/**
 * Created by ABZanganeh on 11/2/17.
 */


public class RegisterMember {
    String firstName;
    String lastNamae;
    String email;
    String phonNumber;
    String emergencyName;
    String emergencyNumber;
    ArrayList<String> events;


    public RegisterMember(String firstName, String lastNamae, String email
            , String phonNumber, String emergencyName, String emergencyNumber, ArrayList<String> events
    ) {
        this.firstName = firstName;
        this.lastNamae = lastNamae;
        this.email = email;
        this.phonNumber = phonNumber;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.events = events;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNamae() {
        return lastNamae;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

}
