package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	/*서쪽영역 */
	JPanel p_west; 
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
		
	/*센터영역*/
	Vector data=new Vector();//이차원 벡터가 될 예정~~~
	Vector<String> columnName = new Vector<String>(); //n이 빠졌네요
	
	JTable table;
	//MountainModel model;
	JScrollPane scroll;
	
	/*
	 * JTable에서 데이터 연동시 지금까지는 이차원 배열만 써왔는데, 사실 이차원 배열은 
	 * 생성시 크기를 정해야 하기 때문에 불편한 점이 많습니다.
	 * ( 불편햇던 예: rs.last()  후  rs.getRow()로 데이터 총 수 구하고,다시 커서를 원상복귀 시킴..난리남)
	 * 동의하심? ㅋㅋ 미투
	 * 따라서 컬렉션 프레임웍중 Vector를 지원하는 생성자를 이용해봅시다!!
	 * */
	
	public MTMain() {
		init();//데이터 채우기!!
		
		//생성
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("검색하기");
		//계획이 틀어졌네요, 알고보니 백터를 사용할때는 TableModel  자체를 쓸필요가 없을때 사용하는건데
		//제가 둘다 혼합해버렸어요, 테이블모델이 필요없습니다.
		//프로젝트 진행할때는 , 테이블모델을 쓰시는게 좋아요, 백터방식도 있다는것만 알아두세요 
		//기왕 시작한거 백터로 진행해볼께요 
		//TableModel에 들어있는 백터 2개 모두 현재 클래스로 끄집어 내셔야합니다 ㅜㅜ
		table = new JTable(data, columnName); //매개변수로 벡터를 넣어주세요 
		//실행해보세요, 백터에 데이터가 없어서 그런거니깐, 백터의 값을 거짓말로 채워볼께요
		scroll = new JScrollPane(table);
		
		//스타일 적용 
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//부착 
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//벡터값을 초기화 하자 , 이 메서드를 생성자에서 호출하고, 쉬는시간 갖겠습니다.결과확인해보세요
	public void init() {
		//데이터 1건 넣어보기
		/*코드를 아래와 같이 바꾸셔야 합니다
		 * JTable에 벡터를 매개변수로 넣는 방식은 객체지향적인 요즘 개발방식에 맞지 않음..
		 * 이유) 백터안에 백터를 넣어야 하므로, 이차원배열 방식과 다를바 없음..
		 * 따라서 아래와 같이 벡터안에 또 하나의 벡터를 추가해야 해요!!!
		 * */ 
		Vector v = new Vector();
		v.add("1");
		v.add("설악산");
		v.add("강원도");
		v.add("3000");
		
		data.add(v); //벡터안의 벡터!! 결국 이차원배열 모습을 그대로 유지함 
											//사실 우리가 원했던 것은 Mountain VO를 넣어야 하지만, 
											//백터를 넣는것을 강제함..옛날 방식임..
											//벡터의 제너릭에서 Mountain 을 삭제하셔야 합니다..
		
		//컬럼정보 채우고 
		columnName.add("ID");//산 아이디 
		columnName.add("산이름");//산 이름 
		columnName.add("소재지");//산 소재지 
		columnName.add("높이");//산 높이 		
	}
	
	public static void main(String[] args) {
		new MTMain();

	}

}




