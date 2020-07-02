package model;

public class LoginInfo {
	private String uid;// private type is necessary
	private String name;

	public LoginInfo() {// default constructor is necessary in beans classes
		this.uid="cool";
		this.name="son";
	}

	public LoginInfo(String uid, String name) {//
		super();
		this.uid = uid;
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
//		System.out.println(getName()+"\n"+getUid());
		
		return "id:"+getUid()+", name:"+getName();
	}

}
