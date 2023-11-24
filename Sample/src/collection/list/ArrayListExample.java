package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<City> cityArray=new ArrayList<City>();

		cityArray.add(new City(80, "한국", "서울"));
		cityArray.add(new City(81, "한국", "부산"));
		cityArray.add(new City(82, "한국", "대구"));
		cityArray.add(new City(83, "한국", "대전"));
		
		
	}

}

class City {
	int cityNumber;
	String cityContry;
	String cityName;
	
	public City(int cityNumber,String cityContry,String cityName) {
		this.cityNumber=cityNumber;
		this.cityContry=cityContry;
		this.cityName=cityName;
		
	}
}
