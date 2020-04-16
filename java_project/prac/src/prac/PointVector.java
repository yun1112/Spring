package prac;

import java.util.Vector;

public class PointVector {

	public static void main(String[] args) {
		Vector<Point> v=new Vector<Point>();
		
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,-8));
		
		for (int i = 0; i < v.size(); i++) {
			Point p=v.get(i);//벡터 v에서 받아온 포인터타입 객체를 같은 자료형 p에저장
			System.out.println(p);
		}
	}

}

class Point{
	private int x,y; // x,y좌표를 나타내는 멤버변수 선언
	public Point(int x, int y) {//생성자
		this.x=x;//멤버변수 초기화
		this.y=y;
	}
	public String toString() {//메서드
		return "("+x+","+y+")";
	}
}
