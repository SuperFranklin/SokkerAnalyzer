package com.slupski.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private int id;
    private String name;
    private String surename;
    private int countryId;
    private List<PlayerSkills> skills = new ArrayList<>();
    private List<PlayerStats> stats = new ArrayList<>();

    public void addSkills(PlayerSkills skill){
        this.skills.add(skill);
    }
    public void addStats(PlayerStats stat){
        this.stats.add(stat);
    }
}
