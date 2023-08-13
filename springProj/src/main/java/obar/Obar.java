package obar;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Resource;

public class Obar {
	
	String name;
	BarTable[] table;

	public Obar() {
		// TODO Auto-generated constructor stub
	}
	
	public BarTable[] getTable() {  //메인에서 for문으로 불러오게끔 하기 위해서 설정
		return table;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTable(BarTable[] table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return name + " ==> 테이블 " + table.length + "개";
	}

}
