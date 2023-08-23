package aaa.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.AllStudMain;
import aaa.model.MenuData;
import aaa.model.SeasonMain;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/model")
public class ModelStudsController {
	
//	@Resource
//	SeasonMain sm;
	
	@Resource
	AllStudMain as;
	
//	@ModelAttribute("hNav")
//	Object headerNav() {
//		ArrayList<MenuData>res = new ArrayList<>();
//		res.add(new MenuData("spring", "봄"));
//		res.add(new MenuData("summer", "여름"));
//		res.add(new MenuData("autumn", "가을"));
//		res.add(new MenuData("winter", "겨울"));
//		return res;
//	}
	
	@ModelAttribute("hClas")
	Object headerClass() {
		ArrayList<MenuData>res = new ArrayList<>();
		res.add(new MenuData("1반", "1반"));
		res.add(new MenuData("2반", "2반"));
		res.add(new MenuData("3반", "3반"));
		res.add(new MenuData("4반", "4반"));
		return res;
	}
	
	@ModelAttribute("mainCt")
	Object mainContent(@RequestParam(value = "cn", defaultValue = "1반") String cn) {
		
		return as.getStudents(cn);
	}
	
	@ModelAttribute("fTxt")
	Object footerTxt() {
	
		return "바닥글입니다.";
	};

	@RequestMapping("Studs")
	String template() {
		return "model/exerStuds";
	}
}
