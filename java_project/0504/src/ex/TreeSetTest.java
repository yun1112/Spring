package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet=new TreeSet<Integer>();//트리는 정렬 순서 가짐, 중복 허용 안함
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);

		System.out.println("요소의 개수:"+treeSet.size());

		Iterator<Integer> iter=treeSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
