package javaClass.io.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import javaClass.io.vo.personVo;

public class TestPersonArrayLead {

	public static void main(String[] args) throws Exception {
		InputStream is=new FileInputStream("person_array.dat");
		
		//ObjectInputStream Filtering
		ObjectInputStream ois=new ObjectInputStream(is);
		
		//역 직렬화(배열)
		personVo[] p_array=(personVo[]) ois.readObject();
		
		for(personVo p:p_array) {
			System.out.println(p);
		}
		//닫기(역순)
		ois.close();
		is.close();
		
	}

}
