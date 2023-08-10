package di_p;

public abstract class FoodShop {

	public Food order_food() {
		System.out.println("order_snack 실행");
		return new Food("군것질", "[까자]");
	}
	public Food order_bf() {
		System.out.println("order_bf 실행");
		return new Food("아침", "[삶은 계란]");
	}
	public Food order_lunch() {
		System.out.println("order_lunch 실행");
		return new Food("점심", "[백반]");
	}
	public Food order_dinner() {
		System.out.println("order_dinner 실행");
		return new Food("저녁", "[치킨]");
	}
	
	abstract public Food order_midnight();
}
