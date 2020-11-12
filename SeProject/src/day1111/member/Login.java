package day1111.member;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class Login extends JPanel{
	JPanel p_container;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_regist;
	JButton bt_login;
	BoardApp boardApp;
	
	public Login(BoardApp boardApp) {
		this.boardApp=boardApp;
		
		p_container = new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		bt_regist = new JButton("회원가입");
		bt_login = new JButton("로그인");
		
		p_container.setPreferredSize(new Dimension(400, 150));
		
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(bt_regist);
		p_container.add(bt_login);
		
		add(p_container);
		
		setVisible(true);
		
		bt_regist.addActionListener((e)->{
			boardApp.setPage(BoardApp.MEMBER_REGIST);
		});
		
		//로그인 버튼과 리스너 연결 
		bt_login.addActionListener((e)->{
			login();
		});
	}
	
	//43분까지~!!
	public void login() {
		
		//회원입니다,  회원이 아닙니다
		Connection con=null;
		PreparedStatement pstm=null;;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "user1104", "user1104");
			String sql="select * from board_member where m_id=? and m_pass=?";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}








