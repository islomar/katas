package com.cd.bad.code;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class XMLToJsonTest
{
    @Test
    public void shouldTranslateEmptyXMLToJson() throws Exception
    {
        XMLToJson translate = new XMLToJson();

        URL url = new URL("file:./src/test/resources/toc.xml");
        String xPathString = "fk:AMM24_fk:AMM24-00-00_fk:AMM24-00-00-02";

        Approvals.verify(translate.getJson(url, xPathString));
    }
}
