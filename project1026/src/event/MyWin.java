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
		bt = new Button("��������");		
		t = new TextField(15);
		
		this.setLayout(new FlowLayout());
		//��ư�� �����쿡 ����!!
		this.add(bt); //�������� ����Ʈ�� BorderLayout�̹Ƿ�, ���Ϳ����� ũ��
		//��������
		this.add(t);
		
		bt.addActionListener(new MyListener());//��ư�� ������ ���� !!!

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new MyWin();
	}
}
