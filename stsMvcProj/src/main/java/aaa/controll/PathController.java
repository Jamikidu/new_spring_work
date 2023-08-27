package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.PathData;

/*
localhost/board/notice/list/1
localhost/board/fng/list/3
localhost/board/qna/list/2

/board/{cate}/list/{pNo}
 */


@Controller
@RequestMapping("/path/{cate}")
public class PathController {
	
	@RequestMapping("/aaa")
	String mmm1(@PathVariable String cate) {
		System.out.println("mmm1() 실행: "+cate);
		
		return "path/view";
	}
	
	@RequestMapping("{ser}")
	String mmm2(@PathVariable String cate,
			@PathVariable String ser){
//			@PathVariable PathData pd) {
//		System.out.println("mmm2() 실행: "+cate+","+ser+","+pd);
		System.out.println("mmm2() 실행: "+cate+","+ser);
		
		return "path/view";
	}
	
	@RequestMapping("list/{pNo}")
	String mmm3(@PathVariable String cate, @PathVariable int pNo) {
		System.out.println("mmm3() 실행: "+cate+","+pNo);
		
		return "path/view";
	}
	
	@RequestMapping("{ser}/{pNo}")
	String mmm4(@PathVariable String cate, @PathVariable int pNo,@PathVariable String ser) {
		System.out.println("mmm4() 실행: "+cate+","+ser+","+pNo);
		
		return "path/view";
	}
}
