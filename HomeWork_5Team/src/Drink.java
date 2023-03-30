

public class Drink {
	private String drinkName;	//음료별 이름
	private int price;		//음료별 가격
	private int amount;		//음료별 수량
	
	//
	public Drink(String drinkName, int price, int amount) {
		this.drinkName = drinkName;
		this.price = price;
		this.amount = amount;
	}
	
	
	
	public String getDrinkName() {
		return drinkName;
	}

	//음료별 가격정보 호출을 위한 getter
	public int getPrice() {
		return price;
	}

	//음료별 수량 호출을 위한 getter
	public int getAmount() {
		return amount;
	}
	//음료 결제시 수량 차감
	public void decreaseAmount() {
		amount--;
	}
	
}
