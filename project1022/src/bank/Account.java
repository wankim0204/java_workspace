//개발툴은 project1022로 다시 돌아오세요
package bank; //원본소스용 bank 패키지는 여러분이 직접 만들어야 합니다.

/*고객의 계좌를 정의한다 :업무가 신중해짐..예민한 데이터를 많이 다룸*/					
//패키지에 넣은 클래스를  public으로 공개하지 않으면 , 다른 어떠한 클래스도 이 
//클래스를 사용할수 없습니다. 이건 보안이 아니라, 그냥 의미없는 짓입니다.
//클래스는 쓰라고 만드는것이기 때문에  public으로 공개하되,  그 안의 내용들에 대해
//보안처리 하면 되는거에요~
//따라서  public으로 공개해주세요~!
public class  Account{
	/*계좌에 들어갈 만한 속성들 정의하고 점심시간 갖겠습니다*/

	/*아래처럼 멤버변수를 수정해 주세요 접근제한자를 앞에 붙여주세요
	지금부터, 이 클래스의 접근제한자가 어떠한 작용을 하는지, 외부의 클래스에서
	데이터에 접근하는 실습을 할껍니다
	저중에 특히 public 은 보안이라고 말할 수 없으므로, 언제나 빼고 생각하세요 
	public 은 그냥 공개입니다 따라서 여러분들은 protected, default, private만
	신경쓰시면 됩니다
	*/
	public String bank="기업은행"; //은행명
	protected String customer; //고객이름  
	String num="022-388-85465"; //계좌번호
	private int balance=100000; //금액  진짜 중요한 변수...
	
	//아무도 못쓰게 막았으니, 현재 Account 클래스 스스로만 접근할 수 있어요..
	//따라서 멤버메서드를 제공해줍시다 
	//아래와 같이 해주세요..
	//아래의 메서드는  public 이므로, 모든~~객체가 접근할 수 있어요.. 
	//UseAccont 에서 잔고를 수정하고 ,출력도 해봅시다.
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	//잔고확인 메서드 정의 
	//이와 같이 private으로 선언된 변수의 값을 리턴하는 메서드를 가리켜  getter 라 합니다.
	//그리고 위와같이  setBalance처럼 prviate 변수의 값을 변경하는 메서드를 가리켜 setter라 합니다
	//게터와 세터는 아주 아주 유명한 메서드 정의 기법이에요..
	public int getBalance(){
		return balance;
	}


}
