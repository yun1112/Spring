package self;
import java.util.Scanner;
public class aaaa {

		 public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  T t = new T();
		  int weight = sc.nextInt();
		  int height = sc.nextInt();
		  t.setTriangle(weight, height);
		  float result = t.calTriangle(weight, height);
		  System.out.println(result);
		 }
} 


	class T {
	 int weight ,height;

	 public  void setTriangle(int w, int h) {
	  this.weight = w;
	  this.height = h;
	 }
	 
	 public  float calTriangle(int w, int h) {
	  
	  return w*h/2.0f;
	 }
	}
	

