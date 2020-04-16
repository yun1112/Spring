package chap3;

public class ex16 {

	public static void main(String[] args) {
		int i = 1, sum = 0;
		while (true) {
			if (i > 99)
				break;
			sum += i;
			i++;

		}
		System.out.println(sum);
	}

}