package com.mason.kdt04261.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


// 로그인 -> 신청 -> API키
// 정부사이트
//		data.go.kr
//		data.seoul.go.kr
//		data.gg.go.kr

// 포털사이트/SNS : 개발자센터

// http://openapi.seoul.go.kr:8088/54466b50546879643132356c774f4e66/xml/RealtimeCityAir/1/5/

// 1) HTTP 통신 수행해서 콘솔에 출력
// 2) XML 파싱
		//도심권
		//중구
		//20
		//8
		//보통
//		---------
//3) csv 파일에
//	2023,04,26,13,도심권,중구,20,8,보통
//
//
//
//-> 2~3시간마다 한번씩
public class UCHMain {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,");
		Date today = new Date();
		String todayS = sdf.format(today);
		BufferedWriter bw = null;
		
		HttpURLConnection hsuc = null;
		try {
			String urlString = "http://openapi.seoul.go.kr:8088/54466b50546879643132356c774f4e66/xml/RealtimeCityAir/1/5/";
			URL u = new URL(urlString);
//			HttpURLConnection
			hsuc = (HttpURLConnection) u.openConnection(); // <= http를 쓸지 https를 쓸지 몰라서 원래의 u 위치에 다형성을 선언함
			InputStream is = hsuc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream("C:\\Users\\HanYD\\Desktop\\RealtimeCityAir.csv",true);
			OutputStreamWriter os = new OutputStreamWriter(fos);
			bw = new BufferedWriter(os);
			
			
//			String line;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType(); // 읽어올 내용이 시작태그인지, 텍스트인지, 종료태그인지 어떤 것을 읽을지
			String tagName = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				// 전처리 과정
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("MSRRGN_NM")) {
						bw.write(todayS);
						xpp.next();
						System.out.println(xpp.getText());
						bw.write(xpp.getText()+",");
					}
					if (tagName.equals("MSRSTE_NM")) {
						xpp.next();
						System.out.println(xpp.getText());
						bw.write(xpp.getText()+",");
					}
					if (tagName.equals("PM10")) {
						xpp.next();
						System.out.println(xpp.getText());
						bw.write(xpp.getText()+",");
					}
					if (tagName.equals("PM25")) {
						xpp.next();
						System.out.println(xpp.getText());
						bw.write(xpp.getText()+",");
					}
					if (tagName.equals("IDEX_NM")) {
						xpp.next();
						System.out.println(xpp.getText());
						System.out.println("---------------");
						bw.write(xpp.getText()+"\r\n");
					}
				}
				
				xpp.next(); // <= 처리 후 다음 String 로드
				what = xpp.getEventType();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hsuc.disconnect();
	}
}
