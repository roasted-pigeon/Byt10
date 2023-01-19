package com.company;

import java.util.Calendar;
import java.util.Date;

public class ObjectFile{
    private SCPObject object;
    private String name;
    private Clearance clearance;
    private Date dateCreated;
    private String docLink;
    private User creator;
    private FileType fileType;

    public ObjectFile(String name, Clearance clearance, String docLink, User creator, FileType fileType, SCPObject object){
        this.name=name;
        this.clearance=clearance;
        this.dateCreated= Calendar.getInstance().getTime();
        this.docLink=docLink;
        this.creator=creator;
        this.fileType=fileType;
        this.object = object;
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

    public ObjectFile createObjectFile(String name, Clearance clearance, String docLink, SCPObject object, User user, FileType fileType){
        return new ObjectFile(name, clearance, docLink, user, fileType, object);
    }

    public String viewObjectFile(ObjectFile objectFile, User user){
        if (objectFile.getClearance().suffices(user.getClearance())) return objectFile.getDocLink();
        return null;
    }

    public void editObjectFile(ObjectFile objectFile, String docLink, User user){
        if (objectFile.getCreator().matches(user)) objectFile.edit(docLink);
    }

    public ObjectFile deleteObjectFile(ObjectFile objectFile, User user){
        if (objectFile.getCreator().matches(user)) return null;
        return objectFile;
    }
}
