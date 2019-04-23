package com.slupski.hello;

import com.slupski.fetchers.PlayerFetcher;
import com.slupski.commons.Credentials;
import com.slupski.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    Environment environment;

    @Autowired
    PlayerFetcher playerFetcher;

    @RequestMapping("/hello")
    public List<Player> hello() throws ParserConfigurationException, SAXException, IOException {
        return playerFetcher.fetch(new Credentials(51982, "nowy_mou", "sansiro"));
    }
}
