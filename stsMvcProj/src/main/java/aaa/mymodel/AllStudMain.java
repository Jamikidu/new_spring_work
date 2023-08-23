package aaa.mymodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AllStudMain {

	HashMap<String, ArrayList<Studs>> data;	//키가 반이름이고 값은 학생객체인 해쉬맵 선언
	
	public AllStudMain() {	// 기본생성자 말고 테이블 밑에서 값 파라미터 받아서 data.put 새로 해줄수 있게 하면
							// 반에 학생 추가가 가능하지 않을까??
		data = new HashMap<>();
		
		//1,2반: 먼저 출력 확인용으로 고정데이터 값이 들어있는 반 2개 생성
		ArrayList<Studs> c1Students = new ArrayList<>();
		c1Students.add(new Studs("일민수", 10, 20, 30));
		c1Students.add(new Studs("이민수", 11, 21, 34));
		c1Students.add(new Studs("삼민수", 12, 22, 35));
		c1Students.add(new Studs("사민수", 13, 23, 36));
		c1Students.add(new Studs("오민수", 14, 24, 37));
		 data.put("1반", c1Students);
		 
		ArrayList<Studs> c2Students = new ArrayList<>();
		c2Students.add(new Studs("일소미", 21, 32, 44));
		c2Students.add(new Studs("이소미", 22, 33, 45));
		c2Students.add(new Studs("삼소미", 23, 34, 46));
		c2Students.add(new Studs("사소미", 24, 35, 47));
		c2Students.add(new Studs("오소미", 25, 36, 48));
		data.put("2반", c2Students);
		
		//3반: 5명의 학생, 랜덤한 성적, 랜덤값 다르게 하기위해 for문으로 생성
		ArrayList<Studs> c3Students = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			int ran1 = (int)(Math.random()*50)+1;
			int ran2 = (int)(Math.random()*50)+1;
			int ran3 = (int)(Math.random()*50)+1;
			c3Students.add(new Studs("3반학생 "+i, ran1, ran2, ran3));
		}
		data.put("3반", c3Students);
		
		//4반: 학생수도 랜덤(6~10명)
		int ranS = (int)(Math.random()*5)+6;
		ArrayList<Studs> c4Students = new ArrayList<>();
		for(int i=1;i<=ranS;i++) {
			int ran1 = (int)(Math.random()*50)+1;
			int ran2 = (int)(Math.random()*50)+1;
			int ran3 = (int)(Math.random()*50)+1;
			c4Students.add(new Studs("4반학생 "+i+"번", ran1, ran2, ran3));
		}
		data.put("4반", c4Students);
		
	}
	

	public ArrayList<Studs> getStudents(String clasName) {
		return data.get(clasName);
	}
}