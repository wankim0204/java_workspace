package day1111.member;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	JButton bt_login;
	BoardApp boardApp;
	
	public RegistForm(BoardApp boardApp) {
		this.boardApp=boardApp;
		
		p_container = new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		t_name = new JTextField(30);
		bt = new JButton("가입");
		bt_login = new JButton("로그인");
		
		p_container.setBackground(Color.YELLOW);
		p_container.setPreferredSize(new Dimension(400, 200));
		
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(t_name);
		p_container.add(bt);
		p_container.add(bt_login);
		
		add(p_container);
		setVisible(true);		
		
		//가입버튼과 리스너 연결 
		bt.addActionListener((e)->{
			regist();
		});
		bt_login.addActionListener((e)->{
			boardApp.setPage(BoardApp.MEMBER_LOGIN);
		});
	}
	
	/*
	 * 오라클에 접속하여 insert 실행!! 
	 * 1.드라이버로드 
	 * 2.접속
	 * 3.쿼리문 실행
	 * 4.db닫기
	 */	
	public void regist() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//1.드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			//2.접속
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			
			//접속이 성공되었을때, 접속 정보를 가진 객체를 Connection 객체라 한다
			//따라서 이 객체의 인스턴스가 만약 null이라면 접속정보가 자체가 없으므로, 접속이 실패한것으로
			//판단한다!!!
			con=DriverManager.getConnection(url, "user1104", "user1104"); 
			if(con==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속성공");
				
				String sql="insert into board_member(member_id, m_id,m_pass,m_name)";
				sql+=" values(seq_board_member.nextval, ?,?,?)";
				
				pstmt=con.prepareStatement(sql);//쿼리실행할 준비
				pstmt.setString(1, t_id.getText());
				
				pstmt.setString(2, new String(t_pass.getPassword())); //char 배열을 스트링으로...
				pstmt.setString(3, t_name.getText());
				
				//DML 의 경우, 이 쿼리수행에 의해 영향을 받은 레코드수가 반환되므로 , 만일 0이 반환된다면 실패로 판단!!
				int result = pstmt.executeUpdate(); //DML의 경우는 executeUpdate(), select는 executeQuery()
				if(result==0) {
					JOptionPane.showMessageDialog(this, "가입에 실패하였습니다\n관리자에 문의주세요");
				}else {
					JOptionPane.showMessageDialog(this, "가입을 축하드려요^^");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
			
		}

	}
}






















