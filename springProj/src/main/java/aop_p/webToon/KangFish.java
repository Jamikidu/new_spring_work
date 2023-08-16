package aop_p.webToon;

public class KangFish {

	String name;
	public int size;
	
	
	
	public KangFish(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}



	@Override
	public String toString() {
		return "KangFish [name=" + name + ", size=" + size + "]";
	}
	
	
}
