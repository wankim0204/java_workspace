/*
�ڵ����� �����Ѵ� (Car)
color ����
price ����
self�ڵ������� ���� ����
go �޸���
stop �����
*/
class Car{
	//�Ʒ��� ������ Ŭ�����κ��� �ν��Ͻ��� �����ɶ�, �ش� �ν��Ͻ��� ���ԵǾ�����
	//�ν��Ͻ� �����μ�, �������� �ش� �ν��Ͻ��� �Ҹ�ɶ����� �Բ� �Ѵ�..

	//�ڵ����� ��ǰ�̹Ƿ�, �ڵ����� ������ ���� �Ѵ�..
	//�̷��� ���������, �ʱ�ȭ ������ �����Ϸ��� �ּ����� ������ ���� �ڵ��ʱ�ȭ�Ѵ�
	String color; //null�� �ʱ�ȭ��..
	int price;//������ �ּ����� ���� 0���� �ʱ�ȭ
	boolean self; //false�� �ּ�ȭ

	public void go(){
	}

	public void stop(){
	}

	public static void main(String[] args){
		/*CarŬ������ �����ϸ鼭, �ش� Ŭ������ ������ ������ ���������
			�ƹ��� ���� �ʱ�ȭ ��Ű�� �ʾҴٸ�, � ����� ���ñ�??
			�Ϲ����� ���α׷��� ������ ������ ���� ���� ���·� �ٸ� �����Ϳ���
			������ �����ϰ� �Ǹ� ������ �߻��Ѵ�..
		*/
		//int x;//������ �� �Ⱦ��ϴ� ������..
		//��� {����}������ , �ʱ�ȭ �ؾ� ������ �����ϴ�!!(���α׷� �⺻ ��Ģ)
		//int z = x+5;

		//�ڵ����� �ν��Ͻ��� �Ѱ� ������ ��, �� �ν��Ͻ� ���� ����������� ����
		//���� ����غ���!(������ �����Ϸ��� ���� �ʱ�ȭ �Ǿ�����..)
		Car c = new Car();
		System.out.println("color : "+c.color);
		System.out.println("price : "+c.price);
		System.out.println("self : "+c.self);

	}
}