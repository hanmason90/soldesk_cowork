package com.mason.kdt043243.main;

import java.util.Scanner;

// 숫자(x,y,z,..... : 
// 중간에 이상한 글자 넣어도 작동 잘 되게 (예외처리)

// ---------------
// 합계 (33)

public class UCDMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 (a,b,c,...) : ");
		String num = sc.next();

		System.out.println("-----------");
		
		String[] numArr = num.split(",");
		int result = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			try {
				result += Integer.parseInt(numArr[i]);
			} catch (Exception e) {
//				continue; //있으나 마나 이 상황에서는 같음
			}
		}

		System.out.println("합계 : " + result);
	}
}
