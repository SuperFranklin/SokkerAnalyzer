package com.slupski.model;

import lombok.Data;

@Data
public class PlayerStats {
    private int playerId;
    private int week;
    private int cards;
    private int goals;
    private int assists;
    private int matches;
    private int ntCards;
    private int ntGoals;
    private int ntAssists;
    private int ntMatches;
    private int injuryDays;
}
