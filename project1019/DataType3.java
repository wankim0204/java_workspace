class DataType3 {
	public static void main(String[] args){
		short s1=3; //(��)
		short s2=4; //(��)

		int a1 = 3;//(��)
		int a2 = 4;//(��)
		
		//������ ������࿡�� ����, ������ ����� �Ǵ� �����Ͱ� int������
		//���� �ڷ����� ���(byte, short) ����ӵ��� ���̱� ����, ���꿡 ����ȭ�� 
		//�ڷ����� int������ �ڵ� ����ȯ�� ����Ų��
		//����ȯ�� ����Ų��..
		short sum = s1+s2; //(��)
		//�ذ�å1)  int sum = s1+s2
		//�ذ�å2)  short sum = (short)(s1+s2)
		//(short) ������ �Ұ�ȣ��  cast �����ڶ� �Ѵ�..

		int result = a1+a2;//(��)	

		long k1=5;
		int k2=9;

		�ڷ��� k3=k1 + k2;

	}
}
