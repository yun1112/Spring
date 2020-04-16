package chap3;

public class prac6 {

	public static void main(String[] args) {
		int num=24;
		int result=(num%10)>0 ? (int)(Math.round(((float)(num/10)+1)*10)):(int) (float)(num/10)*10;
		System.out.println(result-num);
	}

}
