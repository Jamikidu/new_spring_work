package aaa.controll;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.BoardDTO;
import aaa.model.BoardDTOs;
import aaa.service.MybatisMapper;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {

	@Resource
	MybatisMapper mapper;
	
	@RequestMapping("{ser}")
	@ResponseBody
	Object sqlGo(@PathVariable String ser) {
		
		Object res = null;
		//res = mapper.list();
		
		
		try {
//			Class cc = mapper.getClass();
//			Method mth = cc.getDeclaredMethod(ser);
//			res = mth.invoke(mapper);
//			
//			
//			System.out.println(cc);
//			System.out.println(mth);
			
			System.out.println("ser:"+ser);
			res = mapper.getClass().getDeclaredMethod(ser).invoke(mapper);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	
	@RequestMapping("listSch")
	@ResponseBody
	Object listSch(BoardDTO dto) {
		
		System.out.println("listSch() 진입");
		Object res = mapper.listSch(dto);
		
		return res;
	}
	
	@RequestMapping("cntSch")
	@ResponseBody
	Object cntSch(BoardDTO dto) {
		
		System.out.println("cntSch() 진입");
		Object res = mapper.cntSch(dto);
		
		return res;
	}
	
	@RequestMapping("inserList")
	@ResponseBody
	Object inserList() {
		
		System.out.println("inserList");
		
		ArrayList<BoardDTO> list = new ArrayList<>();
		list.add(new BoardDTO("제목1", "이름1", "1111", "내용1"));
		list.add(new BoardDTO("제목12", "이름16", "1111", "내용156"));
		list.add(new BoardDTO("제목13", "이름17", "1111", "내용1ㅎㄳㄷㄱㅎ"));
		list.add(new BoardDTO("제목14", "이름18", "1111", "내용1ㄱㄷㅎㄱㄷ"));
		list.add(new BoardDTO("제목15", "이름19", "1111", "내용1ㄱㄷㅎㄱㄷㅎㅎㄱㄷㅎㄱㄷ"));
		
		
		Object res = mapper.insseerrList(list);
		
		
		return res;
	}
	
	@RequestMapping("inserDTOs")
	@ResponseBody
	Object inserDTOs() {
		
		System.out.println("inserDTOs");
		
		Object res = mapper.insseerrDTOs(new BoardDTOs());
		
		
		return res;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	Object delete(int id, String pw) {
		
		System.out.println("delete");
		
		Object res = mapper.delettt(id,pw);
		
		
		return res;
	}
	
	@RequestMapping("modify")
	@ResponseBody
	Object modify(int id, String pw, String pname, String content, String title) {
		
		System.out.println("modify");
		
		Object res = mapper.modifffy(id,pw,pname,content,title);
		
		
		return res;
	}
	
	@RequestMapping("insert")
	@ResponseBody
	Object insert(BoardDTO dto) {
		
		System.out.println("insert");
		
		Object res = mapper.insseerr(dto);
		
		res += " , "+dto.getId();
		
		return res;
	}
	
	
}
