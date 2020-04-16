package chap3;

public class prac {

	public static void main(String[] args) {
		int x=2,y=5; 
		char c='A';
		System.out.println(y+=10-x++);//y=15->x2 -> 15-2=13, 연산 끝나고 x3됨
		System.out.println(x+=2);//x=3+2=5
		System.out.println(!('A'<=c&&c<='Z')); //false
		System.out.println('C'-c);//'C'-'A' => 67-65=2
		System.out.println('5'-'0');
		System.out.println(c+1);//'A'+1=65+1=66
		System.out.println(++c);//B
		System.out.println(c++);//B
		System.out.println(c);//C

	}

}
