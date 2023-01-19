package com.control;

import com.company.ObjectFile;
import com.company.SCPObject;
import com.company.User;
import com.supplementary.*;

public class ObjectFileController {
    private User associatedUser;

    public ObjectFileController(User user){
        this.associatedUser=user;
    }

    public ObjectFile createObjectFile(String name, Clearance clearance, String docLink, SCPObject object){
        return new ObjectFile(name, clearance, docLink, object, this.associatedUser);
    }

    public String viewObjectFile(ObjectFile objectFile){
        if (objectFile.getClearance().suffices(this.associatedUser.getClearance())) return objectFile.getDocLink();
        return null;
    }

    public void editObjectFile(ObjectFile objectFile, String docLink){
        if (objectFile.getCreator().matches(this.associatedUser)) objectFile.edit(docLink);
    }

    public ObjectFile deleteObjectFile(ObjectFile objectFile){
        if (objectFile.getCreator().matches(this.associatedUser)) return null;
        return objectFile;
    }
}
