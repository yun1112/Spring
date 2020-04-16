package chap3;

public class ex12 {

	public static void main(String[] args) {
		int num = 0, sum = 0, odd = 0, even = 0;
		while (true) {
			num++;
			if (num % 2 != 0) {
				sum += num;
				odd = num;
			} else {
				if (num % 3 == 0) {
					sum += num;
					even = num;
				}
			}

			if (sum > 1000) {
				System.out.println("odd " + odd + " even" + even);
				System.out.println(sum);
				break;

			}
		}
	}

}
