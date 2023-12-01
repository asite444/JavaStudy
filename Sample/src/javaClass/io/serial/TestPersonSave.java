package javaClass.io.serial;

import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javaClass.io.vo.personVo;

public class TestPersonSave {
//직렬화 과정(데이터의 전송과정)
	public static void main(String[] args) throws Exception {
	personVo p=new personVo("임동현", 28, "서울시 은평구");//객체
	// "임동현", 28, "서울시 은평구"<--해당 데이터를 ' , ' 을 구분자로 지정하여 구분지음(CSV(Comma-Separated Values)파일형식)
	OutputStream out=new FileOutputStream("person.dat");
	//ObjectOutputStream Filterling => 이진타입으로 저장된다.
	ObjectOutputStream oos=new ObjectOutputStream(out);
	
	//객체 전체를 한번에 저장(직렬화<-데이터 분해(데이터 타입정보,실제 데이터등...))
	oos.writeObject(p);
	
	//닫기(열린 역순)
	oos.close();
	out.close();
	
	}

}
