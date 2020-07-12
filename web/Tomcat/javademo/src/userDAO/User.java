package userDAO;

public class User {
//	String first_name=request.getParameter("first_name");
//	String last_name=request.getParameter("last_name");
//	String num_points=request.getParameter("num_points");
	private String first_name;
	private String last_name;
	private int num_points;
	public User(String first_name, String last_name, int num_points) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.num_points = num_points;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", num_points=" + num_points + "]";
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getNum_points() {
		return num_points;
	}
	public void setNum_points(int num_points) {
		this.num_points = num_points;
	}
	
}
