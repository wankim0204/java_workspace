/*
 * 장바구니 페이지를 정의한다
 * */
package com.swingmall.cart;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Cart extends Page{
	JPanel bt_container; //버튼을 묶어줄 컨테이너
	JButton bt_pay;//결제단계로 가기
	JButton bt_del; //장바구니 비우기
	
	//장바구니 역할을 컬렉션 프레임웍 객체를 선언
	
	
	public Cart(ShopMain shopMain) {
		super(shopMain);
		//this.setBackground(Color.BLACK);
		bt_container = new JPanel();
		bt_pay = new JButton("결제하기");
		bt_del = new JButton("장바구니 비우기");
		
		//스타일
		bt_container.setPreferredSize(new Dimension(ShopMain.WIDTH, 100));
		bt_container.setBackground(Color.CYAN);
		
		getCartList();
		
		bt_container.add(bt_pay);
		bt_container.add(bt_del);
		add(bt_container);
	}
	
	//장바구니 목록 출력하기 
	public void getCartList() {
		for(int i=0;i<4;i++) {
			CartItem item = new CartItem();
			add(item);
		}
	}
}











