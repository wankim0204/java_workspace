package string;

class StringTest{
	public static void main(String[] args){
		/*
		String �� Ŭ������!!!
		������ �츮 �ΰ��� ��Ʈ���� �ʹ� �е������� ���� ����ϱ⶧����, 
		new �����ڿ� ���� ��Ʈ���� �����ϴ� ���� �ʹ� �����ϴ�!!
		����  String ���ؼ��� ��ġ �Ϲ� ������Ÿ��ó�� new ���� �ʴ� ǥ������ �������ش�
		�̷��� String �� ��������� �Ͻ���,������(implicit) ������
		������ �������� ����  String �� ���Ǯ�� ���� �����Ǿ� ���µ�,
		*/
		/*�Ʒ� �ڵ��� ������ �����غ���*/

		String s1 = "apple";
		String s2 = "apple";
		System.out.println(s1==s2); //����� ���� ���ñ��? ���� �غ�����~~
		
		//String �� ���۹����� 'S'�� �빮�ڷκ��� �и� ��ü���̴�!!
		//�츮�� ����ȯ�濡�� String.class�� ��򰡿� �־�� �ϴµ�, ������ �ʴ´�..
		//java se �� ��� api�� ���ִ� ����� ����... 
		//C:\Program Files\Java\jdk1.8.0_261\jre\lib\rt.jar  
		
		//�Ʒ��� ���� new �����ڿ� ���� ��Ʈ�� �������� �����(explicit) �������̸�,
		//����� �������� ���Ǯ�� �������� �����Ƿ�,  new�Ҷ����� �ߺ� ���θ� ������ �ʰ�
		//������ �����ȴ�!!
		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3==s4);//����� ���� ���ñ��? 

		//�ּҺ񱳰� �ƴ�, ��ü ���ϼ� ���ϴ� �� 
		String k1="orange";
		String k2="orange";
		System.out.println(k1==k2);//�ּ� 
		System.out.println(k1.equals(k2));//���� ��
	}
}
