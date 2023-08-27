package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Exam;

@Controller
@RequestMapping("request/exam")
public class ExamController {

	@GetMapping
	String examForm() {
		
		return "req/examForm";
	}
	
	@PostMapping
	String examReg(Exam exam) {
		System.out.println(exam);
		exam.rankCalc();
		return "req/examReg";
	}
}
