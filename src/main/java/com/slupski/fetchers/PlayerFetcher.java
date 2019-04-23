package com.slupski.fetchers;

import com.slupski.commons.Credentials;
import com.slupski.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerFetcher {

    private static final String PLAYERS_URL = "http://sokker.org/xml/players-%s.xml";
    private static final String TAGNAME_NAME = "name";
    private static final String TAGNAME_SURENAME = "surname";
    private static final String TAGNAME_ID = "ID";
    private static final String TAGNAME_COUNTRY = "countryID";

    @Autowired
    private SessionFetcher sessionFetcher;

    public List<Player> fetch(Credentials credentials) throws IOException, ParserConfigurationException, SAXException {
        List<Player> players = new ArrayList<>();

        ResponseEntity<String> response = makeRequest(credentials);
        Document doc = makeDocument(response);

        NodeList playerNodes = doc.getChildNodes().item(0).getChildNodes();

        for (int i = 0; i < playerNodes.getLength(); i++) {
            if(playerNodes.item(i) instanceof Element) {
                Element playerNode = (Element) playerNodes.item(i);
                Player player = new Player();
                player.setName(getTextContent(playerNode, TAGNAME_NAME));
                player.setSurename(getTextContent(playerNode, TAGNAME_SURENAME));
                player.setId(getIntContent(playerNode, TAGNAME_ID));
                player.setCountryId(getIntContent(playerNode, TAGNAME_COUNTRY));

                players.add(player);
            }
        }

        return players;
    }

    private String getTextContent(Element playerNode, String tagName) {
        return playerNode.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private int getIntContent(Element playerNode, String tagName) {
        return Integer.valueOf(getTextContent(playerNode, tagName));
    }

    private Document makeDocument(ResponseEntity<String> response) throws ParserConfigurationException, SAXException, IOException {
        String xmlResponse = response.getBody();

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                xmlResponse.getBytes());
        return builder.parse(inputStream);
    }

    private ResponseEntity<String> makeRequest(Credentials credentials) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = sessionFetcher.getSessionHeader(credentials);
        String url = String.format(PLAYERS_URL, credentials.getTeamId());
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);
    }


}
