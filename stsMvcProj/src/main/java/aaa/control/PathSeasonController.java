package aaa.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.MenuData;
import aaa.model.SeasonMain;
import aaa.service.MyProvider;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/path/season/{seas}")
public class PathSeasonController {
	
	@Resource
	MyProvider provider;
	
	@Resource
	SeasonMain sm;
	
	@ModelAttribute("hNav")
	Object headerNav() {
		ArrayList<MenuData> res = new ArrayList<>();
		res.add(new MenuData("spring", "봄"));
		res.add(new MenuData("summer", "여름"));
		res.add(new MenuData("autumn", "가을"));
		res.add(new MenuData("winter", "겨울"));
		return res;
	}
	
	
	@ModelAttribute("mainCt")
	Object mainContent(@PathVariable String seas) {
		
		return sm.getPicture(seas);
	}
	
	@ModelAttribute("fTxt")
	Object footerTxt() {
	
		return "바닥글입니다.";
	};

	@RequestMapping()
	String template() {
		return "path/template";
	}
	
//	내가 했던 거....
//	@RequestMapping
//	String template2(@PathVariable String seas,Model mm) {
//		System.out.println("template2() 진입: "+seas);
//		mm.addAttribute("seas",seas);
//		return "path/template";
//	}
	
}
