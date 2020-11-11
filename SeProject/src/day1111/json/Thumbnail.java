package day1111.json;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//원격지의 URL 이미지를 로드하는 동안, 그래픽 처리가 먹통이 되버린다..이 문제를 해결하기 위함
public class Thumbnail extends JPanel implements Runnable{ 
	Image img; //썸네일로 그려질 이미지
	BufferedImage buffImg;
	int width;
	int height;
	String path;
	Thread thread;
	JsonGallery jsonGallery;
	
	public Thumbnail(JsonGallery jsonGallery, int width, int height, String path) {
		this.jsonGallery=jsonGallery;
		this.width=width;
		this.height=height;
		this.path=path;
		
		this.setPreferredSize(new Dimension(width, height));
		thread = new Thread(this); //Runnable을 구현한 객체를인수로 넣어준다
		thread.start(); //생성과 동시에 쓰레드 동작
	}
	
	public void getErrorImage() {
		URL url = this.getClass().getClassLoader().getResource("res/error.png");
		try {
			BufferedImage buffImg = ImageIO.read(url);
			img = buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//그림 그리기 
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	
	public void run() {
		//1.이미지가 로컬 하드에 잇을 경우 Toolkit  을 사용!
		//2.이미지가 클래스패스상 즉 패키지에 있을 경우 ClassLoader() 로 이용 
		//3.BufferedImage  > ImageIO
		try {
			URL url=new URL(path);
			buffImg = ImageIO.read(url);
			img = buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			jsonGallery.p_south.updateUI();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("이미지를 찾을 수 없네요");
			getErrorImage();
		}				
	}
}











