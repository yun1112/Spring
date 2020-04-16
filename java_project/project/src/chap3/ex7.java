package chap3;

public class ex7 {

	public static void main(String[] args) {
		int n=0;
		while(n<100) {
			n++;
			System.out.println(n);
		}
		
		do {
			System.out.println(n);
			n--;
		}while(n>0);
	}

}
