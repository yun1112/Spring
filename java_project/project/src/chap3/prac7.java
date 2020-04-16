package chap3;

public class prac7 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (fahrenheit - 32) * (float) 5 / 9;
		float temp = celcius * 100;// 3777.778

		temp = (temp % 10) >= 5 ? temp + 1 : temp;

		temp = (int) temp;
		temp /= (float) 100;

		celcius = temp;

		System.out.println("Fahrenheit:" + fahrenheit);
		System.out.println("Celcius:" + celcius);
	}

}
