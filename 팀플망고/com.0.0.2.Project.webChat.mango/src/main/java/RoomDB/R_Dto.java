package RoomDB;

public class R_Dto {
	
	String userNo;
	String roomNo;
	String roomName;
	String bossNo;
	String userMax;
	public R_Dto(String userNo, String roomNo, String roomName, String bossNo, String userMax) {
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.bossNo = bossNo;
		this.userMax = userMax;
	}
	public R_Dto(String userNo, String roomNo) {
		this.userNo = userNo;
		this.roomNo = roomNo;

	}

}
