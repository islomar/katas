package com.cd.bad.code;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import java.net.URL;
import java.util.*;

/**
 * fk--folder key,dk--doc key -->value is key string
 * dt--doc type,ft--folder type -->both have 19 key options:
 * bom tr amend history help info loeid cust cust0-cust9 custhist
 * folder type only seen as "history" in toc,why ??do we use other ones? -- it only has one child
 * doc type only seen two "tr" and "history" in toc??-- it only has one child
 * node with "folder type="history"" is the only child of it parent either "<doc type="tr" key="xxx" trnum="xxx"....." or "<doc type="tr"  trnum="xxx""
 * <folder type="history"  could has more then one doc children .e.g. title="History of AMM31-32-00-720-807" in 700/amm
 * <p>
 * <p>
 * <p>
 * folder element has the follwing to identify itself:
 * 1, key
 * 2, type="history",  in this case, folder is the only child of doc element with type ="tr"?????
 * <p>
 * doc element has the following to identify itself
 * 1, key
 * 2, type="tr" trnum="xxxxx"
 * 3, type="history", in this case, doc isthe only child of a folder element???
 * <p>
 * <p>
 * <p>
 * the return json format likes following:
 * [
 * { "data" : "A node", "children" , "state" : "open" },
 * { "data" : "Only child", "state" : "closed" },
 * "Ajax node"
 * ]
 */

