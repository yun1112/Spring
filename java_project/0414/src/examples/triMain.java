package examples;

import java.util.Scanner;

public class triMain {

	public static void main(String[] args) {
		Triangle tri=new Triangle();
		Scanner sc=new Scanner(System.in);
		int w=sc.nextInt();
		int h=sc.nextInt();

		tri.setTri(w, h);
		int res=tri.calTriangle(w, h);

		System.out.println(res);
		
	}

}
