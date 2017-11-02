package edu.pcc.alizanganeh.aihmultisportweekendapp;

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
//    Event event;


    public RegisterMember(String firstName, String lastNamae, String email
            , String phonNumber, String emergencyName, String emergencyNumber
           ) {
        this.firstName = firstName;
        this.lastNamae = lastNamae;
        this.email = email;
        this.phonNumber = phonNumber;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
//        this.event = event;
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

//    public Event getEvent() {
//        return event;
//    }

}
