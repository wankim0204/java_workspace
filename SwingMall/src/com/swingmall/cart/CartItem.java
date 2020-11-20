
/*
 * 이 클래스는 페이지 수준은 아니고, 단지 장바구니 페이지에서 재사용성이 높은 
 * 상품 아이템을 정의하기 위한 클래스임!!
 * */
package com.swingmall.cart;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CartItem extends JPanel{
	JPanel p_can; //상품 이미지 
	JPanel p_info; //라벨들이 위치할 그리드 패널 (3,1)
	JLabel la_brand,la_product_name, la_price;
	JLabel la_ea;//수량 
	JTextField t_ea;
	JButton bt_update;//수량변경 적용 버튼
	
}





