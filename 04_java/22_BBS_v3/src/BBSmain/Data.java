package BBSmain;

import java.util.ArrayList;

public class Data {
	
	static public ArrayList<Post> posts;
	static void dateLoad() {
		posts = new ArrayList<Post>();
	}
	
	static public ArrayList<InfoIDPWjoin> idpw;
	static void dateLoad2() {
		idpw = new ArrayList<InfoIDPWjoin>();
	}
}
