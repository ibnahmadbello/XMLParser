
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {

    public static void main(String[] args) {
        
        try {
            // Access input data file and create document builder
            File inputDataFile = new File("sampleXML.txt");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputDataFile);
            document.getDocumentElement().normalize();
            System.out.println("Name of the Root element:" + document.getDocumentElement().getNodeName());
            
            // Create node list
            NodeList nodeList = document.getElementsByTagName("employee");
            System.out.println("***************************************");
            // Iterate through the node list and extract values
            for(int tempval = 0; tempval < nodeList.getLength(); tempval++){
                Node node = nodeList.item(tempval);
                System.out.println("\n Name of the current element : " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Employee ID : " + element.getAttribute("empid"));
                    System.out.println("Employee First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Employee Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Employee Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Employee Salary : " + element.getElementsByTagName("salary").item(0).getTextContent());
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
