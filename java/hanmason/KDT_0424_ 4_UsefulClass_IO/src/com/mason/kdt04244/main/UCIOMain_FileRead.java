package com.mason.kdt04244.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UCIOMain_FileRead {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			// InputStreamReader (2byte) 개조형 FileReader : 이미 인코딩 깨짐 => 단계를 낮추자
//			FileReader fr = new FileReader("C:\\Users\\HanYD\\Desktop\\kdt0424.txt");
			
			//InputStream 개조형 (1byte)
			FileInputStream fis = new FileInputStream("C:\\Users\\HanYD\\Desktop\\kdt0424.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

//			String line;
//			while(br.readLine() !=null) {
//				System.out.println(br.readLine());
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
