package guestbook.model;

public class Message {
	private String uname;
	private String pw;
	private String message;
	private int mid;//Message 객체: 사용자 정보 받을 때, DB에 정보 줄 때 사용
	public Message() {
	}
	public Message(String uname, String pw, String message, int mid) {
		super();
		this.uname = uname;
		this.pw = pw;
		this.message = message;
		this.mid = mid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Message [uname=" + uname + ", pw=" + pw + ", message=" + message + ", mid=" + mid + "]";
	}
	
}
