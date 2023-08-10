package teacher.di_p;

import java.util.List;
import java.util.TreeSet;

public class Exam {

	List<Stud> studs;

	public List<Stud> getStuds() {
		return studs;
	}

	public void setStuds(List<Stud> studs) {
		this.studs = studs;
		
		for (Stud st : studs) {
			st.rankCalc(studs);
		}
	}
	
	public TreeSet<Stud> getSet(){
		return new TreeSet(studs);
	}
	
	
}
