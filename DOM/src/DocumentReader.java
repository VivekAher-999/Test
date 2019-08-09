

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocumentReader {

	public static void main(String[] args) throws ParserConfigurationException 
	{
		
		try {
			File xmlfile=new File("c:/DataFile/staff.xml");
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(xmlfile);
			
			System.out.println("Root Element "+doc.getDocumentElement().getNodeName());
			
			NodeList nlist=doc.getElementsByTagName("staff");
			
			System.out.println("--------------"+nlist.getLength());
			
			for(int i=0;i<nlist.getLength();i++)
			{
				Node nNode=nlist.item(i);
				
				System.out.println("\nThe current Element  "+nNode.getNodeName());
				
				if(nNode.getNodeType()==Node.ELEMENT_NODE)
				{
					Element eElement=(Element) nNode;
					
					System.out.println("Staff is "+eElement.getAttribute("id"));
					System.out.println("FirstName is "+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("LastName is "+eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("NickName is "+eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary is "+eElement.getElementsByTagName("salary").item(0).getTextContent());
				}
				
			}
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
