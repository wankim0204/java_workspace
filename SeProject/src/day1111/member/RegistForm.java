package day1111.member;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class RegistForm extends JPanel{
	JPanel p_container;//묶기위한 컨테이너
	JTextField t_id;
	JPasswordField t_pass;
	JTextField t_name;
	JButton bt;
	BoardApp boardApp;
	
	public RegistForm(BoardApp boardApp) {
		this.boardApp=boardApp;
		
		p_container = new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		t_name = new JTextField(30);
		bt = new JButton("가입");
		
		p_container.setBackground(Color.YELLOW);
		p_container.setPreferredSize(new Dimension(400, 200));
		
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(t_name);
		p_container.add(bt);
		
		add(p_container);
		setVisible(true);		
		
		//가입버튼과 리스너 연결 
		bt.addActionListener((e)->{
			regist();
		});
	}
	
	/*
	 * 오라클에 접속하여 insert 실행!! 
	 * 1.드라이버로드 
	 * 2.접속
	 * 3.쿼리문실행
	 * 4.db닫기
	 */	
	public void regist() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}






















