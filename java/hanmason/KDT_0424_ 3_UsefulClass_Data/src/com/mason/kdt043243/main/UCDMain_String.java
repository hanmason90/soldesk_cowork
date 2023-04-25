package com.mason.kdt043243.main;

import java.util.StringTokenizer;

// Java - JSP -Spring - jQuery - 빅데이터 - 인터넷



// 수정이 불가능한 문자열 객체 - String
public class UCDMain_String {
	public static void main(String[] args) {
//		String s = new String("문자열");
		String s = "String은 문자열 객체입니다.";
		
		// s가 문으로 시작하나 확인하는 기능이 있을까?
		// 구글링?, 책? - X
		// => 객체의 기능을 가정하고 찾아보자
		// => 여부를 확인한다 => boolean 반환
		// => 시작한다..? => start...
		// OOP == 실생활을 묘사함 : 말도 안되는 경우는 드물다
		System.out.println(s.startsWith("S"));
		
		
		// s 글자수
		System.out.println(s.length());
		// 3번째 글자
		System.out.println(s.charAt(2));
		// 열은 몇번째에 있는지
		System.out.println(s.indexOf('열'));
		// String -> 스트링
		System.out.println(s.replace("String", "스트링" ));
		// 3번째에서 ~ 6번째 문자까지
		System.out.println(s.substring(2, 5));
		
		// 문자열 객체를 만들면서 %d(문자열 포멧팅)을 쓰려면
		String s2 = String.format("%.4f", 3.141592);
		System.out.println(s2);
		
		System.out.println("--------------------");
		
		// 문자열 붙이기 - 그런데 쓰지마라
		
		String s3 = "자바는 객체 지향 언어입니다.";
		System.out.println(s3.hashCode());
//		s3 = s3.concat("ㅋㅋㅋ");// 뒤에다가 ㅋㅋㅋ
//		System.out.println(s3.hashCode());
//		s3 += "ㄱㄱㄱ";// ㄱㄱㄱ
//		System.out.println(s3.hashCode());
//		
//		System.out.println(s3);
		
		// 문자열 대량으로 붙이기
		StringBuffer sb = new StringBuffer();
		sb.append("자바는 ");
		System.out.println(sb.hashCode());
		sb.append("객체 ");
		System.out.println(sb.hashCode());
		sb.append("지향 ");
		System.out.println(sb.hashCode());
		sb.append("언어입니다.");
		System.out.println(sb.hashCode());
		String s4 = sb.toString();
		System.out.println(s4);
		System.out.println(s4.hashCode());
		boolean t = s3.equals(s4);
		System.out.println(t);
		
		System.out.println("---------------");

		// 문자열 분리하기
		// 데이터 받아오면 String이 한 덩어리로 옴
		//	=> 문자열로 나누는 전처리 필요
		
		// 정형데이터	 날씨 온도  습도
		String s5 = "맑음,20.0,15.3";
		String[] s55 = s5.split(","); // 정형데이터에 유리
		System.out.println(s55[0]);
		System.out.println(s55[1]);
		System.out.println(s55[2]);
		
		System.out.println("---------------");
		
		// 비정형데이터
		String s6 = "유비는 귀가 크다.";
		StringTokenizer st = new StringTokenizer(s6," "); // 비정형데이터에 유리
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
