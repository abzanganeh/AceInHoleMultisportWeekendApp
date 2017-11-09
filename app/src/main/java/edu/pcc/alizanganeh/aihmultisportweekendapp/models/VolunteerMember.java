package edu.pcc.alizanganeh.aihmultisportweekendapp.models;

/**
 * Created by ABZanganeh on 11/2/17.
 */

public class VolunteerMember {
    String firstName;
    String lastNamae;
    String email;
    String comment;

    public VolunteerMember(String firstName
            , String lastNamae, String email, String comment) {
        this.firstName = firstName;
        this.lastNamae = lastNamae;
        this.email = email;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }
}
