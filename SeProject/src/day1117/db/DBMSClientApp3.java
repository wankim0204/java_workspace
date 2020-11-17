/*
	day1116일차에 구현했던 데이터베이스 클라이언트 프로그램에서 JTable 생성자의 Vector 방식을 이용하면
	동적인 테이블 선택시 유지보수성이 거의 불가능한 수준이므로, 이를 개선해 본다
	즉, 유저가 어떤 테이블을 선택할지 알수 없으므로, 선택한 테이블의 컬럼수, 구성등을 예측할 수 없는 상황에 
	대처해본다 
*/
package day1117.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DBMSClientApp3 extends JFrame{
	JPanel p_west; //서쪽 영역 패널 
	Choice ch_users; //유저명이 출력될 초이스 컴포넌트 
	JPasswordField t_pass;//비밀번호 텍스트 필드 
	JButton bt_login; //접속 버튼
	
	JPanel p_center;//그리드가 적용될 센터패널
	JPanel p_upper; //테이블과 시퀀스를 포함할 패널(그리드 레이아웃 예정)
	JPanel p_middle; //SQL편집기가 위치할 미들패널(BorderLayout)
	JTextArea area;//쿼리 편집기
	JButton bt_execute;//쿼리문 실행버튼
	JTable t_tables;//유저의 테이블 정보를 출력할 JTable
	JTable t_seq;//유저의 시퀀스 정보를 출력할 JTable
	JTable t_record;//유저가 선택한 테이블의 레코드를 출력할 JTable
	
	JScrollPane s1,s2,s3,s4;//스크롤  4개 준비
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="1234";
	Connection con;
	
	//테이블 모델로 가면 여러분들이 피곤하므로, 그냥 이차원백터로 가겠습니다.괜찬죠? 옛날기술이라면서 무시하시기 
	//있기? 없기? ㅋㅋ 
	
	//테이블을 출력할 백터 , 및 컬럼
	Vector tableList = new Vector(); //이 벡터안에는 추후 또다른 벡터가 들어갈 예정임. 즉 이차원배열과 동일함
													//단, 이차원배열보다는 크기가 자유로와서 유연함..코딩하기 편함	
	Vector<String> tableColumn = new Vector<String>(); //컬럼명은 당연히 String이므로..
	
	//시퀀스에 필요한 백터들
	Vector seqList = new Vector();
	Vector<String> seqColumn = new Vector<String>();
	
	
	//TableModel 보유 
	MyTableModel model;
	
	public DBMSClientApp3() {
		//생성
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		p_center= new JPanel();
		p_upper = new JPanel();
		p_middle = new JPanel();
		area = new JTextArea();
		bt_execute = new JButton("SQL문 실행");
		
		
		p_center.setLayout(new GridLayout(3, 1)); //3층에 1호수
		p_upper.setLayout(new GridLayout(1, 2)); //1층에 2호수
		p_middle.setLayout(new BorderLayout());
		

		//컬럼정보 초기화 하기(이러면 안되겠네요,,,생성자로 원상복귀) 
		tableColumn.add("table_name");
		tableColumn.add("tablespace_name");
		t_tables = new JTable(tableList,tableColumn); //여기서 초기백터값을 넣어주세요, 이 시점엔 아직  
																			//db연동을 안한 상태이므로 사이즈가 0이지만, 
																			//추후 메서드 호출시 벡터의 크기가 변경될것이고, 
																			//JTable 을 새로고침하면 되겟죠?
		//시퀀스의 생성자에 백터 적용하기
		seqColumn.add("sequence_name");
		seqColumn.add("last_number");
		t_seq = new JTable(seqList, seqColumn);
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		s3=new JScrollPane(area); 
		
		
		//선택한 테이블의 레코드 보여줄 JTable 생성 
		t_record = new JTable(null); //MyTableModel을 대입할 예정
		s4=new JScrollPane(t_record);
		
		
		//스타일 
		p_west.setPreferredSize(new Dimension(150, 350));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		area.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		//조립 
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		
		p_upper.add(s1);
		p_upper.add(s2);
		p_middle.add(s3);
		p_middle.add(bt_execute, BorderLayout.SOUTH);
		p_center.add(p_upper);//그리드의 1층
		p_center.add(p_middle);//그리드의 2층 
		p_center.add(s4);//그리드의 3층
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setSize(900,750);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		//프로세스만 종료시켜 버리므로, 오라클, 스트림 닫는 처리를
		//할 기회를 잃어버리게 된다..
		//따라서 윈도우 어댑터 구현하여 닫을게 있다면 닫는처리하자!!
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect(); //시스템 종료전에 닫을 자원이 있을때 먼저 닫을려고 호출함!!!!
				System.exit(0);
			}
		});
		
		bt_login.addActionListener((e)->{
			login(); //선택한 유저로 로그인시도하기!!
		});
		
		//테이블과 리스너 연결 
		t_tables.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//선택한 좌표의 테이블명 얻기!!
				
				int row = t_tables.getSelectedRow();//선택한  row구하기 
				int col = t_tables.getSelectedColumn();//선택한 column  구하기
				
				String tableName =(String)t_tables.getValueAt(row, col);
				tableName = tableName.toLowerCase();//소문자로 변환 
				System.out.println(tableName);
				
				//구해진 테이블명을  select() 메서드의 인수로 넘기자!!
				select(tableName);
				t_record.updateUI();//jtable 갱신
				//System.out.println("모델의 컬럼 카운트는 "+model.getColumnCount()+"table 의 컬럼카운트"+t_record.getColumnCount());
			}
		});
		
		setLocationRelativeTo(null);
		
		connect();//호출!!
		getUserList(); //유저목록 구해오기
		
	}
	
	//오라클에 접속하기 
	public void connect() {
		try {
			Class.forName(driver); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password); //접속시도
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"계정의 접속에 실패하였습니다.");
			}else {
				this.setTitle(user+" 계정으로 접속 중..."); //프레임 제목에 성공 출력 
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//유저목록 가져오기
	public void getUserList() {
		//pstmt와 result 은 소모품이므로 매 쿼리문마다 1개씩 대응되요
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql="select username from dba_users order by username asc";
		
		try {
			pstmt=con.prepareStatement(sql);//쿼리문 준비하기
			rs = pstmt.executeQuery();//반환형을 먼저 적으면 이클립스가 알맞는 메서드를 찾아줍니다
			
			//이제  rs 에들어있는 유저정보를 Choice에 출력합시다 (여러분들이 해보세요)
			while(rs.next()) {
				ch_users.add(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//자원 닫기 
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	//현재 접속 유저의 테이블목록 가져오기
	public void getTableList() {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql="select table_name , tablespace_name from user_tables";
		try {
			pstmt=con.prepareStatement(sql);//쿼리준비
			rs=pstmt.executeQuery();//쿼리실행 및 결과집합 받기!!
			//평소같았으면, 이차원배열 선언한 후 last(), getRow() , 스크롤옵션 등등 아주 성가셨으나, 백터를 이용하면
			//그런게 필요없음 
			
			
			while(rs.next()) {
				Vector vec = new Vector(); //tableList백터에 담겨질 백터
				vec.add(rs.getString("table_name"));
				vec.add(rs.getString("tablespace_name"));
				
				tableList.add(vec);//멤버변수 백터에 백터를 담았으니, 이제 멤버변수 백터는 이차원백터가 됨
			}
			//완성된 이차원백터를 JTable에 반영해야 함, 생성자의 인수로 넣어야 함!! 
			//컬럼 정보는 어떻게 가져올까요?? 2개밖에 없으니 고정하면 되겠죠?
			t_tables.updateUI(); //여기서 new 하지 마세요 그냥 updateUI() 합시다
			//테이블의 레코드와 컬럼갯수 확인 (여전히 0인지 체크) 
			//현재 테이블이 컬럼을 몇개로 인식하고 있는지 조사
			System.out.println("컬럼수는 : "+t_tables.getColumnCount());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
	}
	
	//시퀀스 가져오기 
	public void getSeqList() {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql="select sequence_name, last_number from user_sequences";
		
		try {
			pstmt=con.prepareStatement(sql);//쿼리준비
			rs=pstmt.executeQuery();//쿼리실행
			//rs의 내용을 백터로 옮기자!!, 즉 이차원백터로 만들자!!
			while(rs.next()) {
				Vector vec = new Vector(); // 레코드를 담을 백터준비( 일차원) 
				vec.add(rs.getString("sequence_name"));
				vec.add(rs.getString("last_number"));
				seqList.add(vec);//기존 시퀀스 백터에 추가해서 이차원백터로 만들자!!
			}
			t_seq.updateUI();//만들어진 벡터를 테이블에 반영한 결과를 업데이트하자
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
			
		}
		
		
	}
	
	
	//유저가 선택한 테이블의 레코드 가져오기
	//이 메서드를 호출하는 者는  select 문의 매개변수로 테이블명을 넘겨야 한다!!
	//매개변수가 넘어오면, 테이블명만 사용하고, 안넘어오면 전체 SQL 문 대체하자
	public void select(String tableName) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String sql=null;
		if(tableName!=null) { // 테이블명을 매개변수로 넘기면 아래의 쿼리문을 사용
			sql="select * from "+tableName;
		}else {
			sql=area.getText();
		}
		
		System.out.println(sql);
		
		try {
			pstmt=con.prepareStatement(sql); //쿼리문 준비
			rs = pstmt.executeQuery();//쿼리문 실행
			
			
			/*----------------------------------------------
			  컬럼 정보 만들기 위한 코드
			 ----------------------------------------------*/
			Vector column = new Vector(); //이 벡터는 새로운  TableModel 객체의 인스턴스가 가진 컬럼벡터에 대입될 예정
			ResultSetMetaData meta=rs.getMetaData();
			int columnCount = meta.getColumnCount();//총 컬럼 수
			
			System.out.println("당신이 선택한 "+tableName+" 테이블의 컬럼수는 "+columnCount);
			
			//컬럼 정보 출력
			//출력만 확인하지말고, MyTableModel 이 보유한 컬럼용 벡터에 정보를 채워넣자!!
			for(int i=1;i<=columnCount;i++) {
				//System.out.println(meta.getColumnName(i));
				column.add(meta.getColumnName(i));
			}
			
			//이 rs 를 어디에 담아야 할까??(힌트: 생성자 벡터 방식이 아닌 TableModel 방식을 이용하고 있다..)
			//TableModel인 MyTableModel 이 보유한 벡터에 담으면 된다!!!
			Vector record = new Vector();
			while(rs.next()) {
				Vector vec = new Vector();//비어있는 일차원 벡터(여기에 레코드 1건이 담겨질 예정)
				
				/*rs도 일정의 배열이므로,  index 로 컬럼을 접근할 수 있다!! 주의 1부터 시작이다 
				왜? 만든자가 그렇게 했으니...
				문제점) 1부터 몇까지 컬럼이 존재하는지 알수가 없다!!
				그럼 어떻게 알 수 있을까?
				- 이럴땐 테이블에 대한 메타정보를 가져오면 된다!!
				*/ 
				for(int i=1;i<=meta.getColumnCount();i++) {
					vec.add(rs.getString(i));//데이터채우기
				}
				record.add(vec);//MyTableModel 보유한 벡터에 추가하자~!
			}
			//데이터를 담은 이차원 벡터와 , 컬럼을 담은 일차원 벡터를 새로운 모델객체를 생성하면서 전달하자!!
			model = new MyTableModel(record,  column);
			t_record.setModel(model);//테이블에 모델을 생성자가 아닌, 메서드로 적용하자!!
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
		
		
	}
	
	//로그인 
	public void login() {
		//현재 유지되고 있는 접속 객체인 Connection을 끊고, 다른 유저로 접속을 시도한다!!
		disConnect();//접속끊기
		
		user = ch_users.getSelectedItem();//현재 초이스컴포넌트에 선택된 아이템값!!!
		password = new String(t_pass.getPassword()); //비밀번호 설정 
		
		connect();//접속하기~~ ( 하지만 멤버변수가 현재 .system으로 되어 있으므로 멤버변수를 초이스 값으로 교체
						//해야 한다) 
		getTableList(); //바로 이 시점에 로그인하자마자, 이 사람의 테이블 정보를 보여주는게 좋을거 같아요
		getSeqList();
		
		System.out.println("보유한 테이블 "+tableList.size());//잘 나오는데 뭔가 갱신에 문제가 있어요 
		//오늘여기까지 할테니, 저녁때 복습하시면서 한번 체크해보세요~~~
		t_tables.updateUI();
	}
	
	
	//오라클에 접속끊기
	public void disConnect() {
		if(con!=null) {  //아직 con이 선언된게 없으니 선언해주세요
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String[] args) {
		new DBMSClientApp3();
	}

}












