package anno_cloth;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

public class ClothsSet {
	String setName;
	Gear gear; // 특수장비
	Clothing clo; // 상,하의
	Shoes sho; // 신발
	
	public void setSetName(String setName) {
		this.setName = setName;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}

	public void setClo(Clothing clo) {
		this.clo = clo;
	}

	public void setSho(Shoes sho) {
		this.sho = sho;
	}

	public ClothsSet() {
		// TODO Auto-generated constructor stub
	}

	public ClothsSet(String setName, Gear gear, Clothing clo, Shoes sho) {
		super();
		this.setName = setName;
		this.gear = gear;
		this.clo = clo;
		this.sho = sho;
	}

	@Override
	public String toString() {
		return "ClothsSet [setName=" + setName + ", gear=" + gear + ", clo=" + clo + ", sho=" + sho + "]";
	}
	

}

class Gear {

	String name, kind, use;
	
	public Gear() {
		// TODO Auto-generated constructor stub
	}

	public Gear(String name, String kind, String use) {
		super();
		this.name = name;
		this.kind = kind;
		this.use = use;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUse(String use) {
		this.use = use;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Gear [name=" + name + ", kind=" + kind + ", use=" + use + "]";
	}
	
}

class Clothing {
	String name, top, bottoms;
	
	public Clothing() {
		// TODO Auto-generated constructor stub
	}
	
	public Clothing(String name, String top, String bottoms) {
		super();
		this.name = name;
		this.top = top;
		this.bottoms = bottoms;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public void setBottoms(String bottoms) {
		this.bottoms = bottoms;
	}

	@Override
	public String toString() {
		return "Clothing [name=" + name + ", top=" + top + ", bottoms=" + bottoms + "]";
	}

}

class Shoes {
	String name, use, size;

	public Shoes() {
		// TODO Auto-generated constructor stub
	}
	public Shoes(String name, String use) {
		super();
		this.name = name;
		this.use = use;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Shoes [name=" + name + ", use=" + use + ", size=" + size + "]";
	}

	

}