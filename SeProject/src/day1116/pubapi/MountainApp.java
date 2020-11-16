package day1116.pubapi;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
/*
 * 코드를 붙여 넣으시고, 클래스명은 MountainApp 로 해주세요
 * 이제 아래의 샘플 코드에서, 여러분이 보유한 api key로 바꿔야 합니다.
 * api key를 복사해 오세요!!!
 *  
 * */
public class MountainApp {
	
    public static void main(String[] args) throws IOException {
    	String apiKey = "TPK6sq5VdCOFrijK99CmJHQCEVer9GwK4sxLvP6ED6dBExrBc6FO298QjQadJsw7C4sDZ8yBXJfsYZ%2FVT6LG0A%3D%3D"; // 이 안에 키값을 복사해서 붙여넣으세요
    	
    	//이제 이 키값을 코드 사이에 넣을께요  '서비스키'라는 한글대신에 키값을 넣으세요 
    	//그리고 주의할 점은, 아래의  StringBuilder에 적힌 주소가 , 공공뎅이터포털 개발자의 실수에 의해 가끔 올바르지 않을 수 있어요
    	//그래서, 주소를 비교해 보는게 중요해요 
    	//두 주소를 비교해 보세용 (같아야 합니다) 
    	//다행히, 이번엔 실수가 없었네요, 공공데이터포털이 가끔 실수를 합니다..
    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice(홈페이지 게제 url)
    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice(샘플코드  url)
    	//이제 프로그램 실행해 보세요~~
    	//저는 지리산 정보가 잘 나와줍니다..여러분도 그런가요?
    	//근데 , 잘 나오긴 하지만 식별성이 떨어지니, 복사해서 이클립스 xml문서로 가져와 봅시다
    	//결과  xml을 복사해주세요~~~
    	//이클립스에서 빈 xml 문서를 만듭시다 
    	//같은 패키지에요 
    	//이제부터 이 xml을 파싱을 할거에요, 아래의 xml은 그냥  xml이기때문에, 원하는 데이터로
    	//재가공합시다...클래스 파일 하나 만들께요  
    	
        StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode("지리산", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}