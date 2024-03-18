package LoginDB;

public class L_Dto {

	public String user_no;
	public String id;
	public String pw;
	public String userName;
	public String userTag;

	public L_Dto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public L_Dto(String no, String id, String pw, String userName, String userTag) {
		this.user_no = no;
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.userTag = userTag;
	}

	public L_Dto(String id, String pw, String userName) {
		this.id = id;
		this.pw = pw;
		this.userName = userName;
	}

}
