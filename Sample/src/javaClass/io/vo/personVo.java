package javaClass.io.vo;

import java.io.Serializable;

//객체 직렬화 할때 getter,setter 안 만들면 전송 안됨
//객체 직렬화가 지원되도록 설정(implements Serializable)
//지금 이 클래스 정보를 Save를 통해 직렬화 시켜 객체 정보를 파일로 저장된 상태에서
//read쪽에서 읽어들이기 전 수정해 버리면 에러터질 것이므로, 이곳 수정은 신중하게 할것
//단,들여쓰기수정, 주석문 수정 등은 무관함,메서드 수정이나 변수 추가등의 객체정보 변경만 문제임
public class personVo implements Serializable{

	private String name;
	/*transient*/ private int age; //이 정보를 공개하지 않으려고 한다면?-->transient,직렬화 대상에서 제외
	private String addr;
	 
	public personVo() {
		
	}
	
	
	public personVo(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		
		return String.format("[%s-%d-%s]", name,age,addr);
	}
}