public class XMLToJson {
    private static final Map<String, String> pathMap;

    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("fk", "folder[@key");
        aMap.put("ft", "folder[@type");
        aMap.put("fth", "folder[@type='history'");
        aMap.put("dk", "doc[@key");
        aMap.put("dt", "doc[@type");
        aMap.put("dth", "doc[@type='history'");
        aMap.put("dtrn", "doc[@trnum");
        pathMap = Collections.unmodifiableMap(aMap);
    }

    XMLDocumentReader xmlDocumentReader = new XMLDocumentReader();

    /*
     * @param url the path to TOC.xml
     * @param xPathString the short format searched node path
     * @throws DocumentException
     *
     * sample xPathString : "fk:AMM24_fk:AMM24-FM_dk"
     */
    @SuppressWarnings({"unchecked"})
    public String getJson(URL tocURL, String xPathString) throws Exception {
        Document tocDoc = xmlDocumentReader.fromURL(tocURL);
        String jsonString = "[";

        Element node = selectNodeToConvert(xPathString, tocDoc);

        for (Element element : node.elements()) {
            String elementName = element.getName();
            List<Attribute> attributeList = element.attributes();
            String titleAttrContent = element.attributeValue("title");
            String fileAttrContent = element.attributeValue("file");

            if ("doc".equals(elementName)) {
                jsonString = jsonString.concat("{");
                jsonString = jsonString.concat("'data':'").concat(titleAttrContent).concat("',");

                if (attributeList.stream().anyMatch(attribute -> "key".equals(attribute.getName()))) {
                    String keyContent = extractKeyContentFromElement(element);
                    jsonString = jsonString.concat("'attr':{'id':'").concat(xPathString).concat("_dk:").concat(keyContent).concat("','file':'").concat(fileAttrContent).concat("'}");
                }
                if (attributeList.stream().anyMatch(attribute -> "trnum".equals(attribute.getName()))) {
                    String trnumContent = element.attributeValue("trnum");
                    jsonString = jsonString.concat("'attr':{'id':'").concat(xPathString).concat("_dtrn:").concat(trnumContent).concat("','file':'").concat(fileAttrContent).concat("'}");
                }

                jsonString = addClosedStateIfNoChildren(jsonString, element);
                jsonString = jsonString.concat("},");
            } else if ("folder".equals(elementName)) {
                jsonString = jsonString.concat("{");
                for (Attribute attribute : attributeList) {
                    String attributeName = attribute.getName();
                    jsonString = jsonString.concat("'data':'").concat(titleAttrContent).concat("',");
                    if (attributeName.equals("key")) {
                        String keyContent = extractKeyContentFromElement(element);
                        jsonString = jsonString.concat("'attr':{'id':'").concat(xPathString).concat("_fk:").concat(keyContent).concat("'}");
                        if (fileAttrContent != null) {
                            jsonString = jsonString.concat("','file':'").concat(fileAttrContent).concat("'}");
                        }

                        break;
                    } else if (attributeName.equals("type")) {
                        String typeContent = element.attributeValue("type");
                        //doc element has type "history"
                        if (typeContent == "history") {
                            jsonString = jsonString.concat("'attr':{'id':'").concat(xPathString).concat("_fth,");

                        }
                        break;

                    }

                }
                jsonString = jsonString.concat("},");
            }
            continue;
        }
        jsonString = jsonString.substring(0, jsonString.length() - 1);
        jsonString = jsonString.concat("]");
        return jsonString;

    }

    private String extractKeyContentFromElement(Element element) {
        return element.attributeValue("key");
    }

    private String addClosedStateIfNoChildren(String jsonString, Element element) {
        boolean hasChildren = !element.elements().isEmpty();
        if (hasChildren) {
            jsonString = jsonString.concat(",'state':'closed'");
        }
        return jsonString;
    }

    private Element selectNodeToConvert(String xPathString, Document tocDoc) throws Exception {
        Element node;
        if (xPathString.equals("/")) {
            node = tocDoc.getRootElement();
        } else {
            String realXPathString = pathMapping(xPathString);
            System.out.println(realXPathString);
            node = (Element) tocDoc.selectSingleNode(realXPathString);
        }
        return node;
    }

    /*
     * post string looks like : "fk:LOETR_dtrn:TR12-118_fth_dth"
     * it represents the inner doc elemnet:
     * <folder key="LOETR" type="loetr" title="List of Effective TRs" file="loetr.html">
     *		<doc type="tr" trnum="TR12-118" trdate="May 07/2012" title="[TR12-118] TASK AMM12-31-00-660-806 - Inspection and Removal of De-Hydrated Anti-Icing Fluid inside the Flight Control Surfaces" file="TR12-118.pdf" refloc="AMM12-31-00-660-806">
     * 			<folder type="history" title="History of AMM12-31-00-660-806">
     *   			<doc title="TASK 12-31-00-660-806 - Inspection and Removal of De-Hydrated Anti-Icing Fluid inside the Flight Control Surfaces" file="AMM12-31-00-660-806.pdf" type="history" refloc="AMM12-31-00-660-806"/>
     * </folder>
     * the xpath string should be:
     * folder[@key="LOETR"]/doc[@trnum="TR12-118"]/folder[@type="history"]/doc[@type="history"]
     *
     *
     * the String : "fk:AMM24_fk:AMM24-FM_dk:CTOC-24"
     * it represents the inner doc with attribute file="CTOC-24.pdf"
     * the string : "fk:AMM24_fk:AMM24-00-00_fk:AMM24-00-00-02_dk:AMM24-00-00-700-801" represents
     * <folder key="AMM24" title="CH 24 - Electrical Power">
     *		<folder key="AMM24-FM" title="Front Matter">
     * 			<doc key="CTOC-24" title="Table of Contents" file="CTOC-24.pdf"/>
     *		</folder>
     *		<folder key="AMM24-00-00" title="24-00-00 - General">
     * 			<folder key="AMM24-00-00-02" title="General - Maintenance Practices">
     *   			<doc key="AMM24-00-00-700-801" title="TASK 24-00-00-700-801 - AC Power, DC Power and Battery Maintenance Practice Recommendations" file="AMM24-00-00-700-801.pdf"/>
     *
     * it can be even optimized as :
     * "fk:AMM24_fk:00-00_fk:02_dk:AMM24-00-00-700-801"
     * if the inner key fully include the previous key, omit it, otherwise use full string
     * the xpath string should be:
     * folder[@key="AMM24"]/folder[@key="AMM24-00-00"]/folder[@key="AMM24-00-00-02"]/doc[@key="AMM24-00-00-700-801"]
     *
     * if shortXPath is ?? which means the query based on the root of the document
     *
     *
     */
    public String pathMapping(String shortXPath) throws Exception {
        String tagetString;
        if (shortXPath.equals("")) {
            tagetString = "//toc";
        } else {
            tagetString = "//";
        }

        int newStart = 0;
        String segString = "";
        String valueString = "";
        while (shortXPath.indexOf("_", newStart) > -1) {
            int keyValueSepPos = 0;
            String keyString = "";//not necessary key, might be type attribute
            segString = shortXPath.substring(newStart, shortXPath.indexOf("_", newStart));
            newStart = shortXPath.indexOf("_", newStart) + 1;//new start search point
            if (segString.indexOf(":") > 0) {
                keyValueSepPos = segString.indexOf(":");
                keyString = segString.substring(0, keyValueSepPos);
                valueString = segString.substring(keyValueSepPos + 1);
                if (pathMap.get(keyString).length() > 0) {
                    tagetString = tagetString.concat(pathMap.get(keyString));
                } else {
                    throw new Exception("no mapping found");
                }
                tagetString = tagetString.concat("='").concat(valueString).concat("']/");
            }
        }
        //this is for scenerio either no "_" or sub string after "_"
        segString = shortXPath.substring(newStart);
        System.out.println(segString);
        if (segString.indexOf(":") > 0) {
            int lastKeyValueSepPos = segString.indexOf(":");
            String lastKeyString = segString.substring(0, lastKeyValueSepPos);
            String lastValueString = segString.substring(lastKeyValueSepPos + 1);
            if (pathMap.get(lastKeyString).length() > 0) {
                tagetString = tagetString.concat(pathMap.get(lastKeyString));
            } else {
                throw new Exception("no mapping found");
            }
            tagetString = tagetString.concat("='").concat(lastValueString).concat("']");
        }
        return tagetString;

    }

    public static void main(String[] args) throws Exception {
        XMLToJson x2j = new XMLToJson();
        String test = "fk:AMM24_fk:AMM24-FM";

        test = "";
        System.out.println(x2j.getJson(new URL("http://localhost:8080/WebNavSpring/q400/amm/toc.xml"), test));
    }
}