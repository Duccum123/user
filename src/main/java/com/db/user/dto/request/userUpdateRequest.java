package com.db.user.dto.request;

import java.time.LocalDate;

public class userUpdateRequest {
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate daybird;

    public LocalDate getDaybird() {
        return daybird;
    }

    public void setDaybird(LocalDate daybird) {
        this.daybird = daybird;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
