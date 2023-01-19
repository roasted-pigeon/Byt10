package com.control;

import com.company.User;
import com.supplementary.Job;

import java.util.ArrayList;

public class JobController {
    private ArrayList<Job> jobs = new ArrayList<>();

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void removeJob(Job jobToRemove){
        for (Job job:this.jobs){
            if (job.matches(jobToRemove)) this.jobs.remove(job);
        }
    }

    public int assignJob(User user, Job jobToAssign) {
        for (Job job : this.jobs) {
            if (job.matches(jobToAssign)) {
                user.changeJob(job);
                return -1;
            }
        }
        addJob(jobToAssign);
        user.changeJob(jobToAssign);
        return -1;
    }

    public ArrayList<Job> listJobs(){
        ArrayList<Job> list = new ArrayList<>();
        for (Job job:this.jobs) list.add(job);
        return list;
    }
}
