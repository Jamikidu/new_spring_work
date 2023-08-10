package di_p.bicycle;

public class Basket {

	String bname;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public String toString() {
		return " [바스켓=" + bname + "]";
	}
	
	
}
