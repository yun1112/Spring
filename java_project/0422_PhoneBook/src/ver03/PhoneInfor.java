package ver03;

/*
Project : ver 0.30

諛곗뿴�쓣 �씠�슜�빐�꽌 �봽濡쒓렇�옩 �궗�슜�옄媛� �엯�젰�븯�뒗 �젙蹂닿� 理쒕� 100媛쒓퉴吏� �쑀吏��릺�룄濡� �봽濡쒓렇�옩�쓣 蹂�寃�. 

�븘�옒湲곕뒫 �궫�엯

���옣 : �씠由�, �쟾�솕踰덊샇, �깮�뀈�썡�씪 �젙蹂대�� ���긽�쑝濡� �븯�뒗 ���옣
寃��깋 : �씠由꾩쓣 湲곗��쑝濡� �뜲�씠�꽣瑜� 李얠븘�꽌 �빐�떦 �뜲�씠�꽣�쓽 �젙蹂대�� 異쒕젰
�궘�젣 : �씠由꾩쓣 湲곗��쑝濡� �뜲�씠�꽣瑜� 李얠븘�꽌 �빐�떦 �뜲�씠�꽣瑜� �궘�젣

�뜲�씠�꽣 �궘�젣 �썑 �궓�븘�엳�뒗 �뜲�씠�꽣 泥섎━�뒗 �뜲�씠�꽣瑜� 鍮� 怨듬��씠 �뾾�씠 �닚李⑥쟻�쑝濡�
�옱�젙由� 2踰덉씠 �궘�젣�릺�뿀�떎硫� 3踰� �씠�썑 �뜲�씠�꽣�뱾�쓽 二쇱냼 媛믪씠 -1 泥섎━�릺�뼱 �옱���옣.

�옉�꽦�옄: �썝�쑄寃�
�옉�꽦 �씪�옄: 2020/04/22
*/

import java.util.*;

public class PhoneInfor {
//	private: 蹂��닔�쓽 吏곸젒 李몄“瑜� 留됰뒗�떎, �젙蹂� ���땳
	private String name;// 移쒓뎄�쓽 �씠由�
	private String phoneNumber;// 移쒓뎄�쓽 �쟾�솕踰덊샇
	private String birthday;// 移쒓뎄�쓽 �깮�씪

	// 珥덇린�솕瑜� �쐞�븳 �깮�꽦�옄
	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneInfor(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this(name, phoneNumber, null);
		this(name, phoneNumber, "�엯�젰媛믪씠 �뾾�뒿�땲�떎");
	}
	
	//name �냽�꽦媛믨낵 �쟾�떖諛쏆� 臾몄옄�뿴�쓣 鍮꾧탳�빐�꽌 寃곌낵 諛섑솚z
boolean checkName(String name) {
	return this.name.equals(name);
}
	void showInfor() {
		System.out.println("�씠由�: " + this.name);
		System.out.println("�쟾�솕踰덊샇: " + this.phoneNumber);
//		if (this.birthday == null)// null媛� 珥덇린�솕�릺�뼱 �엳吏� �븡�쑝硫� �궗�슜 遺덇�
//			System.out.println("�깮�씪: �엯�젰媛믪씠 �뾾�뒿�땲�떎");
//		else
			System.out.println("�깮�씪:" + this.birthday);
	}

}
