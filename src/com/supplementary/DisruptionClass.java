package com.supplementary;

public enum DisruptionClass {
    DARK("Dark", "Disruption is so low as to not be a concern"),
    VLAM("Vlam", "Disruption would be localized to a small handful of people"),
    KENEQ("Keneq", "Disruption would be extended to a number of people roughly defined as a city"),
    EKHI("Ekhi", "Disruption would extend to roughly the size of a large metropolitan area to an entire country, potentially to the entire known world"),
    AMIDA("Amida", "Poses such a dire threat to the status quo that there is no other option than to use all possible options to Neutralize it");

    private String name;
    private String description;

    DisruptionClass(String name, String description) {
        this.name = name;
        this.description = description;
    }
}