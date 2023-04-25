package com.mason.kdt043243.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

// deprecated (중요도가 떨어진, 앞으로 사라질) = 이 경고가 뜨는 메소드는 쓰지마라
//				=> 현재 버전에서는 괜찮은데 (유예기간)
//				=> 다음 버전에 없어져도 책임안짐

// Date : Java 초창기에 만들어진 클래스 (2000년대를 생각하지 않음..)
//			세월이 가고, 기술도 발전
//			어떤 기능이 더 이상 못쓰게 됨
//			-> 없애고 새 기능을 만들든지, 업그레이드 시키든지...


// 버전

//		1.10.2 -> 1.10.3 -> 1.11.0
//		minor버전
//			뒷자리가 바뀔수록 살짝 바뀐거
//		mason버전
//		1.10.2 -> 2.0.0

// win 3.1
// win95 -> win98
// 4.0   -> 4.1

// 아이폰3
// iOS			-> iOS4			-> iOS5
// 갤럭시S
// Android2.1	-> Android2.2	-> Android2.3

import java.util.Date;
import java.util.StringTokenizer;

public class UCDMain_Date {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
	
		// Date -> String
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String y = sdf.format(now);
		System.out.println(y);
		
	
		try {
			String s = "2023-06-09";  // 특정시간날짜
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf2.parse(s); //<- 빨간줄, 에러를 살펴보자
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		
//		System.out.println(now.getYear()); // 연도
//		System.out.println(now.getMonth()); // 월
//		System.out.println(now.getDate()); // 일
		
	}
}
