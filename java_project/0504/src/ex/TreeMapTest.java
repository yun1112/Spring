package ex;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer,String> map=new TreeMap<>();
		map.put(1, "data1");
		map.put(3, "data3");
		map.put(5, "data5");
		map.put(4, "data4");
		map.put(2, "data2");
		
		//Map -> Collection
		//Map -> Set
		NavigableSet<Integer> navi=map.navigableKeySet();
		
		System.out.println("오름차순 정렬");
		Iterator<Integer> iter=navi.iterator();
		while(iter.hasNext()) {
			System.out.println(map.get(iter.next()));
		}
		
		System.out.println("내림차순 정렬");
		iter=navi.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(map.get(iter.next()));
		}
	}
}
