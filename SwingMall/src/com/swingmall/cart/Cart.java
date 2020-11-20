/*
 * 장바구니 페이지를 정의한다
 * */
package com.swingmall.cart;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Cart extends Page{
	JPanel bt_container; //버튼을 묶어줄 컨테이너
	JButton bt_pay;//결제단계로 가기
	JButton bt_del; //장바구니 비우기
	
	//장바구니 역할을 컬렉션 프레임웍 객체를 선언
	HashMap<Integer,CartVO> cartList; 
	
	public Cart(ShopMain shopMain) {
		super(shopMain);
		
		cartList = new HashMap<Integer, CartVO>();
		
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
	
	
	//장바구니에 넣기 
	public void addCart(CartVO vo) { //상품1건을 장바구니에 추가하기!!!
		cartList.put(vo.getProduct_id(), vo);  //key와 값을 저장
	}
	//장바구니 삭제하기
	public void removeCart() { //상품1건을 장바구니에서 제거하기
		
	}
	
	//장바구니 비우기
	public void removeAll() { //모든 상품을 장바구니에서  제거하기
		
	}
	
	//장바구니 목록 가져오기 (주의: 맵은 순서가 없는 집합이므로 먼저 일렬로 늘어뜨려야 한다..그 후 접근..)
	public void getCartList() {
		Set<Integer> set = cartList.keySet(); //키들을 set으로 반환받는다..즉 맵은 한번에 일렬로 늘어서는 것이 아니라,  set으로 먼저
									//key를 가져와야 함
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {//요소가 있는 동안..
			int key=it.next();//요소를 추출
			CartVO vo=cartList.get(key);
			//디자인을 표현하는 CartItem에 CartVO의 정보를 채워넣자!!
			CartItem item = new CartItem();
			add(item);
		}
	}
}



















