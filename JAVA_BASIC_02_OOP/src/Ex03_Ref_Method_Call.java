import kr.or.kosa.Tv;

public class Ex03_Ref_Method_Call {

	public static void main(String[] args) {
		//Tv 만드세요 (메모리에 올리세요) >> heap
		Tv lgtv = new Tv();
		lgtv.brandname = "LG";
		lgtv.tvInfo();
		
		lgtv.ch_Up();
		lgtv.ch_Up();
		lgtv.ch_Up();
		lgtv.tvInfo();
		
		lgtv.ch_Down();
		lgtv.tvInfo();
		
		Tv sstv = new Tv();
		sstv.brandname = "SS";
		
		Tv ktv = sstv; //같은 주소 (동거)
		
	}

}
