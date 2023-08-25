package aaa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class EscapeData {
	
	String theme2 = "신비한 타임 트래블 어드벤처";
	String star2 = "★";
	String wname = "나의 빛,Special one 이.영.준";
	String title = "재밌었어요!";
	String content = "방이 친절하고 사장님이 재밌었어요!\n아\n점심\n뭐먹지\n...\n점메추";
	String [] headcount = {"1명","2명","3명","4명"};
	
	boolean clear = true;
	
	public Map<String, String> getThemes(){
		Map<String, String> res = new LinkedHashMap<>();
		
		res.put("theme1","신비한 타임 트래블 어드벤처");
		res.put("theme2","스팀펑크 미래 도시 탈출");
		res.put("theme3","마법사의 서릿발 밀실");
		res.put("theme4","에이리언 스페이스 스테이션 탈출");
		res.put("theme5","중세 마법학교 대모험");
		res.put("theme6","탐험가의 잃어버린 아티팩트");
		
		return res;
	};
	
	public Map<String, String> getStarRatings(){
		Map<String, String> res = new LinkedHashMap<>();
		
		res.put("star1","★");
		res.put("star2","★★");
		res.put("star3","★★★");
		res.put("star4","★★★★");
		res.put("star5","★★★★★");
		
		return res;
	};
	
//  해쉬태그 할 값 입력하기(#공포 #스릴러)
//	public List<MenuData> getHobbys(){
//		List<MenuData> res = new ArrayList<>();
//		
//		res.add(new MenuData("tag1","#호러,스릴러"));
//		res.add(new MenuData("tag2","#과학,SF"));
//		res.add(new MenuData("tag3","#판타지,마법"));
//		res.add(new MenuData("tag5","#추리,범죄"));
//		res.add(new MenuData("tag6","#탐험,탈출"));
//		res.add(new MenuData("tag7","#영화,드라마"));
//		
//		return res;
//	};
}
