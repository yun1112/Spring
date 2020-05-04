package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("Forth");

		System.out.println("저장된 데이터의 개수:"+set.size());
		
		Iterator<String> iter=set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());//Iterator 저장 순서 없음
		}
	}
}