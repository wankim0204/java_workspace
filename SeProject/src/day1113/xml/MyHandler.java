/*
 *  xml의 모든 노드에서 이벤트가 발생할때마다 아래의 핸들러 객체의
 *  메서드를 알맞게 오버라이드하면 됨.
 * 
 * */
package day1113.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("문서를 시작합니다");
	}
}
