package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	void showData() {
		System.out.println("이름은 " + this.name + "이고, 나이는 " + this.age + "살 입니다");
	}

	@Override
	public int compareTo(Person o) {
		int result = 0;

//		if (this.age > o.age) {
//			result = 10000;// 양수
//		} else if (this.age < o.age) {
//			result = -1;// 음수
//		} else {
//			result = 0;
//		}
		
		result=(this.age-o.age)*-1;
			
		return result;
	}

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();// 타입 생략 가능
		treeSet.add(new Person("Son", 27));
		treeSet.add(new Person("King", 30));
		treeSet.add(new Person("Lee", 20));

		Iterator<Person> iter = treeSet.iterator();
		
		while(iter.hasNext()) {
			iter.next().showData();
		}
	}
}
