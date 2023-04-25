package com.mason.kdt04244.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.mason.kdt04244.student.Student;

//1) 그 csv읽어서 콘솔 출력
//2) 분리해서 읽게
//		ex) 홍길동, 1990
//			=> 홍길동
//			=> 1990
//3) 학생객체

// python : Hybrid한 OOP언어 (자바랑 같은 포지션)
//			그런데 왜 이게 분석툴??
//			파이썬에서 객체 개념이 부족함

//4) 정리
//----------------------전처리

// --------- 분석
//5) 1등학생 정보 출력
//	학생'들' 이 필요함
public class UCIOMain3 {
	public static void main(String[] args) {
		FileInputStream fis;
		BufferedReader br = null;
		try {
			fis = new FileInputStream("C:\\Users\\HanYD\\Desktop\\student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			// csv 파일이 2TB -> RAM이 한번에 2TB를 읽는가? >> 파이썬의 단점

			// python : csv파일 전체 다 읽어서..
			// java : csv파일에서 한줄만 읽어서 처리하고
			// 다음줄..

			// 내방법
//			String line=null;
//			StringTokenizer st = new StringTokenizer(line = br.readLine(), ",");
//			while (st.hasMoreTokens()) {
//				System.out.println(st.nextToken());
//			}

			// 그냥 읽기
			// while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}

			// 강사님 방법
			String line = null;
			String[] lineArr = null;
//			String[] variable = {"name","birth","korScore","engScore","mathScore"}
			while ((line = br.readLine()) != null) {
				lineArr = line.split(",");
				int stuNum = (lineArr.length)/5;
//				int stuNum = 1;
				Student[] students = new Student[(lineArr.length) / 5];
				for(int i=0;i<stuNum;i++) {
					students[i]= new Student(line,i);
					students[i].print();
					System.out.println("-------------");
				}
				
				int maxAvg=0;
				int index=0;
				for(int i=0;i<stuNum;i++) {
					if(maxAvg<students[i].getAvg()) {
						index=i;
					}
				}

				System.out.printf("1등 : %s\n",students[index].getName());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
