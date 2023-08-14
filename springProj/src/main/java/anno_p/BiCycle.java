package anno_p;

public class BiCycle {
	String name;
	BiHandle hd;
	BiWheel wh;
	public BiCycle(String name, BiHandle hd, BiWheel wh) {
		super();
		this.name = name;
		this.hd = hd;
		this.wh = wh;
	}
	@Override
	public String toString() {
		return "BiCycle [name=" + name + ", hd=" + hd + ", wh=" + wh + "]";
	}
	
}

class BiHandle{
	String name, type;

	public BiHandle(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "BiHandle [name=" + name + ", type=" + type + "]";
	}
	
	
}

class BiWheel{
	String name;
	int size;
	
	public BiWheel(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "BiWheel [name=" + name + ", size=" + size + "]";
	}
	
}

