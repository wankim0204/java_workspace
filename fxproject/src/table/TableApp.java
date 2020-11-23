package table;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableApp extends Application{
	TableView<Member> tableView;
	
	ObservableList<Member> list = FXCollections.observableArrayList();
	
	public void start(Stage stage) throws Exception {
		
		tableView = new TableView<Member>();
		
		TableColumn c1 = new TableColumn("이름");
		TableColumn c2 = new TableColumn("연락처");
		TableColumn c3 = new TableColumn("이메일");
		tableView.getColumns().add(c1);
		tableView.getColumns().add(c2);
		tableView.getColumns().add(c3);
		
		
		tableView.setItems(list);
		
		
		list.add(new Member("batman","010","naver.com"));
		list.add(new Member("superman","010","naver.com"));
		
		
		
		c1.setCellValueFactory(new Callback<CellDataFeatures<Member, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Member, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().getName();
		     }
		  });
		
		c2.setCellValueFactory(new Callback<CellDataFeatures<Member, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Member, String> p) {
				// p.getValue() returns the Person instance for a particular TableView row
				return p.getValue().getPhone();
			}
		});
		
		c3.setCellValueFactory(new Callback<CellDataFeatures<Member, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Member, String> p) {
				// p.getValue() returns the Person instance for a particular TableView row
				return p.getValue().getEmail();
			}
		});
		
		
		//root and show
		VBox parent = new VBox();
		parent.getChildren().add(tableView);
		
		Scene s = new Scene(parent);
		stage.setScene(s);
		stage.show();
		stage.setWidth(500);
		stage.setHeight(500);
	}
	public static void main(String[] args) {
		launch(args);
	}

}
