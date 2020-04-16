package prac;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorPrac {

	public static void main(String[] args) {
		LinkedList<Integer> InkList=new LinkedList<Integer>();
		InkList.add(4);
		InkList.add(3);
		InkList.add(2);
		InkList.add(1);
		
		Iterator<Integer> iter=InkList.iterator();
		
		//boolean hasNext(); //해당 iteration이 다음 요소를 가지고 있으면 true, 더이상 다음 요소를 가지고 있지 않으면 false 반환
		while(iter.hasNext())//연결리스트를 반복자를 사용하여 순회
			System.out.println(iter.next()+" ");//iteration의 다음 요소를 반환
	}

}
