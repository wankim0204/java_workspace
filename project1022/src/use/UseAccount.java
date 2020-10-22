/* use 패키지에서 Account 계좌클래스를 접근해보겠습니다.*/


/*질문) 현재 클래스는  public 으로 공개해야 할까요, 하지않아야 할까요?
O, X ? 현재 클래스는 사용을 당하는 클래스인가요? 사용하려는 클래스인가요?
그렇죠, 사용을 하려는 쪽은 공개가 될필요가 없죠...사용당하는 쪽만 공개하면 됩니다
결론은 이 클래스는 공개할 필요없겠네요..
UseAccount(사용하려는 객체) --->  Account(사용당할 객체) 공개되어야 함
*/
package use;
//사용하려는 클래스의 위치 알려줍니다.
import bank.Account; //bank 이전의 경로는 이미 classpath 에 등록되어있죠..
class  UseAccount{
	public static void main(String[] args){
		Account acc = new Account();//계좌 클래스 생성 (public 이라 여기까지는
		//무조건 가능함)
		//이제 접근제한자 별로 접근해보겠습니다. 

		//bank 은행명은 public 으로 선언되어 있으므로, 무조건 접근이 가능하겠죠? 
		System.out.println(acc.bank);//잘 나옵니다..당연합니다  public 이므로..
		
		//customer는  protected로 선언되어 있으므로 상속관계에 있거나, 같은 패키지
		//경우에만 접근이 가능합니다..현재  UseAccount는 Account와 상속관계가 없고
		//서로 다른 패키지이므로, 데이터 접근이 불가능할 겁니다.테스트해보세요 
		//컴파일시 에러 나는거 보이시죠? customer has protected access in Account
		//System.out.println(acc.customer); 주석처리 하시고 그 다음 변수 테스트합니다

		//계좌번호 num변수는 ,개발자가 아무것도 명시하지 않았는데요, 이러한 접근제한자를 default
		//접근제한자라 하고, 여러분들이 default 라는 키워드를 명시해서는 안됩니다..그냥 냅두셔야 합니다
		//default 접근 제한자는 같은 패키지에 있는 클래스끼리만 접근을 허용해주므로,  protected보다
		//한단계 더 까다롭습니다. (즉 상속관계에 있어도, 같은 패키지가 아니라면 접근 불가임..)
		//System.out.println(acc.num);	//컴파일해 보세여
		//num is not public in Account, cannot be accessed from outside package
		//"공개되어 있지 않으므로 외부에서 접근이 불가능합니다" 라는 메시지가 나옵니다.
		//우리가 지금까지 실습했던 모든~~~클래스가 사실 default 였고, 우리는 같은 디렉토리에서
		//실습을 해왔기 때문에 지금까지 이런 에러를 만나지 않았던것 뿐이에요..이제 패키지를 사용하기 
		//때문에 접근제한자를 조금 아셔야 합니다 

		//계좌 잔액 balance 를 테스트해 봅니다 .
		//balance는 가장 강력한 접근제한자인 private이 적용되어 있으므로, Accont 클래스 스스로
		//만 접근이 가능합니다..따라서 우리는 Account 자신이 아니라서 ,절대 절대 사용못합니다..
		//완전 폐쇄적이죠..
		//주석으로 막아주세요 이 코드
		//System.out.println(acc.balance); //컴파일하면 에러납니다.
		//balance has private access in Account(private 접근제한자가 적용되어 있다는 의미)

		//이제 다실습했으니 대충 누가 더 강력한 접근제한자 인지 아시겟죠? 
		//공부하실때는 public 은 그냥 빼고 공부하세요, 퍼블릭은 보안 자체가 없는거니까요.. 
		//한가지 궁금해집니다..private 은 너무 강력해서 아무도 못쓰는데 그럼 왜 만든것일까요?
		//그림 하나 그리겟습니다...
		//acc.balance = 10; //이 방법은 직접 접근이므로 불가능
		acc.setBalance(10); //10원으로 수정 , 이 방법은 메서드를 통해 접근이므로 가능
		//이제 잔고가 수정이 된겁니다..
		//그런데 수정된 잔고를 어떻게 확인하나요? 변수에 접근을 막았으니...
		//잔고 수정이 아니라, 잔고에 접근하려는것 또한 메서드를 제공해주셔야 합니다. 
		//마치 리모콘에서 채널 전환버튼만 있는게 아니라, 현재 채널 확인버튼도 있듯이요~
		//잔고 확인합니다, 정리가 되셨나요? 10분 쉬었다 합시당 ^^
		System.out.println(acc.getBalance());
	}
}


















