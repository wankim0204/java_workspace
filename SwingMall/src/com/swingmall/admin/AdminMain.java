package com.swingmall.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.admin.board.Board;
import com.swingmall.admin.member.Member;
import com.swingmall.admin.order.Order;
import com.swingmall.admin.product.Product;
import com.swingmall.util.db.DBManager;

public class AdminMain extends JFrame{
	//상수 선언
	public static final int WIDTH=1200;
	public static final int HEIGHT=900;
	public static final int HOME=0;
	public static final int PRODUCT=1;//상품관리
	public static final int MEMBER=2; //회원정보
	public static final int ORDER=3;//주문관리
	public static final int BOARD=4;//게시판관리
		
	JPanel user_container;//관리자,사용자 화면을 구분지을수 있는 컨테이너

	JPanel p_navi; //웹사이트의 주 메뉴를 포함할 컨테이너 패널
	
	String[] navi_title= {"Home","상품관리","회원정보","주문관리","게시판관리"};
	JButton[] navi=new JButton[navi_title.length];//[][][][][] 배열생성
	
	//페이지 구성 
	Page[] page =new Page[5];
	
	JLabel la_footer;//윈도우 하단의 카피라이트 영역
	DBManager dbManager;
	Connection con;
	
	
	public AdminMain() {
		dbManager = new DBManager();
		user_container = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);
		
		con=dbManager.connect();
		if(con==null) {
			JOptionPane.showMessageDialog(this,"데이터베이스에 접속할 수 없습니다.");
			System.exit(0);
		}else {
			this.setTitle("SwingMall 관리자로 이용중입니다.");
		}
		
		
		//메인 네비게이션 생성 
		for(int i=0;i<navi.length;i++) {
			navi[i] = new JButton(navi_title[i]);
			navi[i].setBackground(Color.BLACK);
			navi[i].setForeground(Color.WHITE);
			p_navi.add(navi[i]);//패널에 네비게이션 부착
		}
		
		//페이지 구성
		page[0] = new Home(this);
		page[1] = new Product(this);
		page[2] = new Member(this);
		page[3] = new Order(this);
		page[4] = new Board(this);
		
		//스타일적용
		user_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		user_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black",Font.BOLD,19));
		
		//조립 
		user_container.setLayout(new BorderLayout());
		user_container.add(p_navi, BorderLayout.NORTH);
		
		user_container.add(page[AdminMain.PRODUCT]);//센터에 페이지 부착
		
		this.add(user_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
		setSize(1200,900);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//프레임과 리스너연결 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
			}
		});
	}
	
	public static void main(String[] args) {
		new AdminMain();

	}

}




