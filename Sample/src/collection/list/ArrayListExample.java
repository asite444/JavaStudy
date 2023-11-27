package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<CityVo> cityArray=new ArrayList<CityVo>();
		String str[]=new String[10];
		cityArray.add(new CityVo(80, "한국", "서울"));
		cityArray.add(new CityVo(81, "한국", "부산"));
		cityArray.add(new CityVo(82, "한국", "대구"));
		cityArray.add(new CityVo(83, "한국", "대전"));
		cityArray.add(new CityVo(70, "중국", "충칭"));
		cityArray.add(new CityVo(71, "중국", "북경"));
		cityArray.add(new CityVo(72, "중국", "청두"));
		cityArray.add(new CityVo(60, "일본", "도쿄"));
		cityArray.add(new CityVo(61, "일본", "오사카"));
		cityArray.add(new CityVo(62, "일본", "후쿠오카"));
		//toString 재정의
		//System.out.println(cityArray.toString());
		
		System.out.println(cityArray.get(1).cityName);
		System.out.println(cityArray.get(2).toString());
		
		
		for(int i=0;i<cityArray.size();i++) {
			CityVo city=cityArray.get(i);
			System.out.println(city);
			
		}
		System.out.println("------------개선루프-------");
		for(CityVo city:cityArray) {
			System.out.println(city);
		
		}
	}

}

class CityVo {
	int cityNumber;
	String cityContry;
	String cityName;
	
	public CityVo(int cityNumber,String cityContry,String cityName) {
		this.cityNumber=cityNumber;
		this.cityContry=cityContry;
		this.cityName=cityName;
				
	}

	public int getCityNumber() {
		return cityNumber;
	}

	public String getCityContry() {
		return cityContry;
	}

	public String getCityName() {
		return cityName;
	}
	
	@Override
	public String toString() {
		return String.format("[%d-%s-%s]",cityNumber,cityContry,cityName );
	}
}
