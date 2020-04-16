package chap3;

public class prac9 {

	public static void main(String[] args) {
		char ch = 'z';
		boolean b=((ch>'a')&&(ch<='z')||(ch>'A')&&(ch<='Z')) ? true : false;
		System.out.println(b);
	}

}
