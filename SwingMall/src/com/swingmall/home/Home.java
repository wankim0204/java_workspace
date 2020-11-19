package com.swingmall.home;

import java.awt.Component;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Home extends Page{
	JPanel p_content;//상품 리스트를 담게될 패널, 추후 상세보기로 전환시 이 패널 자체를 들어내버릴꺼임..
	
	public Home(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		
		//스타일적용 
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-40, ShopMain.HEIGHT-150));
	
		add(p_content);
		
		getProductList();
		p_content.updateUI();//갱신
	}
	
	//모든 상품 가져오기 
	public void getProductList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from product";
		try {
			pstmt=getShopMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {//레코드 있는 만큼
				//vo하나를 생성한 후,  rs의 데이터를 vo 옮긴다!!!
				ProductVO vo = new ProductVO();//Empty 상태
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setBrand(rs.getString("brand"));
				vo.setPrice(rs.getInt("price"));
				vo.setFilename(rs.getString("filename"));
				vo.setDetail(rs.getString("detail"));
				
				createItem(vo);//완성된 vo를 이용하여 createItem() 호출
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
		
	}
	
	//상품 아이템 카드 생성하기!!
	public void createItem(ProductVO vo) {
		ProductItem item = new ProductItem(this, vo,200,180);
		p_content.add(item);
	}
	
	
}








