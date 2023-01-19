package com.company;

import com.supplementary.Clearance;

import java.util.Calendar;
import java.util.Date;

public class ObjectFile extends File{
    private SCPObject object;

    public ObjectFile(String name, Clearance clearance, String docLink, SCPObject object, User creator){
        super(name, clearance, docLink, creator);
        this.object=object;
    }
}
