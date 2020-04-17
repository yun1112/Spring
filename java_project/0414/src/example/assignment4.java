package example;

public class assignment4 {

	public static void main(String[] args) {
		String str="12345";
		int sum=0;
		char num;
		for (int i = 0; i < str.length(); i++) {
			num=str.charAt(i);
			sum+=(int)num-'0';
		}
		System.out.println(sum);
	}

}
