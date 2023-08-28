package aaa.controll;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;
import aaa.model.MyPageData;
import aaa.model.PageData;
import aaa.model.UploadData;
import aaa.service.BoardMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource
	BoardMapper mapper;
	
	//게시판 리스트보기
	@RequestMapping("list")
	String list(Model mm, MyPageData mpd) {
		List<BoardDTO> data = mapper.list();
		
		MyPageData pageData = new MyPageData(mpd);
		
		
		//System.out.println(data);
		mm.addAttribute("mainData",data);
		mm.addAttribute("myPageData",pageData);
		return "board/list";
	}
	
	//게시판 상세보기
	@RequestMapping("detail/{id}")
	String detail(Model mm,@PathVariable int id,BoardDTO dto) {
		//System.out.println(mapper.detail(id));
//		System.out.println("수정 전 cnt:"+mapper.detail(id).getCnt());
		mapper.cntuuup(mapper.detail(id));	// 그냥 id통해서 가져온 디테일게시판에 cntuuup을 실행해주기만하면 sql이 실행되면서 cnt 알아서 상승
//		System.out.println("수정 후 cnt:"+mapper.detail(id).getCnt());
		mm.addAttribute("dto",mapper.detail(id));
		
		return "board/detail";
	}
	
	//게시판 작성
	@GetMapping("insert")
	String insert(BoardDTO dto) {
		//valid 써도됨!
		return "board/insertForm";
	}
	
	/* 원본
	@PostMapping("insert")
	String insertReg(BoardDTO dto, PageData pd) {
		
		mapper.insseerr(dto);
		pd.setMsg("작성되었습니다.");
		pd.setGoUrl("list");
		//System.out.println(dto);
		
		return "board/alert";
	}
	*/
	//파일입력시켜보기
	@PostMapping("insert")
	String insertReg(BoardDTO dto, PageData pd, MultipartFile mmff,UploadData ud,HttpServletRequest request) {
		
		System.out.println("mmff.getName(): "+mmff.getName());
		System.out.println("mmff.getOriginalFilename(): "+mmff.getOriginalFilename());
		mapper.insseerr(dto);
		pd.setMsg("작성되었습니다.");
		pd.setGoUrl("list");
		//System.out.println(dto);
		
//		fileSave(ud.getMmff());	//파일을 bup폴더에 저장시킴 ud.getMmff()==>mmff.getOriginalFilename(); 얘는 중복처리 아직 안됨 단순 업로드
		fileSave2(ud, request);
		
		return "board/alert";
	}
	
	//얘는 유효성 검사 없이 단순업로드 (파일명 중복되면 처리안됨)
	void fileSave(MultipartFile mmff) {
		String path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
		
		File ff = new File(path+"\\"+mmff.getOriginalFilename());
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(mmff.getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void fileSave2(UploadData ud, HttpServletRequest request) {
		ud.setMsg(null);
		
		//파일 업로드 유무 확인
		if(ud.getMmff().isEmpty()) {
			
			ud.setMsg("파일이 비었어욥");
			return;
		}
		
		String path = request.getServletContext().getRealPath("bup");
		System.out.println("path:"+path);
		path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
		
		
		int dot = ud.getMmff().getOriginalFilename().lastIndexOf(".");
		String fDomain = ud.getMmff().getOriginalFilename().substring(0, dot);
		String ext = ud.getMmff().getOriginalFilename().substring(dot);
		
		//이미지인지 확인
		if(!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
		
			ud.setMsg("이미지 파일이 아님");
			return;
		}
		
		ud.setMmffName(fDomain+ext); 
		File ff = new File(path+"\\"+ud.getMmffName());
		int cnt = 1;
		while(ff.exists()) {
			 
			ud.setMmffName(fDomain+"_"+cnt+ext);
			System.out.println("ud.getMmffName():"+ud.getMmffName());
			ff = new File(path+"\\"+ud.getMmffName());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(ud.getMmff().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	//게시판 글삭제
	@GetMapping("delete/{id}")
	String delete(@PathVariable int id) {
		
		return "board/deleteForm";
	}
	
	@PostMapping("delete/{id}")
	String deleteReg(BoardDTO dto, PageData pd) {
		
		pd.setMsg("삭제실패!");
		pd.setGoUrl("/board/delete/"+dto.getId());
		
		int cnt = mapper.delettt(dto);
		System.out.println("deleteReg:"+cnt);
		if(cnt>0) {
			pd.setMsg("삭제되었습니다.");
			pd.setGoUrl("/board/list");
		}
		
		return "board/alert";
	}
	
	//게시판 글수정하기
	@GetMapping("modify/{id}")
	String modify(Model mm, @PathVariable int id) {
		
		mm.addAttribute("dto",mapper.detail(id));	//detail dto 가져오기
		
		return "board/modifyForm";
	}
	
	@PostMapping("modify/{id}")
	String modifyReg(BoardDTO dto, PageData pd) {
		

		pd.setMsg("수정실패!");
		pd.setGoUrl("/board/modify/"+dto.getId());
		
		int cnt = mapper.modifffy(dto);
		System.out.println("modifyReg:"+cnt);
		if(cnt>0) {
			pd.setMsg("수정되었습니다.");
			pd.setGoUrl("/board/detail/"+dto.getId());
		}
		
		return "board/alert";
	}
	
	
//	void fileSave2(UploadData ud, HttpServletRequest request) {
//		ud.setMsg(null);
//		
//		//파일 업로드 유무 확인
//		if(ud.getFf2().isEmpty()) {
//			
//			ud.setMsg("파일이 비었어");
//			return;
//		}
//		
//		String path = request.getServletContext().getRealPath("up");
//		path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
//		
//		
//		int dot = ud.getFf2().getOriginalFilename().lastIndexOf(".");
//		String fDomain = ud.getFf2().getOriginalFilename().substring(0, dot);
//		String ext = ud.getFf2().getOriginalFilename().substring(dot);
//		
//		//이미지인지 확인
//		if(!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
//			
//			ud.setMsg("이미지 파일이 아님");
//			return;
//		}
//		
//		ud.setFf2Name(fDomain+ext); 
//		File ff = new File(path+"\\"+ud.getFf2Name());
//		int cnt = 1;
//		while(ff.exists()) {
//			 
//			ud.setFf2Name(fDomain+"_"+cnt+ext);
//			ff = new File(path+"\\"+ud.getFf2Name());
//			cnt++;
//		}
//		
//		try {
//			FileOutputStream fos = new FileOutputStream(ff);
//			
//			fos.write(ud.getFf2().getBytes());
//			
//			fos.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
