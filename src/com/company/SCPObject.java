package com.company;

import com.supplementary.*;

import java.util.ArrayList;

public class SCPObject {
    private String nickname;
    private Clearance clearance;
    private ContainmentClass containmentClass;
    private DisruptionClass disruptionClass;
    private RiskClass riskClass;
    private SecondaryClass secondaryClass;
    private ArrayList<ObjectFile> relatedFiles;

    public SCPObject(String nickname, Clearance clearance, ContainmentClass containmentClass, DisruptionClass disruptionClass, RiskClass riskClass, SecondaryClass secondaryClass){
        this.nickname = nickname;
        this.clearance = clearance;
        this.containmentClass = containmentClass;
        this.disruptionClass = disruptionClass;
        this.riskClass = riskClass;
        this.secondaryClass = secondaryClass;
    }
}
