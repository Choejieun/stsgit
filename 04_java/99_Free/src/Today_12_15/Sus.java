package Today_12_15;

import java.util.Scanner;

public class Sus {
	static	Scanner sc = new Scanner(System.in);
	static	String cmd;

	void run() {

			//
//					ArrayList<String> xx = new ArrayList<String>();
//					xx.add("한국어");
//					xx.set(0, "영어");
//					boolean L_a = xx.contains("한국어");

					System.out.println("--------------------------------------------");

					// 구분

					loop_admin: while (true) {
						if (Lan.OnOff == true) {
							System.out.println("시스템 실행");
							System.out.println("--------------------------------------------");
							System.out.println("새로운 환경 실행하기");
							System.out.println("--------------------------------------------");
							System.out.println(" 1.키기  / 2. 끄기 ");
							System.out.println("--------------------------------------------");
							System.out.println("--------------------------------------------");
						} else {
							System.out.println("System Operations");
							System.out.println("--------------------------------------------");
							System.out.println("Running a New Environment");
							System.out.println("--------------------------------------------");
							System.out.println(" 1. on / 2. off  ");
							System.out.println("--------------------------------------------");
							System.out.println("--------------------------------------------");
						}
						;
						cmd = sc.next();

						switch (cmd) {
						case "1":
							System.out.println("--------------------------------------------");

							System.out.println("--------------------------------------------");
							System.out.println(" :: ");

							loop_start: while (true) {
								if (Lan.OnOff == true) {
									System.out.println("--------------------------------------------");
									System.out.println("명령어를 실행해주세요.");
									System.out.println("--------------------------------------------");
									System.out.println("기본 언어 한국어");
									System.out.println(" 1. 언어 / 2. 실행 / 3. 종료 ");
									System.out.println("--------------------------------------------");
									System.out.println("--------------------------------------------");
								} else {
									System.out.println("--------------------------------------------");
									System.out.println("Request to execute a command");
									System.out.println("--------------------------------------------");
									System.out.println("Initial value English");
									System.out.println(" 1. Language / 2. Run / 3. End ");
									System.out.println("--------------------------------------------");
									System.out.println("--------------------------------------------");
								}
								;

								cmd = sc.next();
								switch (cmd) {
								case "1":
									if (Lan.OnOff == true) {
										System.out.println("언어");
									} else {
										System.out.println("Language");
									}
									;

									loop_Lang: while (true) {
										System.out.println("--------------------------------------------");
										System.out.println(" 1. English / 2. 한국어 / 3. End ");
										System.out.println("--------------------------------------------");
										cmd = sc.next();

										switch (cmd) {
										case "1":
											System.out.println("--------------------------------------------");
											System.out.println(" English ");
											System.out.println("--------------------------------------------");
//									xx.set(0, "영어");
//									L_a = xx.contains("한국어");
											Lan.OnOff = false;
											if (Lan.OnOff == true) {
												System.out.println("기본 언어 한국어");
											} else {
												System.out.println("Initial value English");
											}
											;

											break;

										case "2":
											System.out.println("--------------------------------------------");
											System.out.println(" 한국어 ");
											System.out.println("--------------------------------------------");

//									xx.set(0, "한국어");
//									L_a = xx.contains("한국어");
											Lan.OnOff = true;
											if (Lan.OnOff == true) {
												System.out.println("기본 언어 한국어");
											} else {
												System.out.println("Initial value English");
											}
											;

											break;

										case "3":
											break loop_Lang;
										}
									}
									break;

								case "2":
									
									
									MainStory m = new MainStory();
									m.run();
									
									break;
								case "3":
									break loop_start;
								}
							} // 종결
							break; // admin "1";
						case "2":
							break loop_admin;
						}
					} // lopp_admin 종결

					// 반복문 탈출
					if (Lan.OnOff == true) {
						System.out.println("--------------------------------------------");
						System.out.println("종료");
						System.out.println("--------------------------------------------");
					} else {
						System.out.println("--------------------------------------------");
						System.out.println("close");
						System.out.println("--------------------------------------------");
					}
					;

				}
	
	}
	
