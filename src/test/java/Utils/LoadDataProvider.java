package Utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LoadDataProvider {

    public static Object[][] readXMLFile(String fileName) {
        try {
            File xmlFile = new File("src/test/java/Data/DataSet/"+fileName+".xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("data");
            List<Object[]> data = new ArrayList<>();
            List<String> fieldNames = new ArrayList<>();

            if (nodeList.getLength() > 0) {
                Element firstElement = (Element) nodeList.item(0);
                NodeList childNodes = firstElement.getChildNodes();

                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node node = childNodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        String fieldName = node.getNodeName();
                        fieldNames.add(fieldName);
                    }
                }
            }

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Object[] row = new Object[fieldNames.size()];
                    int j = 0;
                    for (String fieldName : fieldNames) {
                        String fieldValue = element.getElementsByTagName(fieldName).item(0).getTextContent();
                        row[j] = fieldValue;
                        j++;
                    }

                    data.add(row);
                }
            }

            Object[][] result = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
                result[i] = data.get(i);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
