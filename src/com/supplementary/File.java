package com.supplementary;

import com.company.Clearance;
import com.company.FileType;
import com.company.User;

import java.util.Calendar;
import java.util.Date;

abstract public class File {
    private String name;
    private Clearance clearance;
    private Date dateCreated;
    private String docLink;
    private User creator;
    private FileType fileType;

    public File(String name, Clearance clearance, String docLink, User creator, FileType fileType){
        this.name=name;
        this.clearance=clearance;
        this.dateCreated= Calendar.getInstance().getTime();
        this.docLink=docLink;
        this.creator=creator;
        this.fileType=fileType;
    }

    public Clearance getClearance() {
        return this.clearance;
    }

    public User getCreator() {
        return this.creator;
    }

    public String getDocLink() {
        return this.docLink;
    }

    public String toString(){
        return this.name+", clearance needed: "+this.clearance.toString()+", created at: "+this.dateCreated.toString()+", link to document: "+this.docLink+", created by: "+this.creator.toShortString();
    }

    public void edit(String newDocLink){
        this.docLink=newDocLink;
    }
}
