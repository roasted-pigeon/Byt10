package com.control;

import com.company.PersonalFile;
import com.company.User;
import com.supplementary.Clearance;

public class PersonalFileController {
    private User associatedUser;

    public PersonalFileController(User user){
        this.associatedUser=user;
    }

    public PersonalFile createPersonalFile(String name, Clearance clearance, String docLink){
        return new PersonalFile(name, clearance, docLink, this.associatedUser);
    }

    public String viewPersonalFile(PersonalFile personalFile){
        if (personalFile.getClearance().suffices(this.associatedUser.getClearance())) return personalFile.getDocLink();
        return null;
    }

    public void editPersonalFile(PersonalFile personalFile, String docLink){
        if (personalFile.getCreator().matches(this.associatedUser)) personalFile.edit(docLink);
    }

    public PersonalFile deletePersonalFile(PersonalFile personalFile){
        if (personalFile.getCreator().matches(this.associatedUser)) return null;
        return personalFile;
    }
}
