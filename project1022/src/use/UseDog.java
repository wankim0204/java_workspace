package use;
//주석 가능하죠
//원래는 D:\workspace\java_workspace\project1022\bin/use 이죠?
//근데 use 앞에 bin까지를 환경변수로 등록하면 됩니다
//등록하러 갑시다
import  animal.Dog;//사용하고자 하는 클래스의 위치 명시 
//Dog이라는 클래스의 package 선언부를 그대로 적으시면 됩니다
		
			
class UseDog{
	public static void main(String[] args){
	//현재 클래스와는 다른 경로에 있는 클래스를 사용해야 하는데, 
	//컴파일러가 어떻게 Dog.class를 찾을 수 있는지 알아야 합니다.
	//현재로서는 컴파일러가 UseDog과 같은 디렉토리만 찾아 헤맵니다.
	//따라서 아래의 코드는 cant find symbol  에러 날겁니다
	//이 문제를 해결하려면, 여러분들은 클래스의 경로를 알려줘야 하는데, 
	//일반적으로 경로를 등록할때는 환경변수를 이용합니다 
	//경로가 일반 파일일 경우는 path 환경변수 이지만, 
	//경로가 클래스 파일일 경우는 classpath 환경변수를 이용하면 됩니다.
	//이때, classpath 환경변수에 어느 경로를 등록해야 할지 고민해보세요 
	//외우지 마시고 , 간단히 생각해보세요 현재 UseDog 클래스와 Dog
	//클래스에서 우리가 생략한 경로가 무엇인지 확인해봅시다, 위를 보세요

		Dog d = new Dog(); //컴파일해서 시도해보세요 !! ctrl+1
		d.run(); //메서드 호출 추가하고 재 컴파일!!
	}
}
