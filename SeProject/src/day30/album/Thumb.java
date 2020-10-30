package day30.album;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//썸네일 하나를 정의한다!!
public class Thumb extends JPanel implements MouseListener{
	Toolkit kit; //플랫폼에 의존적인 경로를 이용할때 툴킷이 필요 window d://
	Image img;
	public static final int WIDTH=75;
	public static final int HEIGHT=55;
	
	public Thumb(String src) {
		kit = Toolkit.getDefaultToolkit();
		img=kit.getImage(src);
		img=img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.BLACK);
		
		this.addMouseListener(this);//리스너와 연결 
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("썸네일 눌럿어?");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
