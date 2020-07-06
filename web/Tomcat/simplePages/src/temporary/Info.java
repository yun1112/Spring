package temporary;

public class Info {
	@Override
	public String toString() {
		return "Info [uid=" + uid + ", pw=" + pw + "]";
	}
	public Info(String uid, String pw) {
		this.uid = uid;
		this.pw = pw;
	}
	private String uid;
	private String pw;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
