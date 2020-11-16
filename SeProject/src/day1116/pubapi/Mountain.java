/*
 * 산 1개를 담게될 클래스 정의
 * */
package day1116.pubapi;

public class Mountain {
	/* 멤버변수로는 오픈 데이터 포털의 산정보에 있는 모든 데이터를 다 넣기엔 너무 많으니깐
	  원하는것 골라서 담겠습니다.
	  적어도 산의 이름은 있어야 하니깐 산 이름에 해당하는 xml 태그가 뭔지 조사해보실래요? 좋아요 mntnnm
	  이정도만 합시다!!!! 
	  은닉화 시켜주세요(getter / setter 만들기 )
	  
	  */
	private int mntnid;//산의 고유 코드
	private String mntnnm; //산이름 담게될 변수 
	private String mntninfopoflc;//산정보소재지(소재지)
	private String mntninfohght; //산높이
	
	public int getMntnid() {
		return mntnid;
	}
	public void setMntnid(int mntnid) {
		this.mntnid = mntnid;
	}
	public String getMntnnm() {
		return mntnnm;
	}
	public void setMntnnm(String mntnnm) {
		this.mntnnm = mntnnm;
	}
	public String getMntninfopoflc() {
		return mntninfopoflc;
	}
	public void setMntninfopoflc(String mntninfopoflc) {
		this.mntninfopoflc = mntninfopoflc;
	}
	public String getMntninfohght() {
		return mntninfohght;
	}
	public void setMntninfohght(String mntninfohght) {
		this.mntninfohght = mntninfohght;
	}
	
	
}
