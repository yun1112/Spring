package boxing_and_unboxing;

public class AutoBoxingUnboxing {
	public static void main(String[] args) {
//	Integer iValue=new Integer(10);
		Integer iValue = 10; // auto boxing 일어남
//	Double dValue=new Double(3.14);
		Double dValue = 3.14;
		System.out.println(iValue.toString());
		System.out.println(dValue.toString());
		
		int num1=iValue;//auto unboixing 일어남
		double num2=dValue;
		System.out.println(num1);
		System.out.println(num2);
	}
}
