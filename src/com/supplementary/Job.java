package com.supplementary;

public class Job {
    private String name;
    private String description;
    private Department department;

    public Job(String name, String description, Department department){
        this.name=name;
        this.description=description;
        this.department=department;
    }

    public boolean matches(Job job){
        return this.toString().equals(job.toString());
    }

    public String toString(){
        return this.department.toString()+", "+this.name;
    }
}
