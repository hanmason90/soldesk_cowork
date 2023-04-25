package com.mason.kdt04244.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// 입력 : 
// --------------------
// 출력

public class UCIOMain_FileWrite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String input = sc.nextLine();
		sc.close();
		System.out.println("-----------");
		
		System.out.println(input);
		
		// 파일에 쓰기 편하게
		// OutputStreamWriter 개조해놓은
		// 파일은 없으면 만들어 줌, 폴더는 x
		//
		// Windows	: \
		// Linux	: /
		// Windows에서도 리눅스처럼 /써도 인식함
		// Stream 통로는 다 썼으면 빨리 닫아줘야 함
		// 그래야 다른 프로그램에서도 이 통로를 씀
		// fw위에 덮어 씌워놓은 bw, 연관된 것 중에는 하나만 닫으면 다 닫힘.
		BufferedWriter bw = null;
		try {
			
			
			
//			FileWriter fw = new FileWriter("C:\\Users\\HanYD\\Desktop\\kdt0424.txt",true); // fw는 2byte밖에 못보냄

//			FileWriter : OutputStreamWriter 개조형(2bytes) - 이미 글자단위를 이룸
						// => 인코딩방식을 지정할 새도 없이 이미 글자를 읽어놨음
						// => 이미 글자가 깨져버림
						// => 단계를 낮춘 FileOutputStream을 써야함

			FileOutputStream fos = new FileOutputStream("C:\\Users\\HanYD\\Desktop\\kdt0424.txt",true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw); // 그래서 더 큰 통로인 BufferedWriter를 덮어 씌움
			bw.write(input+"\n"); // 통로가 너무 커서 일반적인 양으로는 인식이 안됨 통로가 꽉 차야 전송됨
			// \r : 커서 맨 앞으로
			// \n : 줄만 바꾸기
			// win7까지의 메모장에서는 \n있으면 깨짐
			// 그래도 되도록이면 \r 커서바꿈 해주는게 좋다
			bw.flush(); // 통로 용량이 꽉 안차도 강제 전송함
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			bw.close();// 다 쓰고나면 닫아줘야한다. bw가 닫히면 fw도 닫힘
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
