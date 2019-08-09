

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DocumentGenerator {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, FileNotFoundException, TransformerException 
	{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder b=factory.newDocumentBuilder();
		Document doc=b.newDocument();
		
		Element rootele=doc.createElement("students");
		Element studentle=doc.createElement("student");
		Element namele=doc.createElement("name");
		Element emaille=doc.createElement("email");
		Element mobilele=doc.createElement("mobile");
		Element addressle=doc.createElement("address");
		
		Text t1=doc.createTextNode("sachin");
		Text t2=doc.createTextNode("aherv99@hh");
		Text t3=doc.createTextNode("12434");
		Text t4=doc.createTextNode("niphad");
		
		
		namele.appendChild(t1);
		emaille.appendChild(t2);
		mobilele.appendChild(t3);
		addressle.appendChild(t4);
		
		studentle.appendChild(namele);
		studentle.appendChild(emaille);
		studentle.appendChild(mobilele);
		studentle.appendChild(addressle);
		
		rootele.appendChild(studentle);
		doc.appendChild(rootele);
		
		Transformer t=TransformerFactory.newInstance().newTransformer();
		t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream("c:/DataFile/students.xml")) );
		System.out.println("XML FILE IS GENERATED");
		
		
		
		

	}

}
