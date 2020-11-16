/*
  SAX Parsing 시 모든 node(요소,텍스트 등 xml을 이루는 요소들을 일컬음)마다 
  이벤트를 발생시켜주는 객체 
 */
package day1116.pubapi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	/*아시죠? 메서드 오버라이드*/
	
	//xml문서가 시작될때 호출되는 메서드 
	public void startDocument() throws SAXException {
	}
	
	//시작태그를 만날때 호출되는 메서드 qName 을 tag로 바꿔주기 
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
	}
	
	//태그 사이의 텍스트를 만날때 호출되는 메서드 
	public void characters(char[] ch, int start, int length) throws SAXException {

	}
	
	//닫는 태그를 만날때 호출되는 메서드 ,qName 을 tag로 바꿔주기 
	public void endElement(String uri, String localName, String tag) throws SAXException {

	}
}















