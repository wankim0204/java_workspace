package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Login extends Page{
	JPanel p_content;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_login;
	JButton bt_regist;
	
	public Login(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		t_id = new JTextField();
		t_pass = new JPasswordField();
		bt_login = new JButton("Login");
		bt_regist = new JButton("회원가입");
		
		//스타일 
		p_content.setPreferredSize(new Dimension(300, 125));
		p_content.setBackground(Color.WHITE);
		t_id.setPreferredSize(new Dimension(280, 25));
		t_pass.setPreferredSize(new Dimension(280, 25));
		
		//조립
		p_content.add(t_id);
		p_content.add(t_pass);
		p_content.add(bt_login);
		p_content.add(bt_regist);
		
		add(p_content);
		
		t_id.requestFocus();//아이디 컴포넌트에 포커스 올리기
		
		//회원가입 버튼과 리스너 연결 
		bt_regist.addActionListener((e)->{
			getShopMain().showPage(ShopMain.MEMBER_REGIST);
		});
		
		//로그인 버튼과 리스너연결 
		bt_login.addActionListener((e)->{
			login();
		});
		
		//키보드 리스너 연결
		t_id.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {//엔터치면..
					login();					
				}
			}
		});
		t_pass.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {//엔터치면..
					login();					
				}
			}
		});
	}
	public void validCheck(ShopMember shopMember) {
		if(shopMember.getMid().length()<1) {//문자열의 길이가 0이라면..
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
		}else if(shopMember.getPass().length()<1) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
		}else {
			login(shopMember);
		}		
	}
	
	//회원 로그인 처리 메서드 정의: 로그인 성공 후 Home을 보여 줄 예정임
	//아래의 메서드가 ShopMember를 반환하므로, 만일 로그인 실패한 경우에는
	//null을 반환받아 간다!! 
	public ShopMember login(ShopMember shopMember) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ShopMember vo=null; //로그인 성공 후 회원의 모든 정보를 담게될 VO		
		
		String sql="select * from shop_member ";
		sql+=" where mid=? and pass=?";//입력한 아이디와 비번이 회원테이블에 존재하는지 여부를 판단해야함
		try {
			pstmt=getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			rs=pstmt.executeQuery();
			
			//rs.next() 가 참이면, 회원이 존재하는 것이므로 로그인으로 인정해 주자!!
			//회원정보를  vo에 옮겨담자!!
			if(rs.next()){
				vo = new ShopMember(); //회원이 존재할때는 vo 생성
				
				vo.setMember_id(rs.getInt("member_id"));
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getNString("name"));
				vo.setPhone(rs.getNString("phone"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
		return vo;
	}
}














