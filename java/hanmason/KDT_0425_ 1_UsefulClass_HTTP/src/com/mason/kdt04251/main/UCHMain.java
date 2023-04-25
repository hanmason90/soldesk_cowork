package com.mason.kdt04251.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// 통신
//		HTTP통신		: 요청(인터넷)			=> 자바에 없음
//		Socket통신	: 실시간통신 (카카오톡)	=> 자바에 있음
//			그래픽기반의..

//
// 서버		- 서비스를 제공해주는 컴
// 클라이언트	- 서비스를 이용하는 컴
//
// JSP - Spring : HTTP서버 구현하는 기술
//	웹개발
//		- 웹사이트 제작
//		- 데이터만 제공하는 시스템    <== 이게

// Sprint(8) + jQurey(2)
// SpringBoot(2) + react(8)    <== 이거
//
//	빅데이터
//		관련사업
//			분석가 : 분석해주는 사람
//			시스템구축 : 인프라 구축
//			데이터 판매
//				종이에 프린트 - X
//				파일? - 2TB
//
//
// 남의 HTTP서버쓰고
// HTTP 클라이언트

//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4311256000
public class UCHMain {
	public static void main(String[] args) {
		
		try {
			// HTTP통신 관련 기능이 Java에 없음
			// => 직접 만들어야함 => 그런데 다른 개발자가 만들어 놨을텐데? => 가져다 쓰자! https://aphache.org
			DefaultHttpClient dhc = new DefaultHttpClient();
			
			// 서버에 요청 : GET 방식, POST 방식 두종류
			//				GET방식이 기본적으로 많이 씀
			HttpGet hg = new HttpGet("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4311256000");
			// 응답
			HttpResponse hr = dhc.execute(hg);
			//누가응답
			//시간... 등 많은 정보가 있을 수 있음
			
			// 응답내용만 가지고 싶다
			HttpEntity he = hr.getEntity();
			
			InputStream is = he.getContent(); // <- 응답내용을 꺼낼 수 있는 통로
			
			InputStreamReader ir = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(ir);
			
//			System.out.println(br.readLine());
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			dhc.close();
		
			// 세션 : 서버-클라이언트의 연결 상태
			// 유지시간 : 30분
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
