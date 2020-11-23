package table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Member {
	private StringProperty name;
	private StringProperty phone;
	private StringProperty email;
	
	public Member(String name, String phone, String email) {
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
	}
	
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getPhone() {
		return phone;
	}
	public void setPhone(StringProperty phone) {
		this.phone = phone;
	}
	public StringProperty getEmail() {
		return email;
	}
	public void setEmail(StringProperty email) {
		this.email = email;
	}
	
	
}
