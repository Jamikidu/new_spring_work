package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.CenterData;
import aaa.model.PathData;

/* 
localhost/board/notice/list/1
localhost/board/fnq/list/3
localhost/board/qna/list/2

/board/{cate}/list/{pNo}

*/

@Controller
@RequestMapping("/path/{cate}")
public class PathController {

	@RequestMapping("aaa")
	String mmm1(@PathVariable String cate) {
		System.out.println("mmm1() 실행:"+cate);
		
		return "path/view";
	}
	
	@RequestMapping("{ser}")
	//String mmm2(@PathVariable String cate,@PathVariable String ser, @PathVariable PathData pd) {
	String mmm2(@PathVariable String cate,@PathVariable String ser) {
		//System.out.println("mmm2() 실행:"+cate+","+ser+","+pd);
		System.out.println("mmm2() 실행:"+cate+","+ser);
		
		return "path/view";
	}
	
	@RequestMapping("list/{pNo}")
	String mmm3(@PathVariable String cate, @PathVariable int pNo) {
		System.out.println("mmm3() 실행:"+cate+","+pNo);
		
		return "path/view";
	}
	
	@RequestMapping("{ser}/{pNo}")
	String mmm4(@PathVariable String cate, @PathVariable int pNo,@PathVariable String ser) {
		System.out.println("mmm4() 실행:"+cate+","+ser+","+pNo);
		
		return "path/view";
	}
	
	
	// 클래스의 멤버변수로 @PathVariable 받기
	@RequestMapping("center/{ser}/{pNo}")
	String mmm5(CenterData cd) {
	//@PathVariable String cate, @PathVariable int pNo,@PathVariable String ser
	//@RequestParam int age 
	// 위의 모든 매개변수를 CenterData cd 의 멤버변수로 받아서 처리
    
		System.out.println("mmm5() 실행:"+cd);
		
		return "path/center";
	}
}
