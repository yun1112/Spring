package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {
	public static void main(String[] args) {
		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
//		Set<String> set=new Hashset<>();

		set.add(new SimpleNumber(10));// 잘못된 데이터 타입을 저장하는 것을 막아줌
		set.add(new SimpleNumber(20));// SimpleNumber타입의 인스턴스 저장
		set.add(new SimpleNumber(10));

		System.out.println("저장된 데이터의 개수:" + set.size());

		Iterator<SimpleNumber> iter = set.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());// Iterator 저장 순서 없음
		}
	}
}

class SimpleNumber {
	int num;

	public SimpleNumber(int num) {
		this.num = num;
	}

	public String toString() {
		return String.valueOf(num);
	}
	
	//HashSet의 동등 비교 과정
	//1.Hash code를 비교해서 갇은 hash code를 가진 객체를 기반으로 비교
	//2.equals 메서드로 비교
	@Override
	public int hashCode() {
		return num%3;
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		// num의 값을 비교
		if (obj instanceof SimpleNumber) {// 형변환이 가능한 타입인지 확인
			SimpleNumber sm = (SimpleNumber) obj;// 강제 형변환
			result = (this.num == sm.num);
		}
		return result;
	}


}