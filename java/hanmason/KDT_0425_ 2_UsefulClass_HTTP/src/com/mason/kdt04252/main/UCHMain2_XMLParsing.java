package com.mason.kdt04252.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


// parsing : 쓸데 없느 부분 걷어내고
//			원하는 형태로 가공하는 것
public class UCHMain2_XMLParsing {
	public static void main(String[] args) {
		HttpsURLConnection hsuc = null;
		try {
			String urlString = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4311256000";
			URL u = new URL(urlString);
//			HttpURLConnection
			hsuc = (HttpsURLConnection) u.openConnection(); // <= http를 쓸지 https를 쓸지 몰라서 원래의 u 위치에 다형성을 선언함
			InputStream is = hsuc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		hsuc.disconnect();

	}
}
