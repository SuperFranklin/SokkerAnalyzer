package com.slupski.parsers;

import com.slupski.model.Player;
import com.slupski.model.PlayerSkills;
import com.slupski.utils.WeekGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillsParser extends Parser<Map<Integer, PlayerSkills>> {

    private static final String TAGNAME_ID = "ID";

    private Document doc;

    public SkillsParser(Document doc){
        this.doc = doc;
    }

    /** returns map <player id, skills> */
    public Map<Integer, PlayerSkills> parse() {
        Map<Integer, PlayerSkills> result = new HashMap<>();

        NodeList playerNodes = doc.getChildNodes().item(0).getChildNodes();

        for (int i = 0; i < playerNodes.getLength(); i++) {
            if(playerNodes.item(i) instanceof Element) {
                Element playerNode = (Element) playerNodes.item(i);
                Integer playerId = getIntContent(playerNode, TAGNAME_ID);

                PlayerSkills skills = new PlayerSkills();
                skills.setPlayerId(playerId);
                skills.setBMI(getFloatContent(playerNode, "BMI"));
                skills.setDefending(getIntContent(playerNode, "skillDefending"));
                skills.setDiscipline(getIntContent(playerNode, "skillDiscipline"));
                skills.setExperience(getIntContent(playerNode, "skillExperience"));
                skills.setForm(getIntContent(playerNode, "skillForm"));
                skills.setKeeper(getIntContent(playerNode, "skillKeeper"));
                skills.setPace(getIntContent(playerNode, "skillPace"));
                skills.setPassing(getIntContent(playerNode, "skillPassing"));
                skills.setPlaymaking(getIntContent(playerNode, "skillPlaymaking"));
                skills.setScoring(getIntContent(playerNode, "skillScoring"));
                skills.setWage(getIntContent(playerNode, "wage"));
                skills.setTechnique(getIntContent(playerNode, "skillTechnique"));
                skills.setTeamWork(getIntContent(playerNode, "skillTeamwork"));
                skills.setStamina(getIntContent(playerNode, "skillStamina"));
                skills.setValue(getIntContent(playerNode, "value"));

                skills.setWeek(WeekGenerator.getWeekNumber());

                result.put(playerId, skills);
            }
        }
        return result;
    }
}














