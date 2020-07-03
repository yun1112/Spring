package phonebook_ver07_with_DAO;

public class PhoneClubInfo extends PhoneInfo implements PhoneInfoImpl {
	private int idx;
	private String member_name;
	private String member_nickname;
	private String club_name;
	private String phonenumber;
	private String addr;
	private String email;

	public PhoneClubInfo(int idx, String name, String phoneNumber, String addr, String email, int idx2,
			String member_name, String member_nickname, String club_name, String phonenumber2, String addr2,
			String email2) {
		super(idx, name, phoneNumber, addr, email);
		idx = idx2;
		this.member_name = member_name;
		this.member_nickname = member_nickname;
		this.club_name = club_name;
		phonenumber = phonenumber2;
		addr = addr2;
		email = email2;
	}

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

	/*	private int idx;
	private String member_name;
	private String member_nickname;
	private String club_name;
	private String phonenumber;
	private String addr;
	private String email;*/
	
	
	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("회원 이름:" + this.member_name);
		System.out.println("닉네임:" + this.member_nickname);
		System.out.println("동호회 이름:" + this.club_name);
		System.out.println("전화번호:" + this.phonenumber);
		System.out.println("주소:" + this.addr);
		System.out.println("이메일:" + this.email);
	}

	@Override
	public void showAllInfo() {
		super.showBasicInfo();
	}
}