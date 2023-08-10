package di_p;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import teacher.di_p.Stud;

public class Class1 {
	//Student[] std;
	List<Student> stdList;
	//위 아래 차이를 잘 모르겠음
	/*
	List<Student> stdList;
	

	public List<Student> getStdList() {
		return stdList;
	}

	public void setStdList(List<Student> stdList) {
		this.stdList = stdList;
	}
	*/


	public void rankCalc() {
		
		for(int i=0; i<stdList.size(); i++) {
			int count = 1;
			for(int j=0; j<stdList.size(); j++) {
				if(stdList.get(i).getSum() < stdList.get(j).getSum()) {
					//int p =std[i].getRank()+1;
					count++;
					stdList.get(i).setRank(count);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Class1 [1반=>" + stdList + "]";
	}


	public List<Student> getStdList() {
		return stdList;
	}


	public void setStdList(List<Student> stdList) {
		this.stdList = stdList;
		rankCalc();
	}
	
	public TreeSet<Student> getSet(){
		return new TreeSet(stdList);
	}
	
}
