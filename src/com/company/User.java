package com.company;

import com.supplementary.Clearance;
import com.supplementary.Job;
import com.supplementary.LoginData;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class User {
    private boolean gender;
    private String name;
    private String surname;
    private Date dob;
    private Date dopr;
    private Clearance clearance;
    private Job job;
    private User supervisor;
    private LoginData loginData;

    public User(boolean gender, String name, String surname, Date dob, int plannedRotationMonths, Clearance clearance, Job job, User supervisor, LoginData loginData){
        this.gender=gender;
        this.name=name;
        this.surname=surname;
        this.dob=dob;
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.add(Calendar.MONTH, plannedRotationMonths);
        this.dopr= tempCalendar.getTime();
        this.clearance=clearance;
        this.job=job;
        this.supervisor=supervisor;
        this.loginData=loginData;
    }

    public void changeJob(Job newJob){
        this.job=newJob;
    }

    public void editUser(boolean gender, String name, String surname, Date dob, int plannedRotationMonths, Clearance clearance, Job job, User supervisor, LoginData loginData){
        if (!Objects.isNull(gender))this.gender=gender;
        if (!Objects.isNull(name))this.name=name;
        if (!Objects.isNull(surname))this.surname=surname;
        if (!Objects.isNull(dob))this.dob=dob;
        Calendar tempCalendar = Calendar.getInstance();
        if (plannedRotationMonths!=-1)tempCalendar.add(Calendar.MONTH, plannedRotationMonths);
        if (!Objects.isNull(dopr))this.dopr= tempCalendar.getTime();
        if (!Objects.isNull(clearance))this.clearance=clearance;
        if (!Objects.isNull(job))this.job=job;
        if (!Objects.isNull(supervisor))this.supervisor=supervisor;
        if (!Objects.isNull(loginData))this.loginData=loginData;
    }

    public Clearance getClearance() {
        return this.clearance;
    }

    public Job getJob(){
        return this.job;
    }

    public boolean matches(User user){
        return this.toString().equals(user.toString());
    }

    public String toString(){
        return this.name+" "+this.surname+", "+(gender?"M":"F")+", born: "+dob.toString()+", "+this.clearance.toString()+", "+this.job.toString();
    }

    public String toShortString(){
        return this.name+" "+this.surname+", "+this.job.toString();
    }

    public static User deleteUser(){
        return null;
    }
}
