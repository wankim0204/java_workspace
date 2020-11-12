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
	
	/*
	 * 데이터베이스 연결을 모든 메서드마다 ,접속~끊기를 반복한다면 코드중복문제가 발생할 것이고
	 * 효율성도 없을것이므로 , 프로그램 가동과 동시에 한번 접속해놓고, 프로그램 종료할때에 한번 접속해제하는게 
	 * 좋을것 같음, 따라서 각 페이지에서 접속,해제 처리하지말고 최상위 컨테이너인 JFrame에서 접속 및 해제처리를 
	 * 하겠음.
	 * */
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








