package com.company;

import java.util.ArrayList;

public enum Department {
    AD("Administrative Department", "This department includes all communication nodes and command centers"),
    DEA("Department of External Affairs", "The DEA is responsible for concealing the activity of Foundation agents and facilities in populated areas"),
    ETSD("Engineering and Technical Service Department", "Responsible for technical maintenance and everyday services of all facilities and equipment"),
    EC("Ethics Committee", "Responsible for reviewing containment procedures and checking conducted experiments for excessive waste or inappropriate use of resources"),
    IA("Intelligence Agency", "Responsible for searching, tracking, and capturing uncontained SCP objects and gathering intelligence on hostile groups of interest"),
    ISD("Internal Security Department", "Responsible for filtering traitors as well as operational and information security risks among the Foundation's ranks"),
    LD("Logistics Department", "Responsible for transferring natural, financial and human resources between Foundation facilities"),
    MaD("Manufacturing Department", "Responsible for fulfilling any material requests that can arise during capture, containment, or any other Foundation process"),
    MeD("Medical Department", "Responsible for keeping employees in good health"),
    MTF("Mobile Task Forces", "Responsible for special operations carried out by Foundation"),
    SD("Scientific Department", "Responsible for studying all contained and new SCP objects"),
    ScD("Scientific Department", "Responsible for studying all contained and new SCP objects"),
    SeD("Security Department", "Responsible for providing security and protection for all Foundation facilities and objects"),
    ITD("Internal Tribunal Department", "Responsible for hearing cases of Foundation personnel and other persons' actions that fall under the definition of prohibited by the Internal Tribunal Department's Legal Codex");


    private String name;
    private String description;
    private ArrayList<Job> jobs = new ArrayList<>();

    Department(String name, String description){
        this.name=name;
        this.description=description;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public Department[] listDepartments(){
        return Department.values();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
