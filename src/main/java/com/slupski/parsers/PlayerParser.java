package com.slupski.parsers;

import com.slupski.model.Player;
import com.slupski.model.PlayerSkills;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerParser extends Parser<List<Player>> {

    private static final String TAGNAME_NAME = "name";
    private static final String TAGNAME_SURENAME = "surname";
    private static final String TAGNAME_ID = "ID";
    private static final String TAGNAME_COUNTRY = "countryID";

    private Document doc;
    public PlayerParser(Document doc){
        this.doc = doc;
    }

    public List<Player> parse(){
        List<Player> players = new ArrayList<>();

        NodeList playerNodes = doc.getChildNodes().item(0).getChildNodes();

        SkillsParser skillsParser = new SkillsParser(doc);
        Map<Integer, PlayerSkills> playersSkills = skillsParser.parse();

        for (int i = 0; i < playerNodes.getLength(); i++) {
            if(playerNodes.item(i) instanceof Element) {
                Element playerNode = (Element) playerNodes.item(i);
                Player player = new Player();
                player.setName(getTextContent(playerNode, TAGNAME_NAME));
                player.setSurename(getTextContent(playerNode, TAGNAME_SURENAME));
                player.setId(getIntContent(playerNode, TAGNAME_ID));
                player.setCountryId(getIntContent(playerNode, TAGNAME_COUNTRY));

                player.addSkills(playersSkills.get(player.getId()));

                players.add(player);
            }
        }

        return players;
    }
}
