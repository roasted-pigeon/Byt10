package com.supplementary;

public enum RiskClass {
    NOTICE("Notice", "Effects are nearly non-existent to mild"),
    CAUTION("Caution", "Effects are mild to moderate"),
    WARNING("Warning", "Effects are moderate to significant"),
    DANGER("Danger", "Effects are significant to extreme"),
    CRITICAL("Critical", "Effects are near instant and/or extremely severe");


    private String name;
    private String description;

    RiskClass(String name, String description){
        this.name=name;
        this.description=description;
    }
}
