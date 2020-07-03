package Univ_using_DAO;

public class Com {

	private int idx;
	private String employee_name;
	private String phonenumber;
	private String address;
	private String email;
	private String com_name;
	private String dept;
	private String job;
	public int getIdx() {
		return idx;
	}

	

	public Com(int idx, String employee_name, String phonenumber, String address, String email, String com_name,
			String dept, String job) {
		super();
		this.idx = idx;
		this.employee_name = employee_name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
		this.com_name = com_name;
		this.dept = dept;
		this.job = job;
	}



	public String getEmployee_name() {
		return employee_name;
	}



	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCom_name() {
		return com_name;
	}



	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public Com() {
	}

}