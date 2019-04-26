package com.slupski.fetchers;

import com.slupski.commons.Credentials;
import com.slupski.model.Player;
import com.slupski.parsers.Parser;
import com.slupski.parsers.PlayerParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PlayerFetcher {

    private static final String PLAYERS_URL = "http://sokker.org/xml/players-%s.xml";

    @Autowired
    private SessionFetcher sessionFetcher;

    public List<Player> fetch(Credentials credentials) throws IOException, ParserConfigurationException, SAXException {

        ResponseEntity<String> response = makeRequest(credentials);
        Document doc = makeDocument(response);

        Parser<List<Player>> playerParser = new PlayerParser(doc);
        List<Player> players = playerParser.parse();

        return players;
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
