package com.swingmall.admin.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

import com.swingmall.admin.AdminMain;
import com.swingmall.admin.Page;

public class Product extends Page{
	JPanel p_west; //tree 올 영역
	JPanel p_center;
	JTree tree;
	JTable table;
	JScrollPane s1,s2;
	JButton bt_regist;
	
	public Product(AdminMain adminMain) {
		super(adminMain);
		
		//생성
		p_west = new JPanel();
		p_center = new JPanel();
		tree = new JTree();//노드를 넣을 예정임..
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
}
