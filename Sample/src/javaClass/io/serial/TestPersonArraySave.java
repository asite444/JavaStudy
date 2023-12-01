package javaClass.io.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javaClass.io.vo.personVo;

public class TestPersonArraySave {

	public static void main(String[] args) throws Exception {
		personVo[] p_array= {
			new personVo("안중근",23,"서울1")
			,new personVo("신채호",23,"서울2")
			,new personVo("윤봉길",23,"서울3")
			,new personVo("장지연",23,"서울4")
			,new personVo("백범김구",70,"서울5")
		};
		
		OutputStream out=new FileOutputStream("person_array.dat");
		ObjectOutputStream oos=new ObjectOutputStream(out);
		
		//배열 객체저장
		oos.writeObject(p_array);
		
		oos.close();
		out.close();
		
	}

}
