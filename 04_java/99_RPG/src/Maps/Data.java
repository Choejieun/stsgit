package Maps;

public class Data {
	static public String Main_C_NAME;
	static public int Main_C_NO;
	static public int y = 0;
	static public int x = 0;
	static public int	xy;
	static public Boolean GOGO = true;
	static public Boolean VillageCome = true;
	
	static public void Datalode() {
		 GOGO = true;
		 VillageCome = true;
	}
	
	public int y_UP() {
		return y = y+1;
	}
	public int y_DW() {
		return y = y-1;
	}
	public int x_UP() {
		return x = x+1;
	}
	public int x_DW() {
		return x = x-1;
	}

}
