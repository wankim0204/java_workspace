
class Car{
	String name="Benz";
	int price=500;
	String color="red";
	Wheel wheel=null; //이 코드가 낯설지 않은 이유??
	//클래스 안에는 자료형을 둘수 있는데, 자바의 자료형은 총 4개이다.
	//따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 올수있다..
	//객체자료형도 자료형이니깐..
	//클래스명과 동일한 이름의 메서드를 가리켜 생성자라 하고, 
	//생성자는 이름에서 도 알수 있듯이, 객체의 생성 타임에, 무언가 초기화 작업이 있을때, 
	//작업을 수행하는 용도의 메서드이다..
	public Car(){
		this.wheel = new Wheel();
	}

	public static void main(String[] args){
		Car c = new Car();//자동차를 생성하고, 
		System.out.println(c.name);//이 자동차의 이름 출력하고,
		
		//이 자동차 바퀴의 브랜드, 색상, 가격을 출력까지 하시오
		//c.wheel = new Wheel(); //칭찬 but...자동차 생산 이후에 한참 지나서
		//바퀴 생성하는 느낌임...
		System.out.println(c.wheel.brand);
	}

}
