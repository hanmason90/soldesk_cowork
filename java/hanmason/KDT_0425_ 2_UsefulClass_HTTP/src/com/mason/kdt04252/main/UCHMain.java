package com.mason.kdt04252.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// HTTP통신
// Java에는 HTTP통신 기능이 없었음 ( 이제는 생겼다는 말)

// 1) 그것이 자바
// 2) 자바에서는 HTTP 통신에 대한 기능이 너무 생략이 많이 되어있음
//		=> HTTP통신 구조 설명 불가

// HTTP 통신
//		HTTP
//		HTTPS
public class UCHMain {
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
