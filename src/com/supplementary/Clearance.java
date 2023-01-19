package com.supplementary;

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

    Clearance(String name, int level, String description){
        this.name=name;
        this.level=level;
        this.description=description;
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
