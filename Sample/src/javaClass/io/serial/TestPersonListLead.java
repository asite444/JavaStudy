package javaClass.io.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javaClass.io.vo.personVo;

public class TestPersonListLead {

	public static void main(String[] args) throws Exception {
		//=new ArrayList<personVo>();
				
		InputStream is=new FileInputStream("person_list.dat");
		
		//ObjectInputStream Filtering
		ObjectInputStream ois=new ObjectInputStream(is);
		
		//역 직렬화(배열)
		List<personVo> p_array =(ArrayList<personVo>) ois.readObject();
		
		for(personVo p:p_array) {
			System.out.println(p);
		}
		//닫기(역순)
		ois.close();
		is.close();
		
	}

}
