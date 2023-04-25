package com.mason.kdt04244.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class UICOMain2_ver2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	String[] inputArr = {"이름\t\t: ","생일(YYYYMMDD)\t: ","국어\t\t: ","영어\t\t: ","수학\t\t: "};
	StringBuffer sb = new StringBuffer();
	for(int i=0;i<inputArr.length;i++) {
		System.out.print(inputArr[i]);
		sb.append(sc.next()+"\r\n");
	}
	sc.close();

	String totalString = sb.toString();
	
	BufferedWriter bw = null;
	try {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\HanYD\\Desktop\\student.csv");
		OutputStreamWriter ows = new OutputStreamWriter(fos, "utf-8");
		bw= new BufferedWriter(ows);
		bw.write(totalString);
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
