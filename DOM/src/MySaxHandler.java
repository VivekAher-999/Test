

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
public class MySaxHandler extends DefaultHandler
{
	public void startDocument()
	{
		System.out.println("Document Being here");
	}
	public void startElement(String uti,String localName,String qName,Attributes attrs)
	{
			System.out.println("<"+qName+">");
	}
	public void characters(char ch[],int start,int len)
	{
		System.out.print(new String(ch,start,len));
	}
	public void endElement(String uti,String localName,String qName)
	{
		System.out.println("<"+qName+">");
	}
	public void endDocument()
	{
		System.out.println("Documents End Here");
	}
	
public static void main(String[] args) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException 
{
	SAXParser p=SAXParserFactory.newInstance().newSAXParser();
	p.parse(new FileInputStream("c:/DataFile/students.xml"),new MySaxHandler());

	}

}
