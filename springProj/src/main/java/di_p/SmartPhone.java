package di_p;

import java.util.List;

public class SmartPhone {
	String name;
	Battery bat;
	Mscreen msc;
	List<Mcamera> mca;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBat(Battery bat) {
		this.bat = bat;
	}
	public void setMsc(Mscreen msc) {
		this.msc = msc;
	}
	public void setMca(List<Mcamera> mca) {
		this.mca = mca;
	}

	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", bat=" + bat + ", msc=" + msc + ", mca=" + mca + "]";
	}

	
}

class Battery{
	String name;
	int mAh;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getmAh() {
		return mAh;
	}
	public void setmAh(int mAh) {
		this.mAh = mAh;
	}
	
	@Override
	public String toString() {
		return "Battery [name=" + name + ", mAh=" + mAh + "]";
	}
	
}

class Mscreen{
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
		return "Mscreen [name=" + name + ", size=" + size + "]";
	}
	
}

class Mcamera{
	String name;
	int pixel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	@Override
	public String toString() {
		return "Mcamera [name=" + name + ", pixel=" + pixel + "]";
	}
	
}


