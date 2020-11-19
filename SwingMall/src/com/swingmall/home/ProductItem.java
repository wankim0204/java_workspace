package com.swingmall.home;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductItem extends JPanel{
	JPanel p_can;
	JLabel la_brand;
	JLabel la_product_name;
	JLabel la_price;
	Image img;
	String path;
	
	public ProductItem(String path, int width, int height) {
		this.path=path;
		try {
			URL url = new URL(path);
			img = ImageIO.read(url);//원본크기의 이미지가 오므로, 크기 조절이 필요하다 
			img=img.getScaledInstance(width, height/2, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p_can = new JPanel() {
			public void paint(Graphics g) {
				//g.setColor(Color.BLUE);
				//g.fillRect(0, 0, width, height/2);
				g.drawImage(img, 0, 0, p_can);
			}
		};
		la_brand = new JLabel("지오다노");
		la_product_name = new JLabel("노란셔츠");
		la_price = new JLabel("150,000");
		
		//스타일적용
		setPreferredSize(new Dimension(width, height));
		p_can.setPreferredSize(new Dimension(width, height/2));
		
		la_brand.setPreferredSize(new Dimension(width, (height/2)/4));
		la_product_name.setPreferredSize(new Dimension(width, (height/2)/4));
		la_price.setPreferredSize(new Dimension(width, (height/2)/4));
		
		add(p_can);
		add(la_brand);
		add(la_product_name);
		add(la_price);		
	}
}



