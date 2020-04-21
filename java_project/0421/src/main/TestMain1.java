package main;

import modifier.Member;

public class TestMain1 {
	public static void main(String[] args) {
		Member member=new Member();
		member.setId("아이디");
		member.setName("이름");
		System.out.println(member.getId());//public 으로 변수 선언하거나  getter/setter 메서드 이용
		System.out.println(member.getName());
	}
}
