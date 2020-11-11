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

public class Thumbnail extends JPanel{ 
	Image img; //썸네일로 그려질 이미지
	BufferedImage buffImg;
	
	public Thumbnail(int width, int height, String path) {
		this.setPreferredSize(new Dimension(width, height));
		//1.이미지가 로컬 하드에 잇을 경우 Toolkit  을 사용!
		//2.이미지가 클래스패스상 즉 패키지에 있을 경우 ClassLoader() 로 이용 
		//3.BufferedImage  > ImageIO
		try {
			URL url=new URL(path);
			buffImg = ImageIO.read(url);
			img = buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//그림 그리기 
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}











