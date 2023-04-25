package com.mason.kdt04244.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1) 그 csv읽어서 콘솔 출력
//2) 분리해서 읽게
//		ex) 홍길동, 1990
//			=> 홍길동
//			=> 1990
public class UCIOMain3 {
	public static void main(String[] args) {
		FileInputStream fis;
		BufferedReader br = null;
		try {
			fis = new FileInputStream("C:\\Users\\HanYD\\Desktop\\student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line;
			StringTokenizer st = new StringTokenizer(line = br.readLine(), ",");
			while (st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
			// while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
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
