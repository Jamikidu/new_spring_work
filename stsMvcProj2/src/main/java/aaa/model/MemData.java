package aaa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MemData {

	String pid = "asdf", pname="차은우", gender="여", email2="google.com";
	String content = "어머니는 짜장면이 싫다고 하셨어\n어머니는 짬뽕이 좋다고 하셨어\n야이야아\n12344567890\n"
			+"!@#$%^&*()\nqweqwe rqwrq wqrwqr wqrwr";
	
	boolean mil = true;
	
	String [] genders = {"남","여","it인"};
	
	public List<MenuData> getHobbys(){
		List<MenuData> res = new ArrayList<>();
		
		res.add(new MenuData("coding","코딩하기"));
		res.add(new MenuData("study","공부하기"));
		res.add(new MenuData("debug","디버깅"));
		res.add(new MenuData("programming","프로그램만들기"));
		
		return res;
	}
	
	public List<String> getMyHobbys(){
		List<String> res = new ArrayList<>();
		
		
		res.add("study");
		res.add("programming");
		res.add("project");
		
		return res;
	}
	
	
	public Map<String, String> getEmails(){
		Map<String, String> res = new LinkedHashMap<>();
		
		
		res.put("나베르", "naver.com");
		res.put("구그레", "google.com");
		res.put("....", "daum.net");
		res.put("줌", "zum.com");
		
		return res;
	}
	
	
	
}
