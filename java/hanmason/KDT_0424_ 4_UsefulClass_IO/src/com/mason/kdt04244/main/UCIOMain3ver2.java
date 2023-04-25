package com.mason.kdt04244.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mason.kdt04244.student.Student;

public class UCIOMain3ver2 {
	public static void main(String[] args) {
		FileInputStream fis;
		BufferedReader br = null;
		try {
			fis = new FileInputStream("C:\\Users\\HanYD\\Desktop\\student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			String[] lineArr = null;
			while ((line = br.readLine()) != null) {
				lineArr = line.split(",");
				int stuNum = (lineArr.length)/5;
				Student[] students = new Student[stuNum];
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

				System.out.printf("1등 : %s (%.1f점)\n",students[index].getName(),students[index].getAvg());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
