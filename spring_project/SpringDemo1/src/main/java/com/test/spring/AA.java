package com.test.spring;

public class AA {
	BB bb=new BB();//직접 코드 안에서 BB 객체 생성, 메소드 사용, AA는 BB 객체 가지고 있음->의존
	
	public void print() {
		bb.aa();
	}
}
