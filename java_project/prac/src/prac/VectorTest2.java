package prac;

import java.util.Vector;

public class VectorTest2 extends Vector{ // 다양한 종류의 객체를 담기 위해 Vector클래스를 확장한 클래스를 생성
	public VectorTest2(int i) {
		super(i);
	}
	public static void main(String[] args) {
		VectorTest2 v1=new VectorTest2(2);
		
		System.out.println("v1의 용량은 "+v1.capacity());
		System.out.println("v1의 크기는 "+v1.size());
		
		System.out.println("v1의 증가치는 "+v1.capacityIncrement);
		System.out.println("현재 요소의 수는 "+v1.elementCount);
		
		v1.addElement(new Integer(10));
		v1.addElement(new Double(10.0));
		v1.addElement(new String("안녕"));
		
		System.out.println("3개의 요소 삽입 후 현재 요소의 수 : "+v1.elementCount);
		
		if(v1.contains("안녕")) {
			System.out.println("안녕 문자열은 "+v1.indexOf("안녕")+"번째 인덱스에 있다");
		}
		
		System.out.println("1번째 인덱스의 요소는 "+v1.elementAt(1));
	}

}
