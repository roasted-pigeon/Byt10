package com.company;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

public enum Clearance {
    LEVEL_0 ("UR", 1, "Unrestricted"),
    LEVEL_1 ("RS", 2, "Restricted"),
    LEVEL_2 ("CF", 3, "Confidential"),
    LEVEL_3 ("SC", 4, "Secret"),
    LEVEL_4 ("TS", 5, "Top Secret"),
    LEVEL_5 ("CTS", 6, "Cosmic Top Secret");

    private String name;
    private int level;
    private String description;
    private PersonalFile personalFile;
    private ObjectFile objectFile;
    private User user;

    Clearance(String name, int level, String description, PersonalFile personalFile){
        this.name=name;
        this.level=level;
        this.description=description;
        this.personalFile = personalFile;
    }

    Clearance(String name, int level, String description, ObjectFile objectFile){
        this.name=name;
        this.level=level;
        this.description=description;
        this.objectFile = objectFile;
    }

    Clearance(String name, int level, String description, User user){
        this.name=name;
        this.level=level;
        this.description=description;
        this.user = user;
    }



    public Clearance[] listClearances(){
        return Clearance.values();
    }

    public boolean matches(Clearance clearance){
        return this.level==clearance.level;
    }

    public boolean suffices(Clearance clearance){return this.level<=clearance.level;}

    @Override
    public String toString() {
        return this.name();
    }
}
