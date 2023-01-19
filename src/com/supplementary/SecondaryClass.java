package com.supplementary;

public enum SecondaryClass {
    BLANK("BLANK", "BLANK");


    private String name;
    private String description;

    SecondaryClass(String name, String description){
        this.name=name;
        this.description=description;
    }
}
