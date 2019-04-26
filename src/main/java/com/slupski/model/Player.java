package com.slupski.model;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private int id;
    private String name;
    private String surename;
    private int countryId;
    private List<PlayerSkills> skills;
    private List<PlayerStats> stats;
}
