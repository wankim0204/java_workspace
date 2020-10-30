package day30.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GalleryApp extends JFrame{
	JPanel p_west;
	JPanel p_center;
	JScrollPane scroll;
	
	ArrayList<Thumb> list=new ArrayList<Thumb>();//썸네일 배열 선언
	String dir="D:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"
	};
	
	public GalleryApp() {
		super("자바 겔러리");
		//생성 
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_west);
		
		//썸네일생성
		for(int i=0;i<src.length;i++) {
			Thumb thumb=null;
			list.add(thumb=new Thumb(dir+src[i]));
			p_west.add(thumb);
		}
		
		//스타일 
		p_west.setPreferredSize(new Dimension(100,600));
		p_center.setPreferredSize(new Dimension(700,600));
		p_west.setBackground(Color.YELLOW);
		p_center.setBackground(Color.GREEN);
		
		//조립 
		add(scroll, BorderLayout.WEST);
		add(p_center);
		
		//윈도우를 화면 중앙에 띄우는 법
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GalleryApp();

	}

}
