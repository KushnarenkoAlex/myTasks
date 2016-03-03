package main.java.com.epam.preprod.kushnarenko.security;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.java.com.epam.preprod.kushnarenko.exception.ParsingSecurityXMLException;

/**
 * Parser for security configuration file to ConstraintContainer. To parse it,
 * you need to
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class SecurityDomParser {

    private File file;
    private Document doc;

    public SecurityDomParser(String filePath) {
        this.file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParsingSecurityXMLException();
        }
        doc.getDocumentElement().normalize();
    }

    public ConstraintsContainer parse() {

        NodeList nList = doc.getElementsByTagName("constraint");

        Map<String, List<String>> result = new HashMap<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String url = eElement.getElementsByTagName("url-pattern").item(0).getTextContent();
                String roles = eElement.getElementsByTagName("role").item(0).getTextContent();
                List<String> list = new ArrayList<>(Arrays.asList(roles.split(",")));
                result.put(url, list);
            }
        }
        return new ConstraintsContainer(result);
    }

}
