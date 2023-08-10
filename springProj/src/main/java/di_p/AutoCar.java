package di_p;

import java.util.List;

public class AutoCar {
	
	String name;
	AutoEngine eng;
	List<AutoWheel> whs;
	AutoHandle handle;
	
	public AutoCar() {
		System.out.println("AutoCar 기본생성자");
	}
	
	// 매개변수로 받을 때 에러가 발생되는 경우에는 작동되지 않는다
	public AutoCar(AutoEngine eng, List<AutoWheel> whs, AutoHandle hjkl) {
		super();
		this.eng = eng;
		this.whs = whs;
		this.handle = hjkl;
		System.out.println("AutoCar 생성자1");
	}
	
	
	// 생성자 실생 조건이 모두 충족할 경우 매개변수가 많은 생성자로 생성
	// 매개변수 할당 우선순위
	// 1.byName
	// 2.byType
	public AutoCar(AutoEngine eng, AutoHandle handle) {
		super();
		this.eng = eng;
		this.handle = handle;
		System.out.println("AutoCar 생성자2");
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setEng(AutoEngine eng) {
		this.eng = eng;
	}
	public void setWhqwer(List<AutoWheel> whs) {
		this.whs = whs;
	}
	public void setHandle(AutoHandle handle) {
		this.handle = handle;
	}
	

	
	@Override
	public String toString() {
		return "AutoCar [name=" + name + ", eng=" + eng + ", whs=" + whs + ", handle=" + handle + "]";
	}
	
	
}


class AutoEngine{
	String name;
	int power;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "AutoEngine [name=" + name + ", power=" + power + "]";
	}
	
}

class AutoWheel{
	String name;
	int size;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "AutoWheel [name=" + name + ", size=" + size + "]";
	}
	
}

class AutoHandle{
	String name, type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AutoHandle [name=" + name + ", type=" + type + "]";
	}
	
	
}
