package chap3;

public class ex8 {

	public static void main(String[] args) {
		int num = 0, sum = 0;
		while (num <= 1000) {
			if (num % 2 == 0 && num % 7 == 0) {
				System.out.println(num);
				sum += num;
			}

//			System.out.println(num);
			num++;
		}
		System.out.println(sum);
	}

}
