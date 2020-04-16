package prac;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {

		Vector<String> vector = new Vector<String>(3);// vector의 capacity 3씩 동적 증가
		System.out.println("vector의 크기: " + vector.size());
		System.out.println("vector의 용량: " + vector.capacity());

		vector.addElement("a");
		vector.addElement("b");
		vector.addElement("c");
		vector.addElement("d");
		vector.addElement("e");

		System.out.println("데이터 삽입 후 vector의 크기: " + vector.size());
		System.out.println("데이터 삽입 후 vector의 용량: " + vector.capacity());

		System.out.println("vector의 첫번째 요소: " + vector.elementAt(0));

		vector.removeAllElements();

		System.out.println("데이터 삭제 후 vector 의 크기: " + vector.size());
		System.out.println("데이터 삭제 후 vector의 용량: " + vector.capacity());// 용량은 증가된 상태 그대로 유지
	}

}
