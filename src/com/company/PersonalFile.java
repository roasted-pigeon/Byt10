package com.company;

import com.supplementary.Clearance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PersonalFile extends File{
    private ArrayList<User> associatedWith;

    public PersonalFile(String name, Clearance clearance, String docLink, User creator){
        super(name, clearance, docLink, creator);
        this.associatedWith = new ArrayList<>();
    }

    public int associateWith(User user){
        for (User tempUser:associatedWith) if (user.toString().equals(tempUser.toString())) return 1;
        associatedWith.add(user);
        return -1;
    }
}
