package day1113.xml.down;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class DownLoader extends JFrame{
	JButton bt_down;
	JProgressBar bar;
	
	public DownLoader() {
		bt_down = new JButton("다운로드");
		bar =new JProgressBar();
		
		//스타일
		bar.setPreferredSize(new Dimension(580, 55));
		bar.setForeground(Color.CYAN);
		bar.setBackground(Color.BLACK);
		
		bar.setFont(new Font("Verdana", Font.BOLD, 25));
		bar.setStringPainted(true);
		bar.setValue(35); //35%
		
		setLayout(new FlowLayout());
		add(bt_down);
		add(bar);
		
		//다운로드 버튼과 리스너 연결
		bt_down.addActionListener((e)->{
			download();
		}); 
		
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void download() {
		//xml을 파싱하여 url만 추출해야 함!!
	}
	
	public static void main(String[] args) {
		new DownLoader();

	}

}




