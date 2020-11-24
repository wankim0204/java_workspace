package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//StackPane : Stack구조로 쌓을수 있는 레이아웃 AWT의 CardLayout과 동일한 기능 
//CardLayout 은 페이지 처리에 사용되지만, 우리는 페이지 전환 처리를 직접 제작하여 ,CardLayout을 
//사용할 필요가 없었음..
public class StackPaneApp extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		StackPane parent=new StackPane();
		//버튼4개를 쌓을 예정 
		
	}
	public void showWindow(Stage stage, Parent parent) {
		Scene s=new Scene(parent);//씬 생성
		stage.setScene(s);//생성된 씬을 윈도우에 적용 
		stage.setWidth(500);//너비
		stage.setHeight(500);//높이
		stage.show();//윈도우 보여주기
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}






