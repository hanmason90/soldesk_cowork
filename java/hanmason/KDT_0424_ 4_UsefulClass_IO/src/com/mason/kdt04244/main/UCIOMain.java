package com.mason.kdt04244.main;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.print.PrintService;

//키보드 입력
//마우스 입력
//옆사람 입력

//콘솔 출력
//프린터 출력
//옆사람 출력

// 입력/출력 : Java - Stream이라는 통합된 시스템으로

// Stream 급
// Reader/Writer급
// BufferedWriter 급

// OutputStream	: 프로그램 -> 장치 (1byte)
// OutputStream Writer : 2bytes
// BufferedWriter : 줄 단위 1String

// InputStream	: 장치 -> 프로그램 (1byte)
// InputStream Writer : 2bytes
// BufferedReader : 엔터 입력 전까지 1String

// 그런데 자바 한 글자가 2bytes, Steam급으로는 모자람
//	=> 그래서 더 큰 입출력 통로를 덮음(Reader/Writer), 하지만 이 또한 문자열같이 긴 데이터를 전송하기엔 좁읍
// 	=> 이제는 BufferWriter급(String)으로 전송하는 통로를 덮음

// 개조형
// FileReader : 파일처리하게 편하게 개조해놓은 InputStreamReader
// PrintStream : 다양한 스타일로 데이터를 넣게 개조해놓은 OutputSream
// 이 밖에도 개조형은 다양함...

public class UCIOMain {
	public static void main(String[] args) {
		// System.out : 프로그램 -> 콘솔
		PrintStream ps = System.out;
		ps.println("출력!");

		// Systemd.in : 콘솔 -> 프로그램
		InputStream is = System.in;

		// 예전에는 콘솔 입력받는거 수작업으로 만들었음
		// Java 1.5 에서 Scanner 생김
		// InputSteam 쓰기 편하게 해주는 객체

		Scanner sc = new Scanner(is);
	}
}
