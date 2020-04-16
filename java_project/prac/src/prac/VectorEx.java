package prac;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.add("Hello");
		v.add(new Integer(4));
		v.add(new Double(3.14));
		System.out.println("벡터 내의 요소 객체 수: "+v.size());
		System.out.println("벡터의 현재 용량: "+v.capacity());//용량 초과할 때마다 용량 10씩 자동증가함
		
		for (int i = 0; i < v.size(); i++) {
			Object obj=v.get(i);
			if(obj instanceof String) {//가져온 객체가 문자열 인스턴스일 경우
				String str=(String)obj;//가져온 객체를 문자형으로 형변환
				System.out.println(str);
			}
			
			else if(obj instanceof Integer) {//가져온 객체가 정수형 인스턴스일 경우
				Integer x=(Integer)obj;//가져온 객체를 정수형으로 형변환
				int n=x.intValue();//정수형 객체에서 정수값 가져옴
				System.out.println(n);
			}
			else if(obj instanceof Double) {//가져운 객체가 실수형 인스턴스일 경우
				Double y=(Double)obj;//가져온 객체를 실수형으로 형변환
				double d=y.doubleValue();//실수형 객체에서 실수값 가져옴
				System.out.println(d);
			}
		}
	}

}
