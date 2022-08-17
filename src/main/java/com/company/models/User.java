package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name,birthdate,birthplace;

    public User(String name, String birthdate, String birthplace) {
        this.name = name;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
