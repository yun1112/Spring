package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	//###interface
	//모든 메서드: 추상 메서드
	//모든 멤버변수: 상수
	
	String getViewPage(HttpServletRequest request, HttpServletResponse response);
}
