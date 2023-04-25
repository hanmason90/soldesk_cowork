package com.mason.kdt043243.main;

// 기본형 변수, 객체X -> 메소드가 없다
// 데이터가 heap에 있어야 하는 경우가 생김
// => 기본형에 해당하는 객체형
// => WrapperClass
public class UDCMain_WrapperClass {
	public static void main(String[] args) {
		int a = 10;
		Integer aa = new Integer(10);
		
		double b = 3.4;
		Double bb = new Double(3.4);
		
		// 기본형 -> 객체형 변환 : 생성자 쓰기
		
		boolean c= true;
		Boolean cc = new Boolean(c);
		
		// 객체형 -> 기본형 변환 : xxxValue()
		
		Long dd = new Long(123);
		long d = dd.longValue();
		
		// 기본형 -> 객체형 그냥 대입연산자 써도됨(autoboxing)
		int e = 10;
		Integer ee = e;
		
		// 객체형 -> 기본형 그냥 대입연산자 써도됨 (autounboxing)
		
		Double ff = 123.123123;
		double f = ff;
		
		// => 기본형 <-> 객체형 형변환은 자동
		
		System.out.println("--------------");
		
		int g = 30;
		String gg = g+"";
		String ggg = String.format("%d", g);
		String gggg = Integer.toString(g);
		
		// String -> WrapperClass -> 기본형
		String hhh = "12.345";
		Double hh = Double.parseDouble(hhh);
		double h = hh.doubleValue();
		
		String iii = "890";
//		Integer ii = Integer.parseInt(iii);
//		int i = ii.intValue();
		int i = Integer.parseInt(iii);
	}
}
