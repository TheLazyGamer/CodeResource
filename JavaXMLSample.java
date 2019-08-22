import java.io.StringReader;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 
 
public class JavaXMLSample {
    public static void main(String[] argv) throws Exception {
 
        //https://www.mkyong.com/java/how-to-modify-xml-file-in-java-dom-parser/
 
        /*
         * This is used to read in XML from a file
        String filepath = "c:\\file.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);
         */
 
        //Do XML stuff
 
        /*
         * Write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
         */
 
        String xmlSample = "<?xml version=\"1.0\"?>" +
                "<?xml-stylesheet type=\"text/css\" href=\"nutrition.css\"?>" +
                "<nutrition>" +
                "    <daily-values>" +
                "        <total-fat units=\"g\">65</total-fat>" +
                "        <saturated-fat units=\"g\">20</saturated-fat>" +
                "        <cholesterol units=\"mg\">300</cholesterol>" +
                "        <sodium units=\"mg\">2400</sodium>" +
                "        <carb units=\"g\">300</carb>" +
                "        <fiber units=\"g\">25</fiber>" +
                "        <protein units=\"g\">50</protein>" +
                "    </daily-values>" +
                "<foods>" +
                "<food>" +
                "        <name>Avocado Dip</name>" +
                "        <mfr>Sunnydale</mfr>" +
                "        <serving units=\"g\">29</serving>" +
                "        <calories total=\"110\" fat=\"100\" />" +
                "        <total-fat>11</total-fat>" +
                "        <saturated-fat>3</saturated-fat>" +
                "        <cholesterol>5</cholesterol>" +
                "        <sodium>210</sodium>" +
                "        <carb>2</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>1</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>0</ca>" +
                "            <fe>0</fe>" +
                "        </minerals>" +
                "    </food>" +
                "<food>" +
                "        <name>Bagels, New York Style </name>" +
                "        <mfr>Thompson</mfr>" +
                "        <serving units=\"g\">104</serving>" +
                "        <calories total=\"300\" fat=\"35\" />" +
                "        <total-fat>4</total-fat>" +
                "        <saturated-fat>1</saturated-fat>" +
                "        <cholesterol>0</cholesterol>" +
                "        <sodium>510</sodium>" +
                "        <carb>54</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>11</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>8</ca>" +
                "            <fe>20</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Beef Frankfurter, Quarter Pound </name>" +
                "        <mfr>Armitage</mfr>" +
                "        <serving units=\"g\">115</serving>" +
                "        <calories total=\"370\" fat=\"290\" />" +
                "        <total-fat>32</total-fat>" +
                "        <saturated-fat>15</saturated-fat>" +
                "        <cholesterol>65</cholesterol>" +
                "        <sodium>1100</sodium>" +
                "        <carb>8</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>13</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>2</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>1</ca>" +
                "            <fe>6</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Chicken Pot Pie</name>" +
                "        <mfr>Lakeson</mfr>" +
                "        <serving units=\"g\">198</serving>" +
                "        <calories total=\"410\" fat=\"200\" />" +
                "        <total-fat>22</total-fat>" +
                "        <saturated-fat>9</saturated-fat>" +
                "        <cholesterol>25</cholesterol>" +
                "        <sodium>810</sodium>" +
                "        <carb>42</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>10</protein>" +
                "        <vitamins>" +
                "            <a>20</a>" +
                "            <c>2</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>2</ca>" +
                "            <fe>10</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Cole Slaw</name>" +
                "        <mfr>Fresh Quick</mfr>" +
                "        <serving units=\" cup\">1.5</serving>" +
                "        <calories total=\"20\" fat=\"0\" />" +
                "        <total-fat>0</total-fat>" +
                "        <saturated-fat>0</saturated-fat>" +
                "        <cholesterol>0</cholesterol>" +
                "        <sodium>15</sodium>" +
                "        <carb>5</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>1</protein>" +
                "        <vitamins>" +
                "            <a>30</a>" +
                "            <c>45</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>4</ca>" +
                "            <fe>2</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Eggs</name>" +
                "        <mfr>Goodpath</mfr>" +
                "        <serving units=\"g\">50</serving>" +
                "        <calories total=\"70\" fat=\"40\" />" +
                "        <total-fat>4.5</total-fat>" +
                "        <saturated-fat>1.5</saturated-fat>" +
                "        <cholesterol>215</cholesterol>" +
                "        <sodium>65</sodium>" +
                "        <carb>1</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>6</protein>" +
                "        <vitamins>" +
                "            <a>6</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>2</ca>" +
                "            <fe>4</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Hazelnut Spread</name>" +
                "        <mfr>Ferreira</mfr>" +
                "        <serving units=\"tbsp\">2</serving>" +
                "        <calories total=\"200\" fat=\"90\" />" +
                "        <total-fat>10</total-fat>" +
                "        <saturated-fat>2</saturated-fat>" +
                "        <cholesterol>0</cholesterol>" +
                "        <sodium>20</sodium>" +
                "        <carb>23</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>3</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>6</ca>" +
                "            <fe>4</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Potato Chips</name>" +
                "        <mfr>Lees</mfr>" +
                "        <serving units=\"g\">28</serving>" +
                "        <calories total=\"150\" fat=\"90\" />" +
                "        <total-fat>10</total-fat>" +
                "        <saturated-fat>3</saturated-fat>" +
                "        <cholesterol>0</cholesterol>" +
                "        <sodium>180</sodium>" +
                "        <carb>15</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>2</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>10</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>0</ca>" +
                "            <fe>0</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Soy Patties, Grilled</name>" +
                "        <mfr>Gardenproducts</mfr>" +
                "        <serving units=\"g\">96</serving>" +
                "        <calories total=\"160\" fat=\"45\" />" +
                "        <total-fat>5</total-fat>" +
                "        <saturated-fat>0</saturated-fat>" +
                "        <cholesterol>0</cholesterol>" +
                "        <sodium>420</sodium>" +
                "        <carb>10</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>9</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>0</ca>" +
                "            <fe>0</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    <food>" +
                "        <name>Truffles, Dark Chocolate</name>" +
                "        <mfr>Lyndon's</mfr>" +
                "        <serving units=\"g\">39</serving>" +
                "        <calories total=\"220\" fat=\"170\" />" +
                "        <total-fat>19</total-fat>" +
                "        <saturated-fat>14</saturated-fat>" +
                "        <cholesterol>25</cholesterol>" +
                "        <sodium>10</sodium>" +
                "        <carb>16</carb>" +
                "        <fiber>666</fiber>" +
                "        <protein>1</protein>" +
                "        <vitamins>" +
                "            <a>0</a>" +
                "            <c>0</c>" +
                "        </vitamins>" +
                "        <minerals>" +
                "            <ca>0</ca>" +
                "            <fe>0</fe>" +
                "        </minerals>" +
                "    </food>" +
                "    </foods>" +
                "</nutrition>" +
                "<!--" +
                "<food>" +
                "   <name></name>" +
                "   <mfr></mfr>" +
                "   <serving units=\"g\"></serving>" +
                "   <calories total=\"\" fat=\"\"/>" +
                "   <total-fat></total-fat>" +
                "   <saturated-fat></saturated-fat>" +
                "   <cholesterol></cholesterol>" +
                "   <sodium></sodium>" +
                "   <carb></carb>" +
                "   <fiber></fiber>" +
                "   <protein></protein>" +
                "   <vitamins>" +
                "       <a></a>" +
                "       <c></c>" +
                "   </vitamins>" +
                "   <minerals>" +
                "       <ca></ca>" +
                "       <fe></fe>" +
                "   </minerals>" +
                "</food>" +
                "-->";
 
        Document sampleDoc = convertStringToDocument(xmlSample);
        sampleDoc.getDocumentElement().normalize();
        Element sampleEle = sampleDoc.getDocumentElement();
        NodeList sampleNL = sampleEle.getChildNodes();
 
        for (int i = 0; i < sampleNL.getLength(); i++) {
            Node innerSampleNode = (Node) sampleNL.item(i);
 
            //Whitespace between nodes (which are elements) can cause freakish ghost #text to appear
            //This if check prevents that. Always use it.
            if (innerSampleNode.getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = innerSampleNode.getNodeName();
                System.out.println(nodeName + " see1");
                System.out.println(innerSampleNode.getTextContent());
                System.out.println("=====================");
 
                if (nodeName.equals("daily-values")) {
                    printTags(innerSampleNode);
                }
                else {
                    Element foodsEle = (Element) innerSampleNode;
                    System.out.println(foodsEle.getTagName() + " see2");
                    System.out.println(foodsEle.getNodeName() + " see3");
                    NodeList foodList = foodsEle.getElementsByTagName("food");
                    System.out.println(foodList.getLength());
                    for (int n = 0; n < foodList.getLength(); n++) {
                        Node foodNode = (Node) foodList.item(n);
                        System.out.println("FN " + foodNode.getTextContent());
 
                        if (foodNode.getNodeType() == Node.ELEMENT_NODE) {
 
                            //Update the sodium text amount
                            Element foodEle = (Element) foodNode;
                            Node sodium = foodEle.getElementsByTagName("sodium").item(0);
                            sodium.setTextContent("2000000");
 
                            // append a new node to each food
                            Element transFat = sampleDoc.createElement("trans-fat");
                            transFat.appendChild(sampleDoc.createTextNode("3"));
                            foodNode.appendChild(transFat);
 
                            // update serving attribute to use ounces
                            Node servingNode = foodEle.getElementsByTagName("serving").item(0);
                            NamedNodeMap attr = servingNode.getAttributes();
                            Node nodeAttr = attr.getNamedItem("units");
                            nodeAttr.setTextContent("oz");
                            System.out.println("nodeAttr: " + nodeAttr);
                            System.out.println("n val " + n);
 
                            // remove a node
                            Node fiber = foodEle.getElementsByTagName("fiber").item(0);
                            System.out.println("fiber1: " + fiber.getTextContent());
                            System.out.println("fiber " + fiber);
                            foodNode.removeChild(fiber);
                           
                           
                            //Get the inner elements of an inner parent node
                            Node minerals = foodEle.getElementsByTagName("minerals").item(0);
                            NodeList mineralsList = minerals.getChildNodes();
 
                            for (int mineralsCnt = 0; mineralsCnt < mineralsList.getLength(); mineralsCnt++) {
                                Node mineralNode = (Node) mineralsList.item(mineralsCnt);
                               
 
                                if (mineralNode.getNodeType() == Node.ELEMENT_NODE) {
                                    System.out.println("MN " + mineralNode.getNodeName());
                                    System.out.println("MN " + mineralNode.getTextContent());
                                }
                            }
 
                        }
                    }
                }
 
 
 
                //String sdaf = foodEle.getElementsByTagName("name").item(0).getTextContent();
            }
        }
 
        //TODO print out entire xml
 
    }
 
    private static Document convertStringToDocument(String xmlStr) {
 
        //Boilerplate to convert a string to an XML Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) );
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return null;
    }
 
    public static void printTags(Node nodes){
        if(nodes.hasChildNodes()  || nodes.getNodeType()!=3){
            System.out.println("PT " + nodes.getNodeName()+" : "+nodes.getTextContent());
            NodeList nl=nodes.getChildNodes();
            for(int j=0;j<nl.getLength();j++)printTags(nl.item(j));
        }
    }
}