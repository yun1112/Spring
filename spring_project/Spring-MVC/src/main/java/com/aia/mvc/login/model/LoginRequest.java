package com.aia.mvc.login.model;

//빈즈는 반드시 디폴트 생성자가 있어야 함 
public class LoginRequest {
	private String uid;// loginForm에 있는 파라미터의 id명과 일치시켜야 매핑 가능
	private String upw;


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + "]";
	}

}
