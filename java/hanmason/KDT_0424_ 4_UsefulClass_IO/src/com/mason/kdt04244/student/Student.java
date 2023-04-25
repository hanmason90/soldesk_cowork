package com.mason.kdt04244.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String name;
	private Date birth;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(E)");
//	private Subject score;

	public Student() {
		this.avg=((double)this.kor+this.eng+this.math)/3;
		// TODO Auto-generated constructor stub
	}

	public Student(String line, int x) throws ParseException {
		String[] line2 = line.split(",");
		this.name = line2[(x*5)+0];
		this.birth = sdf.parse(line2[(x*5)+1]);
		this.kor = Integer.parseInt(line2[(x*5)+2]);
		this.eng = Integer.parseInt(line2[(x*5)+3]);
		this.math = Integer.parseInt(line2[(x*5)+4]);
		this.avg=((double)this.kor+this.eng+this.math)/3;
	}
	
//	public Student(String line) throws ParseException {
//		String[] line2 = line.split(",");
//		this.name = line2[0];
//		this.birth = sdf.parse(line2[1]);
//		this.kor = Integer.parseInt(line2[2]);
//		this.eng = Integer.parseInt(line2[3]);
//		this.math = Integer.parseInt(line2[4]);
//	}

	public Student(String name, Date birth, Subject score) {
		super();
		this.name = name;
		this.birth = birth;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date converToDate(String line) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = sdf.parse(line);
		return d;
	}
	
	public void print() {
		System.out.printf("이름\t: %s\n",name);
		System.out.printf("생일\t: %s\n",sdf2.format(birth));
		System.out.printf("국어\t: %d\n",kor);
		System.out.printf("영어\t: %d\n",eng);
		System.out.printf("수학\t: %d\n",math);
		System.out.printf("평균\t: %.1f\n",avg);
	}
	
}
