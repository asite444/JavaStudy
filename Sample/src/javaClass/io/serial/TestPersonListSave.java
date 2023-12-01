package javaClass.io.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javaClass.io.vo.personVo;

public class TestPersonListSave {

	public static void main(String[] args) throws Exception {
		List<personVo> plist=new ArrayList<personVo>();
		
	
		plist.add(new personVo("안중근",23,"서울1"));
		plist.add(new personVo("신채호",233,"서울2"));
		plist.add(new personVo("고종",232,"서울3"));
		plist.add(new personVo("강감찬",233,"서울4"));
		plist.add(new personVo("김원봉",233,"서울5"));
		OutputStream out=new FileOutputStream("person_list.dat");
		ObjectOutputStream oos=new ObjectOutputStream(out);
		
		//배열 객체저장
		oos.writeObject(plist);
		
		oos.close();
		out.close();
		
	}

}
