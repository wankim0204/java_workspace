/*
 * 하나의 상품정보를 모두 담을 수 있으나, 
 * 사용자가 구매하기를 원하는 갯수는 ProductVO에 담을수없기에
 * 현재 클래스를 ProductVO를 상속받는 자식클래스로 정의하되
 * ea만 추가하면 코드 재사용이 가능하다!!
 * */
package com.swingmall.cart;

import com.swingmall.admin.product.ProductVO;

public class CartVO extends ProductVO{
	private int ea;

	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	
}
