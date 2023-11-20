package myutill;

import java.util.Calendar;

public class Jumin {
	Calendar calendar=Calendar.getInstance();
	private String juminNo;
	private final String[] CHEONGAN = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
	private final String[] IIZI = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};


	public String getJuminNo() {
		return juminNo;
	}
	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}

	/*
	 * 1042112
	 * 
	 * [성별코드에 따른 남녀구분 년대 구분법]
	 *            내국인  외국인
	 * 			  남  여  남  여
	 * 1900       1   2   5   6
	 * 2000       3   4   7   8
	 * 1800       9   0
	 * 
	 * 
	 * 
	 */
	public int getYear() {
		int year=Integer.parseInt(juminNo.substring(0,2));
		if(year>23) return 1900+year;
		else return 2000+year;
	}
	public String getGabja() {
		String gan=CHEONGAN[this.getYear()%10];
		String ji=IIZI[this.getYear()%12];
		//return에서 '+' 쓰지 않는게 좋다
		return String.format("%s%s",gan, ji);

	}
	public String getSeason() {
		String season;
		switch(Integer.parseInt(juminNo.substring(2, 4))) {
		case 3,4,5: season="봄";break;
		case 6,7,8: season="여름";break;
		case 9,10,11:season="가을";break;
		default: season="겨울";
		}
		return season;
	}
	public int getAge() {		 
		int age=calendar.get(Calendar.YEAR)-this.getYear();
		return age;
	}

	public String getArea() {
		String result;
		int arer=Integer.parseInt(juminNo.substring(8,10));

		if (0 <= arer && arer <= 8) {
			result = "서울특별시";
		} else if (9 <= arer && arer <= 12) {
			result = "부산광역시";
		} else if (13 <= arer && arer <= 15) {
			result = "인천광역시";
		} else if (16 <= arer && arer <= 25) {
			result = "경기도";
		} else if (26 <= arer && arer <= 34) {
			result = "강원특별자치도";
		} else if (35 <= arer && arer <= 39) {
			result = "충청북도";
		} else if (40 <= arer && arer <= 41) {
			result = "대전광역시";
		} else if ((42 <= arer && arer <= 43) || (45 <= arer && arer <= 47)) {
			result = "충청남도";
		} else if (arer == 96) {
			result = "세종특별자치시";
		} else if (48 <= arer && arer <= 54) {
			result = "전라북도";
		} else if (55 <= arer && arer <= 64) {
			result = "전라남도";
		} else if (arer == 65 || arer == 66) {
			result = "광주광역시";
		} else if ((67 <= arer && arer <= 69) || (76 <= arer && arer <= 77)) {
			result = "대구광역시";
		} else if ((70 <= arer && arer <= 75) || (78 <= arer && arer <= 81)) {
			result = "경상북도";
		} else if ((82 <= arer && arer <= 84) || (86 <= arer && arer <= 93)) {
			result = "경상남도";
		} else if (arer == 85 || arer == 90) {
			result = "울산광역시";
		} else if (94 <= arer && arer <= 95) {
			result = "제주특별자치도";
		} else {
			result = "알 수 없음";
		}

		return result;
	}

	public String getTti() {
		String tti;
		switch(this.getYear()% 12) {
		case 0:
			tti = "원숭이띠";
			break;
		case 1:
			tti = "닭띠";
			break;
		case 2:
			tti = "개띠";
			break;
		case 3:
			tti = "돼지띠";
			break;
		case 4:
			tti = "쥐띠";
			break;
		case 5:
			tti = "소띠";
			break;
		case 6:
			tti = "호랑이띠";
			break;
		case 7:
			tti = "토끼띠";
			break;
		case 8:
			tti = "용띠";
			break;
		case 9:
			tti = "뱀띠";
			break;
		case 10:
			tti = "말띠";
			break;
		case 11:
			tti = "양띠";
			break;
		default:
			tti = "알 수 없음";
			break;
		}
		return tti;
	}

	//주민번호가 유효한값인가?
	public  boolean isVaild() {
		int sum=0;
		sum=   (juminNo.charAt(0)-'0')*2;
		sum+=  (juminNo.charAt(1)-'0')*3;
		sum+=  (juminNo.charAt(2)-'0')*4;
		sum+=  (juminNo.charAt(3)-'0')*5;
		sum+=  (juminNo.charAt(4)-'0')*6;
		sum+=  (juminNo.charAt(5)-'0')*7;

		sum+=  (juminNo.charAt(7)-'0')*8;
		sum+=  (juminNo.charAt(8)-'0')*9;
		sum+=  (juminNo.charAt(9)-'0')*2;
		sum+=  (juminNo.charAt(10)-'0')*3;
		sum+=  (juminNo.charAt(11)-'0')*4;
		sum+=  (juminNo.charAt(12)-'0')*5;

		int chack_sum=(11-(sum%11))%10;
		System.out.println(chack_sum);

		//주민번호의 마지막 번호
		int last_sum=(juminNo.charAt(13)-'0');


		return (chack_sum==last_sum);
	}
	
	public  boolean isVaild2() {
		int sum=0;
		
		for(int i=0;i<13;i++) {
			if (i==6) continue;
			else if(i<=5)sum+=(juminNo.charAt(i)-'0')*(i+2);
			else if(i==7 || i==8) sum+=(juminNo.charAt(i)-'0')*(i+1);
			else sum+=(juminNo.charAt(i)-'0')*(i-7);	
		}


		int chack_sum=(11-(sum%11))%10;
		System.out.println(chack_sum);

		//주민번호의 마지막 번호
		int last_sum=(juminNo.charAt(13)-'0');


		return (chack_sum==last_sum);
	}
}
