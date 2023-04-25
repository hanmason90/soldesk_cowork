package com.mason.kdt043243.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UCDMain2 {
	public static void main(String[] args) {
		// 본인이 무슨 요일에 태어났나

		String birthDay = "1990.06.09";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.mm.dd");
		Date birth;
		try {
			birth = sdf1.parse(birthDay);
			SimpleDateFormat sdf2 = new SimpleDateFormat("E");
			String birthDate = sdf2.format(birth);
			System.out.println(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--------------");
		// 1990-06-09 한국나이로 몇살
		Date today = new Date();
		try {
			birth = sdf1.parse(birthDay);
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");
			int todayInt = Integer.parseInt(sdf3.format(today));
			int birthDayInt = Integer.parseInt(sdf3.format(birth));
			System.out.println((todayInt - birthDayInt) + 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 더 편한방법
		String birtYear = birthDay.substring(0, 4);
		int birthYearInt = Integer.parseInt(birtYear);
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");
		int curYearInt = Integer.parseInt(sdf3.format(today));
		int age = (curYearInt - birthYearInt) + 1;
		System.out.println(age);
	}
}
