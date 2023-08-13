package obar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BarTable {
	String name;
	int totalprice = 0;
	
	@Autowired
	@Qualifier("alc4")  //Autowired를 통해서 술을 바꿀 수 있게끔 설계
	List<Alcohol> alc;  //술이 여러종류가 올 수 있으므로 리스트로 생성

	@Autowired
	@Qualifier("cui4")  //Autowired를 통해서 안주를 바꿀 수 있게끔 설계
	List<Cuisine> cui;  //안주도 여러종류가 올 수 있으므로 리스트로 생성
	
	public BarTable() {
		// TODO Auto-generated constructor stub
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Alcohol> getAlc() {
		return alc;
	}

	public List<Cuisine> getCui() {
		return cui;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public void setAlc(List<Alcohol> alc) {
		this.alc = alc;
	}
	public void setCui(List<Cuisine> cui) {
		this.cui = cui;
	}

	@Override
	public String toString() {
		return name + ", 테이블총금액=" + totalprice + "원\n술 ==> " + alc + "\n안주 ==>" + cui;
	}

}

class Alcohol{
	String type, name;
	int aprice;  //개당가격
	int anum;	 //수량
	public int atot = 0;  //술총액
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAprice() {
		return aprice;
	}


	public void setAprice(int aprice) {
		this.aprice = aprice;
		atot =  aprice * anum;
	}

	public int getAnum() {
		return anum;
	}


	public void setAnum(int anum) {
		this.anum = anum;
	}


	@Override
	public String toString() {
		return "종류=" + type + ", 술이름=" + name + ", 개당가격=" + aprice + "원, 수량=" + anum + "병, 술총액=" + atot +"원";
	}
	
}

class Cuisine{
	String name;
	int cprice;  //개당가격
	int cnum;	 //수량
	public int ctot = 0;  //안주총액

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCprice() {
		return cprice;
	}

	public void setCprice(int cprice) {
		this.cprice = cprice;
		ctot = cprice * cnum;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 개당가격=" + cprice + "원, 수량=" + cnum + "개, 안주총액=" + ctot + "원";
	}
	
}