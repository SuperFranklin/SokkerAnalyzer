package com.slupski.parsers;

import com.slupski.model.PlayerSkills;
import org.w3c.dom.Document;

import java.util.Map;

public class SkillsParser implements Parser<Map<Integer,PlayerSkills>> {

    private Document doc;

    public SkillsParser(Document doc){
        this.doc = doc;
    }

    @Override
    public Map<Integer, PlayerSkills> parse() {

    }
}
