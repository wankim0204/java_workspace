package animal;

public class Duck extends Bird{
     String name="����";

     public Duck(String  n){ //�����ڰ� �����ڸ� ����ϸ�, �����Ϸ��� ���̻� �������� �ʾƿ�!!
     					//����1���Դϴ�
		super();
		name=n;
		
     }

     public static void main(String[] args){
         //name="������";         //(��)
         //Duck d=new Duck();   //(��)
         //d.name="�����塱;      //(��)
         //d.fly=false;               // (��)

		Duck d=new Duck("���ε�");   //(��)
     }
}