package Today_12_15;

import java.util.ArrayList;

public class Lan {

	static public boolean OnOff = false;

	String name;
	String Lang;
	boolean L_a = false;

	public Lan(String Lang) {
		ArrayList<String> xx = new ArrayList<String>();
		xx.add(this.Lang);

		boolean L_a = xx.contains(this.Lang);
		System.out.println(L_a);
	}

//메인스토리 이후 진행
	static public boolean ancestry = true;
}
