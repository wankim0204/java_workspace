package day1126.calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CalendarApp extends Application{
	ChoiceBox ch_yy; //연도
	ChoiceBox ch_mm;//월
	TilePane tilePane;
	
	public void start(Stage stage) throws Exception {
		BorderPane borderPane = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1126/calendar/layout.fxml"));
		
		//루트 하위에 등록된 객체 찾아나서기~~!
		//js의 document.getElemnetById("ch_yy"); 와 원리가 같다!!
		ch_yy=(ChoiceBox)borderPane.lookup("#ch_yy");
		ch_mm=(ChoiceBox)borderPane.lookup("#ch_mm");
		tilePane=(TilePane)borderPane.lookup("#tilePane");
		
		initDate(); //초이스박스 초기화!!

		//49개의 셀을 생성하여, 보더페인의 센터에 부착!!
		for(int i=0;i<7*6;i++) {
			Box box = new Box(Integer.toString(i),100,100);
			tilePane.getChildren().add(box);
		}
		
		showWindow(stage, borderPane);
	}
	
	public void initDate() {
		for(int i=2020;i>=1990;i--) {
			ch_yy.getItems().add(i);
		}
		//ch_yy.getSelectionModel().select(0);//n번째 요소가 선택되어 있게... 
		ch_yy.getSelectionModel().selectFirst();//무조건 처음요소가 선택되어 있게..
		
		for(int i=1;i<=31;i++) {
			ch_mm.getItems().add(i);
		}
		ch_mm.getSelectionModel().selectFirst();
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s=new Scene(parent);//씬 생성
		stage.setScene(s);//생성된 씬을 윈도우에 적용 
		stage.setWidth(800);//너비
		stage.setHeight(700);//높이
		stage.show();//윈도우 보여주기
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
