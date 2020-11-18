package com.swingmall.main;

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

import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	//상수 선언
	public static final int WIDTH=1200;
	public static final int HEIGHT=900;
	
	
	JPanel usetype_container;//관리자,사용자 화면을 구분지을수 있는 컨테이너

	JPanel p_navi; //웹사이트의 주 메뉴를 포함할 컨테이너 패널
	JButton[] navi=new JButton[5];//[][][][][] 배열생성
	String[] navi_title= {"Home","Product","QnA","MyPage","Login"};
	
	JLabel la_footer;//윈도우 하단의 카피라이트 영역
	DBManager dbManager;
	Connection con;
	
	public ShopMain() {
		dbManager = new DBManager();
		usetype_container = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);
		
		con=dbManager.connect();
		if(con==null) {
			JOptionPane.showMessageDialog(this,"데이터베이스에 접속할 수 없습니다.");
			System.exit(0);
		}else {
			this.setTitle("SwingShop에 오신걸 환영합니다.");
		}
		//스타일적용
		usetype_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		usetype_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black",Font.BOLD,19));
		
		//조립 
		this.add(usetype_container);
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
		new ShopMain();

	}

}




