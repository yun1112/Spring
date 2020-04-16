package examples;

public class Triangle {
	int width,height;
	
	void setTri(int w,int h) {
		this.width=w;
		this.height=h;
	}
	int calTriangle(int w, int h) {
		int res;
		res=1/2*w*h;//삼각형의 넓이 계산
		System.out.println("넓이"+res);
		return res;
	}
}
