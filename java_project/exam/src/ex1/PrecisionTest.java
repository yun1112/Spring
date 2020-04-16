package ex1;

import java.util.Iterator;

//import static java.lang.Math.pow;

public class PrecisionTest {

	public static void main(String[] args) {
		float f = 1.2345678901234567890f;
		double d = 1.2345678901234567890;
		float f2 = 0.1000000001f;
		double d2 = 0.1000000001;
		double d3 = 0.1000000000000001;

		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);

		System.out.println('1' + 2);
		byte b = 10;
		System.out.println(b);
		long l = 1000L;
		float ff = (float) l;
		System.out.println(ff);
		char ch = 1000;
		System.out.println(ch);
		float fff = 3.14f;
		System.out.println(fff);
		double ddd = 1.4e3f;
		System.out.println(ddd);
		char uuu = '\u0000';
		System.out.println(uuu);
		float f1 = 0.0f;
		System.out.println(f1);
		String str = null;
		System.out.println(str);
		String str1 = "";
		System.out.println(str1);

		float e = 1e1f;// 3.14e3f;
		System.out.println(e);
		float ff1 = 10.f;
		System.out.println(ff1);
		float ff2 = .10f;
		System.out.println(ff2);
		String s1 = null;
		System.out.println(s1);
		String s2 = "";
		System.out.println(s2);
		System.out.println("" + 7 + 7);
		double n = Math.pow(2, 32);
		System.out.println(n);
		int result = 2;
		for (int i = 0; i < 32; i++) {
			result *= 2;
//			System.out.println("i:" + i + " result:" + result);
//			System.out.print("i:"+i+'\t');
		}
//		System.out.println("result:" + result);
		int range = 1025;
		System.out.println(range);
		
		int rand;
		for (int i = 0; i < 5; i++) {
			rand=(int)(Math.random()*10);
//			System.out.println((int)(Math.random()*10));
			System.out.println(rand);
		}
	}

}
