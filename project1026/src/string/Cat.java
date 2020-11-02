package string;
class Cat{
	public String toString(){
		System.out.println("이 메서드 자동 호출함");
		return "";
	}

	public static void main(String[] args){
		Cat c = new Cat();
		System.out.println("메인 메서드 실행");
		System.out.println(new Cat());
	}
}
