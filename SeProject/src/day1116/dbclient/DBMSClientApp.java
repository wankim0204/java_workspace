/*
 *DBeaver 수준은 아니어도, 딕셔너리를 학습하기 위해 데이터베이스 접속 클라이언트를 자바로 만들어본다 
   실무에서는,  SQLPlus를 잘 사용하지 않음..이유) 업무효율성이 떨어지기 때문임 
   				그럼 언제쓰나? 실무현장에서는 개발자의 pc 에는 각종 개발툴들이 있지만, 실제적인 운영 서버에는 
   				보안상 아무것도 설치해서는 안된다. 따라서 서버에는 툴들이 없기때문에 만일 오라클을 유지보수하러 파견을
   				나간 경우, 콘솔창 기반으로 쿼리를 다뤄야할 경우가 종종 있다..이때 SQLPlus 를 써야함..
   				아셧쬬?
개발자들이 개발할때 데이터베이스 다루는 툴을 "데이터베이스 접속 클라이언트"라고 부른다
이러한 툴 들중 꽤 유명한 제품은 Toad, 등이 있다..(유료)    				
Toad는  DBeaver에 비해 기능이 막강하지만 유료이기에, 우리는 DBeaver 를 사용하고 있음    				
 * */
package day1116.dbclient;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DBMSClientApp extends JFrame{
	JPanel p_west; //서쪽 영역 패널 
	Choice ch_users; //유저명이 출력될 초이스 컴포넌트 
	JPasswordField t_pass;//비밀번호 텍스트 필드 
	JButton bt_login; //접속 버튼
	
	JPanel p_center;//그리드가 적용될 센터패널
	JTable t_tables;//유저의 테이블 정보를 출력할 JTable
	JTable t_seq;//유저의 시퀀스 정보를 출력할 JTable
	JScrollPane s1,s2;//스크롤  2개 준비
	
	public DBMSClientApp() {
		//생성
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		p_center= new JPanel();
		p_center.setLayout(new GridLayout(2, 1)); //2층에 1호수
		t_tables = new JTable();
		t_seq = new JTable();
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		
		//스타일 
		p_west.setPreferredSize(new Dimension(150, 350));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		
		//조립 
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		p_center.add(s1);
		p_center.add(s2);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setSize(700,350); //700으로 늘려주세요
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new DBMSClientApp();
	}

}





