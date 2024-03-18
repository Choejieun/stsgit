package lotto;

public class Lotto {
	public static void main(String[] args) {
		int p[] = {1,2,3,4,5,6};
		int r[] = new int[6];
		
//		for(int j = 0 ; j<6;  j++ ) {
//			r[j] =(int)(Math.random() * 45 + 1);
//			System.out.println((j+1)+"번째 - "+r[j]);}
//		
//		System.out.println("구분");
		System.out.println("1-"+r[0]);
		
		
		while (true) { // 2번째 자리 중복검사
			r[1] =(int)(Math.random() * 45 + 1);
			if (r[0] != r[1]) {
				System.out.println("2-"+r[1]);
				break;
			}}
		while (true) { // 3번째 자리 중복검사
			r[2] =(int)(Math.random() * 45 + 1);
			if (r[0] != r[2] && r[1] != r[2] ) {
				System.out.println("3-"+r[2]);
				break;
			}}
		while (true) { // 4번째 자리 중복검사
			r[3] =(int)(Math.random() * 45 + 1);
			if (r[0] != r[3] && r[1] != r[3] && r[2] != r[3] ) {
				System.out.println("4-"+r[3]);
				break;
			}}
		while (true) { // 5번째 자리 중복검사
			r[4] =(int)(Math.random() * 45 + 1);
			if (r[0] != r[4] && r[1] != r[4] && r[2] != r[4] && r[3] != r[4]  ) {
				System.out.println("5-"+r[4]);
				break;
			}}
		while (true) { // 6번째 자리 중복검사
			r[5] =(int)(Math.random() * 45 + 1);
			if (r[0] != r[5] && r[1] != r[5] && r[2] != r[5] && r[3] != r[5]&& r[4] != r[5] ) {
				System.out.println("6-"+r[5]);
				break;
			}}
		
		
		//맞춘 갯수 구하는 식
		int win = 0 ;
		for(int i = 0 ; i < 6 ; i++) {
			for(int o = 0 ; o< 6; o++) {
			if (p[i] == r[o]) {
				 win = win+1;}}}
		
		
		System.out.println("맞춘갯수"+win);
	}
}