/*게시물 목록 페이지*/
package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoardList extends JPanel {
	JTable table;
	JScrollPane scroll;
	JButton bt;
	BoardApp boardApp;
	BoardModel boardModel;
	
	public BoardList(BoardApp boardApp) {
		this.boardApp=boardApp;
		table = new JTable(boardModel = new BoardModel());
		scroll = new JScrollPane(table);
		bt=new JButton("글등록");
		
		setLayout(new BorderLayout());
		add(scroll);
		add(bt, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				boardApp.setPage(BoardApp.BOARD_DETAIL);//상세보기
			}
		});
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//글쓰기 폼의 작성자에, 아이디 넣어두기!!
				BoardWrite page=(BoardWrite)boardApp.getPages(BoardApp.BOARD_WRITE);
				page.t_writer.setText(boardApp.getBoardMember().getM_id());
				
				boardApp.setPage(BoardApp.BOARD_WRITE);//글쓰기 폼 보여주기 
			}
		});
		
	}
	
	//게시물 가져오기!
	//rs에 담겨진 데이터를 TableModel 이 보유한 이차원배열 data에 대입!!
	public void getList() {
		
	}
	
}












