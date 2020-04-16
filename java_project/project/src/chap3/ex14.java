package chap3;

public class ex14 {

	public static void main(String[] args) {
//		A B
//		B A
//		----
//		9 9
		int res1,res2,res3;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <10; j++) {
				res1=10*i+j;
				res2=10*j+i;
				res3=res1+res2;
				if(res3==99)
					System.out.println("A="+i+", "+"B="+j);
			}
		}
		 
	}

}

//
//for(int number=0;number<10;number++) {
//	int a,b;
//	a=number;//10a+10b+a=99->11a+11b=99->a+b=9->b=9-a
//	b=9-a;;
//	System.out.println("a="+number+"+일때,b="+b+"입니다");
//}