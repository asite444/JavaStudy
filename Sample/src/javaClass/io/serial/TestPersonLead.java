package javaClass.io.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import javaClass.io.vo.personVo;

public class TestPersonLead {

	public static void main(String[] args) throws Exception {
		InputStream is=new FileInputStream("person.dat");
		
		//ObjectInputStream Filtering
		ObjectInputStream ois=new ObjectInputStream(is);
		
		//재 조립,데이터 타입은 이 시점에서 알수 없음(그래서 최상위 객체 Object 타입으로 지정함)
		
		/*
		여기서 java.io.InvalidClassException 터질 경우, VO클래스 정보가 달라졌기 때문(즉 personVO 클래스 중간에 수정하지 말것)
		즉, TestPersonSave에서 객체 데이터 저장 후, TestPersonLead을 실행하기 전,PersonVO를 단 한자라도 변경후 저장해 버리고 나서
		TestPersonLead 실행시켜 데이터를 읽어들이려 하는 순간,  Save측에서 저장한 PersonVO 정보와(수정 전 VO)
		TestPersonLead 에서 가지고있는 PersonVO 정보(수정 후VO)가 서로 달라 발생하는 에러이다. 
		ois.readObject();<--역 직렬화
		*/
		
		//personVo객체이지만,ObjectInputStream은 Object형식의 객체로 주기 때문에 다운캐스팅을 해줘야 함
		//직렬화 할때 Object 타입으로 업케스팅 하는게 아님
		//파일 내용을 읽어와서 역직렬화(재조립)
		personVo p=(personVo) ois.readObject();
		
		System.out.println(p);
		//닫기(역순)
		ois.close();
		is.close();
		
	}

}
