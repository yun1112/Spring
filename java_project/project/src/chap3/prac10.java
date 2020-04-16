package chap3;

public class prac10 {

	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
		System.out.println("ch:" + ch);
		System.out.println("ch to lowerCAse:" + lowerCase);
	}

}
