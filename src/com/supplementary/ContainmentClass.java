package com.supplementary;

public enum ContainmentClass {
    PENDING("Pending", "Undergoing classification"),
    SAFE("Safe", "Easily and safely contained"),
    EUCLID("Euclid", "Unpredictable or not yet understood or difficult to contain"),
    KETER("Keter", "Exceedingly difficult to contain consistently or reliably"),
    NEUTRALIZED("Neutralized", "No longer anomalous"),
    EXPLAINED("Explained", "Commonly and fully understood");

    private String name;
    private String description;

    ContainmentClass(String name, String description){
        this.name=name;
        this.description=description;
    }
}
