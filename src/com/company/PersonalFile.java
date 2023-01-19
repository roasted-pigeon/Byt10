package com.company;

import com.supplementary.File;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PersonalFile{
    private String name;
    private Clearance clearance;
    private Date dateCreated;
    private String docLink;
    private User creator;
    private FileType fileType;
    private ArrayList<User> associatedWith;

    public PersonalFile(String name, Clearance clearance, String docLink, User creator, FileType fileType){
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

    public int associateWith(User user){
        for (User tempUser:associatedWith) if (user.toString().equals(tempUser.toString())) return 1;
        associatedWith.add(user);
        return -1;
    }

    public String toString(){
        return this.name+", clearance needed: "+this.clearance.toString()+", created at: "+this.dateCreated.toString()+", link to document: "+this.docLink+", created by: "+this.creator.toShortString();
    }

    public void edit(String newDocLink){
        this.docLink=newDocLink;
    }

    public PersonalFile createPersonalFile(String name, Clearance clearance, String docLink, User user, FileType type){
        return new PersonalFile(name, clearance, docLink, user, type);
    }

    public String viewPersonalFile(PersonalFile personalFile, User user){
        if (personalFile.getClearance().suffices(user.getClearance())) return personalFile.getDocLink();
        return null;
    }

    public void editPersonalFile(PersonalFile personalFile, String docLink, User user){
        if (personalFile.getCreator().matches(user)) personalFile.edit(docLink);
    }

    public PersonalFile deletePersonalFile(PersonalFile personalFile, User user){
        if (personalFile.getCreator().matches(user)) return null;
        return personalFile;
    }
}
