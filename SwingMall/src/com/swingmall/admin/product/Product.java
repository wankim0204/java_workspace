package com.swingmall.admin.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.swingmall.admin.AdminMain;
import com.swingmall.admin.Page;

public class Product extends Page{
	JPanel p_west; //tree 올 영역
	JPanel p_center;
	JTree tree;
	JTable table;
	JScrollPane s1,s2;
	JButton bt_regist;
	
	ArrayList<String> topList;//최상위 카테고리 이름을 담게될 리스트 top,down,accessay,shoes
	ArrayList<ArrayList> subList=new ArrayList<ArrayList>();//모든 하위 카테고리
	
	public Product(AdminMain adminMain) {
		super(adminMain);
		
		//카테고리 가져오기
		getTopList();//상위카테고리 가져오기, 멤버변수인 topList에 최상위 카테고리가 채워진다!!
		for(String name : topList) {
			getSubList(name);
		}
		
		//노드만들기
		//'상품목록' 이라는 제목의 최상위노드 생성하기 
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품목록");
		for(int i=0;i<topList.size();i++) {
			top.add(getCreatedNode(topList.get(i), subList.get(i)));
		}
		
		//생성
		p_west = new JPanel();
		p_center = new JPanel();
		tree = new JTree(top);
		table = new JTable(10,7);
		s1 = new JScrollPane(tree);
		s2 = new JScrollPane(table);
		bt_regist = new JButton("등록하기");
		
		//스타일 적용 
		s1.setPreferredSize(new Dimension(200, AdminMain.HEIGHT-100));
		p_west.setBackground(Color.WHITE);
		s2.setPreferredSize(new Dimension(AdminMain.WIDTH-200, AdminMain.HEIGHT-200));
		
		//조립
		setLayout(new BorderLayout());
		
		p_west.add(s1);//서쪽 패널에 트리 스크롤부착
		p_center.add(s2); //센터패널에 테이블 스크롤부착
		p_center.add(bt_regist);//센터패널에 버튼부착
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
	}
	
	//상위 카테고리 가져오기 
	public void getTopList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from topcategory";
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql); //쿼리준비
			rs=pstmt.executeQuery();//쿼리수행
			//배열은 유연하지 못하므로, ArrayList 에 담자 
			topList = new ArrayList();
			while(rs.next()) {
				topList.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getAdminMain().getDbManager().close(pstmt, rs);
		}
	}
	
	//하위 카테고리 가져오기
	public void getSubList(String name) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from subcategory where topcategory_id=(";
		sql+=" select topcategory_id from topcategory where name='"+name+"')";
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);//쿼리준비
			rs = pstmt.executeQuery();
			
			ArrayList list = new ArrayList();//상위 카테고리에 등록된 하위카테고리
			while(rs.next()) {
				list.add(rs.getString("name"));
			}
			subList.add(list);//모두 담겨지면, 이차원 리스트에 추가해놓자!!
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);
		}
	}
	
	//트리노트 생성하기 
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {
		//부모노드 생성하기 
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);
		
		//넘겨받은 매개변수인 ArrayList 만큼 반복하여 부모노드에 자식노드 부착!!
		for(int i=0;i<childName.size();i++) {
			parent.add(new DefaultMutableTreeNode(childName.get(i)));
		}
		return parent;
	}
	
}












