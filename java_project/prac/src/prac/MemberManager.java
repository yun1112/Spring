package prac;

import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class MemberManager {
	Scanner scan=new Scanner(System.in);
	Vector<Member> members=new Vector<Member>();
	public void Run() {
		int key=0;
		while((key=selectMenu())!=0) {
			
		}
	}
	
	int selectMenu() {
		System.out.println("");
		int key=scan.nextInt();
		scan.nextLine();
		return key;
	}
	
	void addMember() {
		int num=0;
		String name="";
		System.out.println("추가할 회원 번호:");
		num=scan.nextInt();
		System.out.println("회원 이름:");
		name=scan.nextLine();
		Member member=new Member(num,name);
		members.add(member);
		System.out.println(member.toString()+"");
	}
	
	void removeMember() {
		int num=0;
		System.out.println("삭제할 회원 번호");
		num=scan.nextInt();
		scan.nextLine();
//		Member member=Find(num);
	}
	
	/*
	 * Member Find(int num) {
	 * 
	 * }
	 */
//	Vector<String> vector = new Vector<String>(3);
//	
}

/*
 * Vector() 10개의 데이터를 저장할 수 있는 길이의 객체 생성 저장 공간이 부족할 경우 10개씩 증가
 * 
 * Vector(int size) Vector(int size,int incr) : size개의 데이터 저장할 수있는 길이의 객체 생성, 저장
 * 공간 부족한 경우 incr개씩 증가
 * 
 * 
 * Vector 클래스 Vector는 서로 다른 타입을 가지는 참좋ㅇ 데이터를 저장하는 가변 길이의 배열 기본형 데이터 저장할 수 업음 기본형
 * 데이터 저장하기 위해서는 기본형 데이터를 Wrapper 클래스 타입의 객체로 생성해야 함
 * 
 * 
 * Vector 클래스
 * ArrayList클래스와 같이컬렉션 프레임웍에서 가장 많이 사용되는 컬렉션 클래스
 * List인터페이스 구현하기 떄문에 List인터페이스 특징 가짐
 * 	1. 저장순서 유지
 * 	2. 중복 허용
 * 
 * ex) v.add(1,100); 인덱스 1위치에 100 요소 삽입
 * 새로운 요소 삽입 후에 나머지 요소들 한칸씩 뒤로 이동함
 * 
 * Vector 내의 Element 알아내기
 * 	1. get()메서드
 * 	2. elementAt()메서드
 * 
 * 
 * Vector에서 요소 Remove
 * v.remove(1);// 벡터v가 가리키고 있는 1번째 인덱스의 값을 삭제
 * v.removeAllElements(); 벡터의 모든 요소 삭제
 * 
 */
