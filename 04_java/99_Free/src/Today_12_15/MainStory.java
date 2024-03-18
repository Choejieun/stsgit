package Today_12_15;

public class MainStory {

	void run(){
		//스토리 메인 진행
		
		if (Lan.OnOff == true) {
			System.out.println("본인이 선택한 언어가 아닐 경우 '2'을 눌러 뒤로가기를 하세요");
			System.out.println("--------------------------------------------");

		} else {
			System.out.println("If it's not your language, press '2' to go back");
			System.out.println("--------------------------------------------");

		}
		;
		
		loop_two: while (true) {
			if (Lan.OnOff == true) {
				System.out.println("당신의 마을은 이웃 집 간에 평야를 놓는 시골입니다.");
				System.out.println("그런데 최근 당신의 마을에 광산 개발을 위한 도시 사람들이 정착하였습니다..");
				System.out.println("이 마을에 광산이 생긴다면 좋은 일이지만, 광산과 관계가 있던 역사가 없는 곳입니다.");
				System.out.println("당신은 이 마을에서 나고 자란 사람인가요?");
				System.out.println("1 - 네 / 2 - 아니오");
			} else {
				System.out.println("Your village is a countryside with a plain between neighboring houses.");
				System.out.println("But recently, people from the city settled in your town for mining development.");
				System.out.println("It's great if there's a mine in this town, but it's a place where there's no history of having anything to do with it.");
				System.out.println("Are you born and raised in this town?");
				System.out.println("1 - yes / 2 - no");
			}
			;
			
			Sus.cmd = Sus.sc.next();
			switch (Sus.cmd) {
			case "1": 
				Lan.ancestry = true;
				if (Lan.OnOff == true) {
					System.out.println("당신은 이 시골에 새 바람이 불어오는 것을 경계하는 한편, 마음에 들어할 수도 있습니다.");
				} else {
					System.out.println("You might like it, while you're wary of a new wind blowing in this countryside.");
				};
			break;
			case "2": 
				Lan.ancestry = false;
				if (Lan.OnOff == true) {
					System.out.println("당신은 광산 개발에서 어떠한 냄새를 맡은 특정한 직종의 외지인일 수 있습니다.");
				} else {
					System.out.println("You may be an outsider who is interested in mining business.");
				};
			break;
			case "3":
			break loop_two;
			}}

	}
	
	static void run2() {
		if (Lan.OnOff == true) {
			System.out.println("이 마을의 광산 개발 위치는 마을 남쪽 음울한 호수 옆에 위치해 있습니다.");
			System.out.println("마을 사람들 중 젊은 사람들은 대부분 곡괭이질을 시작했습니다.");
			System.out.println("1 - 네 / 2 - 아니오");
		} else {
			System.out.println("The village's mining development location is located next to a gloomy lake south of the village.");
			System.out.println("Most of the young villagers started picking.");
			System.out.println("1 - yes / 2 - no");
		}
		;
	}
	
}
