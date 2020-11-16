/*
  SAX Parsing 시 모든 node(요소,텍스트 등 xml을 이루는 요소들을 일컬음)마다 
  이벤트를 발생시켜주는 객체 
 */
package day1116.pubapi;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	//발견되는 산이 있을때 VO로 생성후, 그 vo를 담게될 벡터
	Vector mtList;
	
	//xml문서가 시작될때 호출되는 메서드 
	public void startDocument() throws SAXException {
	}
	
	//시작태그를 만날때 호출되는 메서드 qName 을 tag로 바꿔주기 
	//태그만 출력해봅시다
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">"); //여는 태그 출력
	}
	
	//태그 사이의 텍스트를 만날때 호출되는 메서드 
	public void characters(char[] ch, int start, int length) throws SAXException {

	}
	
	//닫는 태그를 만날때 호출되는 메서드 ,qName 을 tag로 바꿔주기 
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.print("</"+tag+">");//닫는 태그 출력
	}
}















