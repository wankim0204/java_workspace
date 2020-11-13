/*
 * SAX 방식의 파싱을 지원하는 핸들러
 * 
 * */
package day1113.xml.down;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MovieHandler extends DefaultHandler{
	public void startDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {

	}
	public void characters(char[] ch, int start, int length) throws SAXException {
	}

	public void endElement(String uri, String localName, String tag) throws SAXException {
	}

	public void endDocument() throws SAXException {

	}
	
}











