package prac;

import java.util.Scanner;

public class manager {
	private ex1[] examples;
	private int N;
	private int cnt;
	private int type;
	Scanner sc;

	manager() {
		examples = new ex1[N];
		N = 0;
		cnt = 0;
		sc = new Scanner(System.in);
	}

	void checkType(ex1 e) {
		if (e instanceof ex1) {
		} else if (e instanceof ex2) {
		}
	}
void chooseType() {
	type=sc.nextInt();
	
}
	// String name, String id/ String age
	void addData() {
		
		String name = sc.nextLine();
		String id = sc.nextLine();
		switch(type) {
		case 2:
			String age=sc.nextLine();
			break;
		}
		examples[cnt] = new ex1(name, id);
		cnt++;

	}

	void printAllData() {
		for (int i = 0; i < cnt; i++) {
			examples[i].showData();
		}
	}
}
