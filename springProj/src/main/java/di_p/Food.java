package di_p;

public class Food {

	String foodtype;
	String menu;
	
	public Food(String foodtype, String menu) {
		super();
		this.foodtype = foodtype;
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "식단표의 "+ foodtype + "메뉴는 " + menu + " 입니다.";
	}
	
	
}
