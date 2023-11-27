package javaClass.vo;
/*
 VO(Value Obkect) 		    : 값을 저장관리하는 객체(최근 자주 사용 됨)
 DTO(Data Transfer Object)  : Data 전달객체
 TO(Transfer Object)        :전달객체
 VO==DTO==TO

 1.VO getter/setter 생성해야 함 반드시
 2.Overload 된 생성자를 구현했으면, 기본 생성자는 반드시 생성할 것

 */

//개인정보를 저장관리하는 객체
public class PersonVO {

	private String name;
	private int age;
	private String address;

	public PersonVO() {

	}

	public PersonVO(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	

}
