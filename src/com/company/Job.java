package com.company;

import java.util.ArrayList;

public class Job {
    private String name;
    private String description;
    private Department department;
    private User user;

    public Job(String name, String description, Department department, User user){
        this.name=name;
        this.description=description;
        this.department=department;
        this.user=user;
    }

    public void assignUser(User user){
        this.user=user;
    }

    public ArrayList<Job> listJobs(){
        return this.department.getJobs();
    }

    public boolean matches(Job job){
        return this.toString().equals(job.toString());
    }

    public String toString(){
        return this.department.toString()+", "+this.name;
    }
}
