package aaa.controll;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.MenuData;
import aaa.model.SeasonMain;
import aaa.mymodel.AllStudMain;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("model")
public class ModelStudsController {
	
	
	@Resource
	AllStudMain as;
	
	// MenuData 공유....
	@ModelAttribute("hClas")	// 전송할 모델명 특정: hCals
	Object headerClas() {
		ArrayList<MenuData>res = new ArrayList<>();
		res.add(new MenuData("1반", "1반"));
		res.add(new MenuData("2반", "2반"));
		res.add(new MenuData("3반", "3반"));
		res.add(new MenuData("4반", "4반"));
		return res;
	}
	
	@ModelAttribute("mainCt")	// cn명에 맞는 반의 학생데이터 값 가져오기 디폴트값은 1반
	Object mainContent(@RequestParam(value = "cn", defaultValue = "1반") String cn) {
		
		return as.getStudents(cn);
	}
	
	@ModelAttribute("fTxt")
	Object footerTxt() {
	
		return "바닥글입니다.";
	};

	@RequestMapping("Studs")	// 주소창에는 /model/Studs 이지만
	String template() {
		return "model/exerStuds";	//불러오는 페이지 값은 exerStuds.html
	}
}
