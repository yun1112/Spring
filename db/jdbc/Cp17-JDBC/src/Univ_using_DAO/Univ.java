package Univ_using_DAO;

public class Univ {

	private int idx;
	private String student_name;
	private String phonenumber;
	private String addr;
	private String email;
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Univ(int idx, String student_name, String phonenumber, String addr, String email, String major,
			String grade) {
		super();
		this.idx = idx;
		this.student_name = student_name;
		this.phonenumber = phonenumber;
		this.addr = addr;
		this.email = email;
		this.major = major;
		this.grade = grade;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	private String major;
	private String grade;

	public Univ() {
	}

}