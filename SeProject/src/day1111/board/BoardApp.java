package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;

public class BoardApp extends JFrame{
	JPanel p_north;
	JButton bt_board, bt_regist, bt_login;
	JPanel p_center;
	
	JPanel[] pages=new JPanel[3]; //화면전환에 사용될 패널들을 담게될 배열
	
	//상수란? 변하지 않는 데이터에 의미를 부여하여 직관성은 높이기 위해 사용한다
	public static final int BOARD_LIST=0;
	public static final int BOARD_WRITE=1;
	public static final int BOARD_DETAIL=2;
	
	public BoardApp() {
		//생성
		p_north = new JPanel();
		bt_board = new JButton(ImageUtil.getIcon(this.getClass(), "res/board.png", 100, 45));
		bt_regist = new JButton(ImageUtil.getIcon(this.getClass(), "res/register.png", 100, 45));
		bt_login = new JButton(ImageUtil.getIcon(this.getClass(), "res/login.png", 100, 45));
		p_center = new JPanel();
		pages[0] = new BoardList(this); //게시판 목록 페이지 
		pages[1] = new BoardWrite(this); //게시판 글쓰기 페이지 
		pages[2] = new BoardDetail(this); //게시판 상세보기 페이지 
		
		//스타일 
		bt_board.setPreferredSize(new Dimension(100, 35));
		bt_regist.setPreferredSize(new Dimension(100, 35));
		bt_login.setPreferredSize(new Dimension(100, 35));
		
		//조립 
		p_north.add(bt_board);
		p_north.add(bt_regist);
		p_north.add(bt_login);
		
		p_center.add(pages[0]);//중앙 패널에 게시판 목록 붙여넣기
		p_center.add(pages[1]);//중앙 패널에 게시판 글쓰기 붙여넣기
		p_center.add(pages[2]);//중앙 패널에 게시판 상세보기 붙여넣기
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//이 프로그램에서 사용되는 모든 페이지를 제어하는 메서드 
	public void setPage(int showIndex) {//보여주고 싶은 페이지 index  넘겨받자
		for(int i=0;i<pages.length;i++) {
			if(i==showIndex) {
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		new BoardApp();
	}

}




