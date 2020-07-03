package Univ_using_DAO;

public class Club {
	private int idx;
	private String member_name;
	private String member_nickname;
	private String club_name;
	private String phonenumber;
	public Club(int idx, String member_name, String member_nickname, String club_name, String phonenumber, String addr,
			String email) {
		super();
		this.idx = idx;
		this.member_name = member_name;
		this.member_nickname = member_nickname;
		this.club_name = club_name;
		this.phonenumber = phonenumber;
		this.addr = addr;
		this.email = email;
	}
	private String addr;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
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
	private String email;
}