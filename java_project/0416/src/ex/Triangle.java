package ex;

public class Triangle {
	int weight ,height;

	public  void setTriangle(int w, int h) {
		this.weight = w;
		this.height = h;
	}
	
	public  int calTriangle(int w, int h) {
		
		return w*h*1/2;
	}
}