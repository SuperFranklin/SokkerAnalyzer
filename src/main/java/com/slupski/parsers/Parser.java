package com.slupski.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public abstract class Parser<T> {

    public abstract T parse();

    protected String getTextContent(Element playerNode, String tagName) {
        return playerNode.getElementsByTagName(tagName).item(0).getTextContent();
    }

    protected int getIntContent(Element playerNode, String tagName) {
        return Integer.valueOf(getTextContent(playerNode, tagName));
    }

    protected float getFloatContent(Element playerNode, String tagName) {
        return Float.valueOf(getTextContent(playerNode, tagName));
    }
}
