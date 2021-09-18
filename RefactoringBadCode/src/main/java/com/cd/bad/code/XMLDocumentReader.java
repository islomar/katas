package com.cd.bad.code;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.net.URL;

public class XMLDocumentReader
{

    private final SAXReader reader;

    public XMLDocumentReader() {
        this.reader = new SAXReader();
    }

    public Document fromURL(URL url)
    {
        Document document = null;

        try {
            document = reader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return document;
    }
}
