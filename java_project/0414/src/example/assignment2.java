package example;

public class assignment2 {

	public static void main(String[] args) {
		int i = 1, sum = 0;

		while (true) {
			if (i % 2 == 0)
				sum -=i;
			else if (i % 2 != 0)
				sum += i;

			if (sum >=100)
				break;
			i++;

		}
		System.out.println("i="+i);
	}
}