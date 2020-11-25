/*
 * AWT/Swing에서는 부분적으로나마 html이 적용될 수 있으나, 
 * javascript는 실행될 수 없다!!
 * */
package day1125.web;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class WebViewApp extends Application{
	WebView webView; //HTML문서를 포함할 수 있는 컨테이너

	public void start(Stage stage) throws Exception {
		//youtubu 삽입하기!!
		webView = new WebView();
		webView.getEngine().load("file:///D:/workspace/js_workspace/project1008/%EB%B9%84%ED%96%89%EA%B8%B0%EA%B2%8C%EC%9E%84.html");
		webView.setPrefSize(1200, 900);
		
		showWindow(stage, webView);
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s=new Scene(parent);//씬 생성
		stage.setScene(s);//생성된 씬을 윈도우에 적용 
		stage.setWidth(1200);//너비
		stage.setHeight(900);//높이
		stage.show();//윈도우 보여주기
	}
	public static void main(String[] args) {
		launch(args);
	}

}
