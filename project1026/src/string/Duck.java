package string;

/*
�ڹ��� ���~~~~��ü�� ���� ���Ҽ� ���� �ֻ��� ��ü�� �ΰ� �ִ�.
Object ��ü�̴�. �����ڰ� ����� ������� �ʴ��� ����Ʈ�� �̹� ��ӵǾ� �ִ�...
*/
class Duck {
	String name="����";
	
	/*�Ʒ��� �޼���� ObjectŬ�����κ��� ��ӹ��� �޼����̸�, 
	�� �޼���� ��ü�� ��Ʈ������ ��ȯ�ϰ��� �Ҷ� �����Ѵ�!!
	��, �Ʒ��� �޼����, ��ü�� ����ϰ��� �Ҷ� � �ڵ����� �����Ѵ�..

	�Ʒ��� �޼����  Object �� �޼���������, �׽�Ʈ�� �����ϴ� ������ �˱����� ���
	�������̵��غô�..
	*/
	public String toString(){
		System.out.println("toString() �޼��� �����մϴ�");
		return "";
	}

	public static void main(String[] args){
		Duck d = new Duck();

		//System.out.println(d); //���� ��ü�� �ƴ϶�,������ �ּҰ� : string.Duck@15db9742���ڿ�
		System.out.println(new Duck());//���� ��ü�� ���!!
	}
}
