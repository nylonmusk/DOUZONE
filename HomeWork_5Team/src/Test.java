

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Machine can = new Machine();
		while(true) {
				System.out.println("****************");
				System.out.println("***캔 음료 자판기***");
				System.out.println("****************");
				System.out.println("금액을 투입해 주세요");
				System.out.println("(종료를 원하시면 '종료'를 입력해 주세요)");
				System.out.print("입력란 : ");
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine();
				//입력받은 금액정보 비교(금액 or 종료)
				int inputResult = can.inputMoney(input);
				// 종료 입력시
				if(inputResult == 0) {
					System.exit(0);
				}else {	// 금액 입력시
					//투입 금액 출력
					System.out.println("투입한 금액: " + input);
					while (true) {
						System.out.println("음료를 선택하세요.");
						//사용자가 선택한 음료 정보를 설정
						int choice = can.choice();
						Drink selectDrink = can.selectDrinkInfo(choice);
						if(selectDrink == null) {
							System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
							continue; // 다시 선택 부분으로 돌아가도록 함
						}else {
							if(selectDrink.getAmount() > 0) {
								can.notice();
								can.compare();
								break;
							}else {
								System.out.println("해당 상품은 품절입니다. 다른 상품을 골라주세요");
								continue;
							}
							
						}
					}					
				}
				
			}

		}
	
}
