package teacher.di_p;

public class BiCycle {

	String name;
	Wheel wh1, wh2, wh3;
	Handle hd;
	Basket bk;
	
	public void setHd(Handle hd) {
		this.hd = hd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWh1(Wheel wh1) {
		this.wh1 = wh1;
	}
	public void setWh2(Wheel wh2) {
		this.wh2 = wh2;
	}
	public void setWh3(Wheel wh3) {
		this.wh3 = wh3;
	}
	public void setBk(Basket bk) {
		this.bk = bk;
	}
	@Override
	public String toString() {
		return "BiCycle [name=" + name + ", hd=" + hd + ", bk=" + bk + ", wh1=" + wh1 + ", wh2=" + wh2 + ", wh3=" + wh3
				+ "]";
	}
	
}
