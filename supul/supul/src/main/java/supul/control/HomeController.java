package supul.control;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import supul.service.ReserveMapper;

@Controller
public class HomeController {
	@Resource
	ReserveMapper mapper;
	@RequestMapping("/")
	//@ResponseBody
	String supulHome(Model mm) {
		System.out.println("SUPUL팀 홈");

        // 템플릿으로 현재 날짜를 전달
        mm.addAttribute("now", LocalDate.now());
		
		//return "homehome";
		return "home";  // views/home.html
	}	 
}
