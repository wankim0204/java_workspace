package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MTMain2 extends JFrame{
	/*서쪽영역 */
	JPanel p_west; 
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	//다 지우세요, tablemodel에서 구현할거니까요
	JTable table;
	/*JTable 에서 지원하는 Vector방식은 2차원배열보다는 유연하지만 
	   여전히 2차원배열의 구조를 유지하므로, TableModel을 이용한 백터 및 VO를 종합해서 개발해보겠슴 
	 * */
	MountainModel model;
	JScrollPane scroll;
	
	//멤버변수로 파서 보유하기 
	String apiKey = "TPK6sq5VdCOFrijK99CmJHQCEVer9GwK4sxLvP6ED6dBExrBc6FO298QjQadJsw7C4sDZ8yBXJfsYZ%2FVT6LG0A%3D%3D";
	SAXParserFactory factory;
	SAXParser saxParser;
	Thread loadThread; //네트워크상에서 xml을 불러올때 사용할 쓰레드, 버튼을 누를때마다 인스턴스 생성하여
									//네트워크 업무 시키자!!
	
	InputStream is;//xml 데이터를 담고 있는 스트림
	MountainHandler mountainHandler;
	
	//파싱이 끝나면 닫아주기 위해 멤버변수로 선언함
	HttpURLConnection conn;
	BufferedReader rd;
	
	/*
	 * JTable에서 데이터 연동시 지금까지는 이차원 배열만 써왔는데, 사실 이차원 배열은 
	 * 생성시 크기를 정해야 하기 때문에 불편한 점이 많습니다.
	 * ( 불편햇던 예: rs.last()  후  rs.getRow()로 데이터 총 수 구하고,다시 커서를 원상복귀 시킴..난리남)
	 * 동의하심? ㅋㅋ 미투
	 * 따라서 컬렉션 프레임웍중 Vector를 지원하는 생성자를 이용해봅시다!!
	 * */
	
	public MTMain2() {
		//생성
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("검색하기");

		//테이블모델을 이용한 개발방식으로 감	
		table = new JTable(model = new MountainModel()); 
		scroll = new JScrollPane(table);
		
		//생성자에서 쓰레드를 내부익명으로 처리하겠습니다 
		//이코드는 이제 하지 마세요, 최초에 생성자에서 한번만 생성하니깐 문제가 생긴거니까요,
		//따라서 이 코드는 버튼 누를때 시점으로 내리겠습니다
		
		//스타일 적용 
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//부착 
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		//버튼과 리스너 연결
		bt.addActionListener((e)->{
			//네트워크를 타고 데이터를 가져올때 메인쓰레드에서 진행하는게 좋다고 했었나요? ㅋㅋ 네 이렇게 하면 안됩니당
			loadThread = new Thread() {
				public void run() { //버튼을 누를때 이 쓰레드를 호출하겠습니다
					loadXML();
				}
			};
			loadThread.start(); //xml로딩 쓰레드 호출
		});
		
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//아직 파싱하는 작업이라기보다는 URL 에서 xml을 가져오는 단계이므로 메서드명을 살짝 바꿔줍시다
	public void loadXML() { //이 명칭이 더 직관적일듯합니다
		//여기에, 공공데이터 포털에서 공개한 소스코드를 붙여넣을께요!!!, 키값은 멤버변수에 선언해 주세요 
		//아래의 코드를 모두 자동으로 예외처리 나오게 단축키 이용하세요
        try {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode(t_name.getText(), "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			    rd = new BufferedReader(new InputStreamReader(is=conn.getInputStream()));
			} else {
			    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			//아래의 코드는 화면에 출력하기 위한 코드이므로, 테스트가 끝나면 제거해야 한다..
			//이유? read를 여기서 해버리면 이후의 라인에서는 스트림의 끝에 도달하게 되므로, 즉 사용전에 써버렸으므로..
			//파싱도 하기 전에 소모시키지 말자!!
			/*
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
			    sb.append(line);
			}
			*/
			//제대로 불러와 지는지, sb 를 콘솔에 출력해봅시다!!! 실행해보세요~!~!
			//제대로 되고 있습니다 이제 파싱만 하면 되겠네요,  xml을..메서드를 따로 정의할께요 파싱용 메서드
			//System.out.println(sb.toString());
			
			parseData();// 이 시점부터 파싱 시작!!
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	/*
	 * 주의) 지금 파싱할 데이터는 
	 * 1) xml파일로 존재할까요? 
	 * 2) 메모리상에서 텍스트로 존재할까요?
	 * 
	 * 저번주 예제에서는 xml 파일로 보유한 후 파싱했지만, 공공데이터 포털의 api는 메모리상에서 불러와서 처리해야 해요 
	 * 그래서 parsing 할때 오버로딩 된 메서드를 잘 선택해야 합니다
	 * 
	 * */
	public void parseData() {
		factory=SAXParserFactory.newInstance(); //팩토리 객체 생성( 이 객체가 있어야 파서를 생성함) 
		try {
			saxParser = factory.newSAXParser(); //파서 생성
			saxParser.parse(is, mountainHandler = new MountainHandler()); //파싱 시작!!!
			
			//파싱이 끝나면 TableModel의 백터객체를 파싱한 결과로 얻은 백터로 대체해버리면 된다!!
			model.data = mountainHandler.mtList;
			table.updateUI(); //테이블 갱신
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null)conn.disconnect();
		}
	}
	
	public static void main(String[] args) {
		new MTMain2();

	}

}




