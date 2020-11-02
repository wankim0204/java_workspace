package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;

class MyWin extends Frame{
				/*MyWin is a Frame*/	
	Button bt; //MyWin has a bt
	TextField t; 
	
	public MyWin(){
		bt = new Button("나눌러봐");		
		t = new TextField(15);
		
		this.setLayout(new FlowLayout());
		//버튼을 윈도우에 부착!!
		this.add(bt); //프레임은 디폴트가 BorderLayout이므로, 센터영역에 크게
		//붙을것임
		this.add(t);
		
		bt.addActionListener(new MyListener());//버튼과 리스너 연결 !!!

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new MyWin();
	}
}
