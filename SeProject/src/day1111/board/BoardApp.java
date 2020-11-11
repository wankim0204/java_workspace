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
	
	public BoardApp() {
		p_north = new JPanel();
		
		bt_board = new JButton(ImageUtil.getIcon(this.getClass(), "res/board.png", 100, 45));
		bt_regist = new JButton(ImageUtil.getIcon(this.getClass(), "res/register.png", 100, 45));
		bt_login = new JButton(ImageUtil.getIcon(this.getClass(), "res/login.png", 100, 45));
		p_center = new JPanel();
		//스타일 
		bt_board.setPreferredSize(new Dimension(100, 35));
		bt_regist.setPreferredSize(new Dimension(100, 35));
		bt_login.setPreferredSize(new Dimension(100, 35));
		
		//조립 
		p_north.add(bt_board);
		p_north.add(bt_regist);
		p_north.add(bt_login);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BoardApp();
	}

}
