package day1111.json;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonGallery extends JFrame{
	JPanel p_center; //그리드를 적용할 가운데 패널
	JPanel p_south; //썸네일을 부착할 남쪽패널 
	JPanel p_can; //큰 그림이 그려질 패널 
	JPanel p_detail; //상세내용이 출력될 패널
	
	public JsonGallery() {
		p_center = new JPanel();
		p_south = new JPanel();
		p_can = new JPanel();
		p_detail = new JPanel();
			
		p_center.setLayout(new GridLayout(1, 2));//1층 2호수 그리드 적용 
		
		//스타일 적용
		p_center.setBackground(Color.yellow);
		p_south.setPreferredSize(new Dimension(800, 100));
		p_south.setBackground(Color.green);
		p_can.setBackground(Color.PINK);
		p_detail.setBackground(Color.ORANGE);
		
		//조립 
		p_center.add(p_can); //1층 1호수에 넣기
		p_center.add(p_detail); //1층 2호호수에 넣기
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);			
	}
	
	//영화 썸네일 생성하기!
	public void createThumb() {
		BufferedReader buffr=null;
		
		try {
			//클래스패스상에 있는 텍스트 파일 읽기 
			URL url = this.getClass().getClassLoader().getResource("res/data.json");
			URI uri=url.toURI();//URL을 URI로 변경
			FileReader reader=new FileReader(new File(uri));
			buffr = new BufferedReader(reader);
			
			StringBuffer sb = new StringBuffer();
			String data=null;
			while(true) {
				data=buffr.readLine();
				if(data==null)break;
				sb.append(data);
			}
			System.out.println(sb.toString());//모아진 스트링 출력해본다!!
			
			//파싱 
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject=(JSONObject)jsonParser.parse(sb.toString());//문자열에 불과했던 json 표기법문자열을 실제 json객체로 반환!!
			JSONArray jsonArray=(JSONArray)jsonObject.get("marvel");
			
			//따라서 이 시점부터 마치 객체처럼 접근하여 사용이 가능하다!! 
			for(int i=0;i<jsonArray.size();i++) {
				JSONObject obj=(JSONObject)jsonArray.get(i); //영화 한편 반환!!
				
				System.out.println(obj.get("title")); //토르 
				System.out.println(obj.get("phase")); //어셈블드..
				
				Thumbnail thumbnail = new Thumbnail(45, 45, (String)obj.get("url"));
				p_south.add(thumbnail);//생성된 썸네일을 p_south 패널에 부착!
				p_south.updateUI();
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JsonGallery();

	}

}







