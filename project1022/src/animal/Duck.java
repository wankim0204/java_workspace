package animal;

public class Duck extends Bird{
     String name="오리";

     public Duck(String  n){ //개발자가 생성자를 명시하면, 컴파일러는 더이상 관여하지 않아요!!
     					//따라서1개입니당
		super();
		name=n;
		
     }

     public static void main(String[] args){
         //name="도날드";         //(가)
         //Duck d=new Duck();   //(나)
         //d.name="도날드”;      //(다)
         //d.fly=false;               // (라)

		Duck d=new Duck("도널드");   //(나)
     }
}