package model;

public class LoginInfo {

	private String uid;
	private String pw;
	private String uname;
	private String email;
	private String photo;
	
	public LoginInfo(String uid, String pw, String uname, String email, String photo) {
		super();
		this.uid = uid;
		this.pw = pw;
		this.uname = uname;
		this.email = email;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", pw=" + pw + ", uname=" + uname + ", email=" + email + ", photo=" + photo
				+ "]";
	}
	public String getUid() {
		return uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
