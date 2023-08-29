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
import org.springframework.web.bind.annotation.RequestParam;
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
	String list(Model mm, @RequestParam(value = "page", defaultValue = "1") int page) {
		int allData = mapper.countList();	//내 보드에 게시글에 총갯수를 확인하기 위한 메서드 실행
		//System.out.println("allData:"+allData);
		
		MyPageData pageData = new MyPageData(page);	//보내줄 페이지 데이터값 인스턴스 생성
		pageData.calc(allData);	//인스턴스의 멤버들이 계산되도록 계산메서드 호출
		
		//System.out.println(pageData.toString());
		
		List<BoardDTO> data = mapper.list(pageData); //data에 계산된 pageData에 해당하는 게시글만 가져와서 저장시킴!
		
		//System.out.println("data: "+data);
		mm.addAttribute("mainData",data);	//모델에 담아서 게시글 리스트를 mainData의 이름으로 보내줌
		mm.addAttribute("myPageData",pageData);	//myPageData에 pageData를 담아서 페이지 처릴하기위해 모델에 담아줌
		return "board/list";	//모델을 어디로 보내준다고? board/list로
	}
	
	//게시판 상세보기
	@RequestMapping("detail/{id}")
	String detail(Model mm,@PathVariable int id,BoardDTO dto) {
		//System.out.println(mapper.detail(id));
//		System.out.println("수정 전 cnt:"+mapper.detail(id).getCnt());
		mapper.cntuuup(mapper.detail(id));	// 그냥 id통해서 가져온 디테일게시판에 cntuuup을 실행해주기만하면 sql이 실행되면서 cnt 알아서 상승
//		System.out.println("수정 후 cnt:"+mapper.detail(id).getCnt());
		mm.addAttribute("dto",mapper.detail(id));
		System.out.println("mm:"+mm);
		
		return "board/detail";
	}
	
	//게시판 작성
	@GetMapping("insert")
	String insert(BoardDTO dto) {
		//valid 써도됨!
		return "board/insertForm";
	}
	
	//파일입력시켜보기
	@PostMapping("insert")	//mmff값을 받아오고 파일이름 쓰기위해서 UploadData도 변수로 가져옴
	String insertReg(BoardDTO dto, PageData pd, MultipartFile mmff) {
		
		//System.out.println("mmff.getName(): "+mmff.getName());
		//System.out.println("mmff.getOriginalFilename(): "+mmff.getOriginalFilename());
		

		//System.out.println("dto.getMmff():"+dto.getMmff());

		System.out.println("dto.getUpfile(): "+dto.getUpfile());	//값 보면 null로 비어있음

		pd.setMsg("작성되었습니다.");
		pd.setGoUrl("list");
		//System.out.println(dto);
		
//		fileSave(ud.getMmff());	//파일을 bup폴더에 저장시킴 ud.getMmff()==>mmff.getOriginalFilename(); 얘는 중복처리 아직 안됨 단순 업로드
		fileSave(dto, mmff, pd);	//파일을 폴더에 업로드 한 후에 실제로 업로드된 파일이름을 가지고 DB에 저장시키기 위해서	
		mapper.insseerr(dto);			//순서가 파일저장 먼저 하고 db에 저장
		return "board/alert";
	}
	
	//얘는 유효성 검사 없이 단순업로드 (파일명 중복되면 처리안됨)
	/*
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
	*/
	void fileSave(BoardDTO dto, MultipartFile mmff, PageData pd) {
		pd.setMsg(null);
		
		//파일 업로드 유무 확인
		if(dto.getMmff().isEmpty()) {
			
			pd.setMsg("파일이 비었어욥");
			return;
		}
		
//		String path = request.getServletContext().getRealPath("bup");
//		System.out.println("path:"+path);
		String path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
		
		
		int dot = dto.getMmff().getOriginalFilename().lastIndexOf(".");
		System.out.println("dot: "+dot);	//aaaaaa.jpg .의 위치 값을 반환 여기선 '6'
		String fDomain = dto.getMmff().getOriginalFilename().substring(0, dot);
		System.out.println("fDomain: "+fDomain);	//0부터 dot전까지의 값만 출력 즉 확장자빼고 파일명 여기선 'aaaaa'
		String ext = dto.getMmff().getOriginalFilename().substring(dot);
		System.out.println("ext: "+ext);	//dot을 포함한 값부터 출력 여기선 '.jpg'
		
		
		dto.setUpfile(fDomain+ext);
		File mf = new File(path+"\\"+dto.getUpfile());
		int cnt = 1;
		while(mf.exists()) {
			 
			dto.setUpfile(fDomain+"("+cnt+")"+ext);
			
			System.out.println("dto.getMmffName():"+dto.getUpfile());
			mf = new File(path+"\\"+dto.getUpfile());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(mf);
			pd.setMsg("작성되었습니다.");
			fos.write(dto.getMmff().getBytes());
			
			
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
