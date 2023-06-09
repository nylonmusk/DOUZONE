

import java.util.Scanner;

public class Machine {
	//고유정보
	private String model;	//모델
	private String company;	//제조사
	private String color;	//색상
	
	//부품정보
	private Drink cola;	
	private Drink soda;	
	private Drink energy;
	private Drink pocari;
	
	//상태정보
	private int inputMoney;	//투입 금액
	private int choice;	//음료 선택 번호
	private Drink selectDrink;	//선택된 음료 정보
	
	

	//자판기 객체 생성시 고유정보 및 각 음료별 정보 초기화
	public Machine() {
		this.model = "캔음료 자판기";
		this.company = "더존자판기";
		this.color = "red";
		this.cola = new Drink("콜라", 1200, 15);
		this.soda = new Drink("사이다", 1000, 10);
		this.energy = new Drink("에너지드링크", 1500, 12);
		this.pocari = new Drink("포카리", 900, 5);
		}
	

	
	//금액 입력 받기
	public int inputMoney(String input) {
		if(input.equals("종료")) {
			return 0;
		}else {
			this.inputMoney = Integer.parseInt(input);
			return 1;			
		}
	}
	
	//음료 선택
	public int choice() {
		System.out.println("==========================");
        System.out.println("1. 콜라: " + cola.getPrice() + "원");
        System.out.println("2. 사이다: " + soda.getPrice() + "원");
        System.out.println("3. 에너지드링크: " + energy.getPrice() + "원");
        System.out.println("4. 포카리: " + pocari.getPrice() + "원");
        System.out.println("==========================");
        System.out.print("음료 선택 : ");
        Scanner sc = new Scanner(System.in);
        choice = Integer.parseInt(sc.nextLine());
        System.out.println("==========================");
        return choice;
	}
	
	//선택된 음료 정보 담기
	public Drink selectDrinkInfo(int choice) {
	        switch (choice) {
		        case 1:
		        	selectDrink = cola;
		            break;
		        case 2:
		        	selectDrink = soda;
		            break;
		        case 3:
		        	selectDrink = energy;
		            break;
		        case 4:
		        	selectDrink = pocari;
		            break;
		        default:
		            System.out.println("잘못된 입력입니다. 다시 선택해 주세요");
		            selectDrink = null;
		            break;
	        }
        return selectDrink;
	}
	
	//진행상황 알려주기
	public void notice() {
		System.out.println("==========================");
		System.out.println("선택하신 음료는 " + selectDrink.getDrinkName() + "입니다.");
		System.out.println("선택하신 음료의 재고 수량은 " + selectDrink.getAmount() + "입니다.");		
		System.out.println("가격은 " + selectDrink.getPrice() + "원입니다.");
		System.out.println("현재 투입된 금액은 " + inputMoney + "원입니다.");
		System.out.println("==========================");
	}
	

	//투입 금액과 음료 가격 비교
	public void compare() {
		if(inputMoney >= selectDrink.getPrice()) {
			buyDrink();
		}else {
			confirm();
		}
	}
	
	//음료 구매
	public void buyDrink() {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매하시겠습니까? (Y/N)");
		String answer = sc.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			selectDrink.decreaseAmount();
			int change = inputMoney - selectDrink.getPrice();
			System.out.println(selectDrink.getDrinkName() + " 음료를 구매하셨습니다.");
			System.out.println("거스름돈 " + change + "원을 반환합니다.");
			System.out.println("저희 자판기를 이용해 주셔서 감사합니다.");
			System.out.println("=============================");
		} else if (answer.equals("N") || answer.equals("n")) {
			returnInputMoney();
			System.out.println("저희 자판기를 이용해 주셔서 감사합니다.");
			System.out.println("=============================");
		} else {
			System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			buyDrink();
		}
	}
	//투입 금액 반환
	public void returnInputMoney() {
		System.out.println("투입하신 금액 " + inputMoney + "원을 반환합니다.");
		inputMoney = 0;
		selectDrink = null;
		choice = 0;
	}
	
	//부족 금액 투입 여부
	public void confirm() {
		int shortageMoney = selectDrink.getPrice() - inputMoney;
		System.out.println(shortageMoney + "원이 부족합니다.");
		System.out.println("1. 추가 투입 / 2. 취소");
		Scanner sc = new Scanner(System.in);
		int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            System.out.println("추가로 투입할 금액을 입력하세요:");
            int additionalMoney = Integer.parseInt(sc.nextLine());
            inputMoney += additionalMoney;
            compare();
        } else if (choice == 2) {
            System.out.println(inputMoney + "원이 반환됩니다.");
            inputMoney = 0;
            selectDrink = null;
            System.out.println("저희 자판기를 이용해 주셔서 감사합니다.");
            System.out.println("=============================");
        } else {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            confirm();
        }
	}
	
	
	
	
}
