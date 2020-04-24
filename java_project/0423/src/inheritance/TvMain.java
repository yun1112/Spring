package inheritance;

public class TvMain {

	public static void main(String[] args) {

		Tv tv1 = new Tv();
//		IpTv itv=(IpTv)tv1;
		
		
		CaptionTv cTv1 = new CaptionTv();
		Tv t = cTv1;//자동 형 변환

		Tv tv2 = new CaptionTv();
		
//		System.out.println(tv2.power);
		tv2.power();

		CaptionTv ctv2 = (CaptionTv) tv2;
		ctv2.caption();
//		((CaptionTv) tv2).caption();//강제 형변환

//		System.out.println(tv2.power);
//		System.out.println(tv2.text);
//		tv2.display();

		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
//		tv3.display();
//		tv4.display();

		Tv[] tvs = new Tv[4];
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();

		for (int i = 0; i < tvs.length; i++) {
			tvs[i].display();
			System.out.println("--------------------------------------------");
		}

	}

}
