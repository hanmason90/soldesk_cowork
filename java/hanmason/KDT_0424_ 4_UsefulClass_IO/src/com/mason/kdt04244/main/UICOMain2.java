package com.mason.kdt04244.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// encoding
// 문자열 - encoding -> 10110.... -decoding-> 문자열
// 인코딩 방식이 여러종류...
// 문자열 -A방식 인코딩-> 11101
// 문자열 -B방식 인코딩-> 10001
// 다 다르다..

// 전세계적으로 가장 많이 쓰이는 인코딩 : utf-8
// 국내 랭킹 2위 : euc-kr

// 표준을 안지키는 회사 : MS, Apple


// 빅데이터
//		기상청에서 데이터를 받아왔는데 : A
//		내가 디코딩할 때 : C <- 깨짐


// 이름 :
// 생일(YYYYMMDD) :
// 국어 :
// 영어 :
// 수학 :
// -----------------------------> student.csv에 저장되게
// 확장자	:	윈도우에만 존재하는 허상
//			뭔지 알기 편할 뿐
// aaaa.txt : 메모장에서 열면 잘 열리는 파일
// bbbb.hwp : 한글에서 열면 잘 열리는 파일
// cccc.xls : 엑셀에서 열면 잘 열리는 파일
//
// 중요한건 확장자가 전용파일이라는 의미는 아님
// .csv(comma separated value)
//		각 값들이 ,로 구분된 파일 => 규칙적이기 때문에 엑셀에서 잘 열림

// 엑셀 일반적으로 utf-8 열면 깨짐 (설정 필요함)


public class UICOMain2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("이름\t\t: ");
	String name = sc.next();
	System.out.print("생일(YYYYMMDD)\t: ");
	String birth = sc.next();
	System.out.print("국어\t\t: ");
	int korScore = sc.nextInt();
	System.out.print("영어\t\t: ");
	int engScore = sc.nextInt();
	System.out.print("수학\t\t: ");
	int mathScore = sc.nextInt();
	
	StringBuffer sb = new StringBuffer();
	sb.append(name+",");
	sb.append(birth+",");
	sb.append(korScore+",");
	sb.append(mathScore+",");
	sb.append(engScore+",");
	String totalInput = sb.toString();
	
	
	BufferedWriter bw = null;
	try {
//		FileWriter fw = new FileWriter("C:\\Users\\HanYD\\Desktop\\student.csv");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\HanYD\\Desktop\\student.csv",true);
		OutputStreamWriter ows = new OutputStreamWriter(fos, "utf-8");
		bw= new BufferedWriter(ows);
//		bw.write(name+"\r\n");
//		bw.write(birth+"\r\n");
//		bw.write(korScore+"\r\n");
//		bw.write(engScore+"\r\n");
//		bw.write(mathScore+"\r\n");
		bw.write(totalInput);
		bw.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		bw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
