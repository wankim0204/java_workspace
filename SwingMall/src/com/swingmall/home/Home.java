package com.swingmall.home;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Home extends Page{
	JPanel p_content;//상품 리스트를 담게될 패널, 추후 상세보기로 전환시 이 패널 자체를 들어내버릴꺼임..
	
	public Home(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		
		//스타일적용 
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-40, ShopMain.HEIGHT-150));
		createItem();
		
		add(p_content);
	}
	
	//상품 아이템 카드 생성하기!!
	public void createItem() {
		for(int i=0;i<20;i++) {
			ProductItem item = new ProductItem("https://hotping.co.kr/web/product/big/202008/653effd715bb641a477e055ba6bee615.jpg",200,180);
			p_content.add(item);
		}
	}
}








