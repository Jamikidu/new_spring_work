package aaa.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
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
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource
	BoardMapper mapper;
	
	@Resource	//이걸로 전체에다가 page값을 줘볼까?
	MyPageData pageData;
	
	//게시판 리스트보기
	@RequestMapping("list")
	String list(Model mm, MyPageData pageData) {
		int allData = mapper.countList();	//내 보드에 게시글에 총갯수를 확인하기 위한 메서드 실행
		//System.out.println("allData:"+allData);
		
		//MyPageData pageData = new MyPageData(page);	//보내줄 페이지 데이터값 인스턴스 생성
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
	String detail(Model mm, @PathVariable int id, MyPageData pageData) {
		//System.out.println(mapper.detail(id));
//		System.out.println("수정 전 cnt:"+mapper.detail(id).getCnt());
		mapper.cntuuup(mapper.detail(id));	// 그냥 id통해서 가져온 디테일게시판에 cntuuup을 실행해주기만하면 sql이 실행되면서 cnt 알아서 상승
//		System.out.println("수정 후 cnt:"+mapper.detail(id).getCnt());
		
		mm.addAttribute("dto",mapper.detail(id));
		mm.addAttribute("myPageData",pageData);
		
		System.out.println("mm:"+mm);
		
		return "board/detail";
	}
	
	//게시판 작성
	@GetMapping("insert")
	String insert(BoardDTO dto,Model mm, MyPageData pageData) {
		//valid 써도됨!
		mm.addAttribute("myPageData",pageData);
		return "board/insertForm";
	}
	
	//+ 파일입력
	@PostMapping("insert")	//mmff값을 받아오고 파일이름 쓰기위해서 UploadData도 변수로 가져옴
	String insertReg(Model mm, BoardDTO dto, HttpServletRequest request, MyPageData pageData) {
		
		//System.out.println("mmff.getName(): "+mmff.getName());
		//System.out.println("mmff.getOriginalFilename(): "+mmff.getOriginalFilename());
		
		
		//System.out.println("dto.getMmff():"+dto.getMmff());

		//System.out.println("dto.getUpfile(): "+dto.getUpfile());	//값 보면 null로 비어있음
		
		dto.setId(mapper.maxId()+1);
		dto.setMsg("작성되었습니다.");
		dto.setGoUrl("list");
		//System.out.println(dto);
		
//		fileSave(ud.getMmff());	//파일을 bup폴더에 저장시킴 ud.getMmff()==>mmff.getOriginalFilename(); 얘는 중복처리 아직 안됨 단순 업로드
		fileSave(dto, request);	//파일을 폴더에 업로드 한 후에 실제로 업로드된 파일이름을 가지고 DB에 저장시키기 위해서	
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
	void fileSave(BoardDTO dto, HttpServletRequest request) {
		
		//파일 업로드 유무 확인
		if(dto.getMmff().isEmpty()) {
			
			return;
		}
		
		String path = request.getServletContext().getRealPath("bup"); //bup파일의 위치를 자동으로 잡아줌 서버에 올릴땐 이걸로 쓰면됨
		//System.out.println("path:"+path);
		//이건 로컬일때 파일위치
		path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
		
		
		int dot = dto.getMmff().getOriginalFilename().lastIndexOf(".");
		System.out.println("파일명에서.의 위치 => dot: "+dot);	//aaaaaa.jpg .의 위치 값을 반환 여기선 '6'
		String fDomain = dto.getMmff().getOriginalFilename().substring(0, dot);
		System.out.println("파일명에서 .앞의 글자 => fDomain: "+fDomain);	//0부터 dot전까지의 값만 출력 즉 확장자빼고 파일명 여기선 'aaaaa'
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
			dto.setMsg("작성되었습니다.");
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
	String deleteReg(BoardDTO dto, HttpServletRequest request) {
		
		dto.setMsg("삭제실패!");
		dto.setGoUrl("/board/delete/"+dto.getId());
		
		BoardDTO delDTO = mapper.detail(dto.getId());	//마찬가지로 삭제할 특정 dto 가져오기
		
		int cnt = mapper.delettt(dto);
		System.out.println("deleteReg:"+cnt);
		if(cnt>0) {
			
			fileDeleteModule(delDTO, request);	//위에 cnt로 db를 날렸으면 올라간 파일도 지워줘야함
			
			dto.setMsg("삭제되었습니다.");
			dto.setGoUrl("/board/list");
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
	String modifyReg(BoardDTO dto,  HttpServletRequest request) {
		
		dto.setMsg("수정실패!");
		dto.setGoUrl("/board/modify/"+dto.getId());
		int okChk = mapper.idPwChk(dto);	//id,pw를 확인하는 mapper
		System.out.println("modifyReg:"+okChk);
		
		if(okChk>0) {
			if(dto.getUpfile()==null) {	// 글 수정할때 올라갔던 파일을 다시 내리고
				fileSave(dto, request); // 파일이 없는 상태로 글을 저장할때
			}
			
			mapper.modifffy(dto);
			dto.setMsg("수정되었습니다.");
			dto.setGoUrl("/board/detail/"+dto.getId());
		}
		
		return "board/alert";
	}
	
	// 파일다운
	@GetMapping("download/{ff}")
	void download(@PathVariable String ff,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String path = request.getServletContext().getRealPath("bup"); //bup파일의 위치를 자동으로 잡아줌
		//System.out.println("path:"+path);
		path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
		
		//mvc에서 가져옴 깊은 해석 필요함
		try {
			FileInputStream fis = new FileInputStream(path+"\\"+ff);
			String encFName = URLEncoder.encode(ff,"utf-8");
			System.out.println(ff+"->"+encFName);
			response.setHeader("Content-Disposition", "attachment;filename="+encFName);
			
			ServletOutputStream sos = response.getOutputStream();
			
			byte [] buf = new byte[1024];
			
			//int cnt = 0;
			while(fis.available()>0) {  // 읽을 내용이 남아 있다면
				int len = fis.read(buf);  // 읽어서 -> buf 에 넣음
											//len : 넣은 byte 길이
				
				sos.write(buf, 0, len); //보낸다 : buf 내용을 0부터 len 만큼
				
				//cnt ++;
				//System.out.println(cnt+":"+len);  //파일보내는거 확인용
			}
			
			sos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 파일삭제
	@PostMapping("fileDelete")
	String fileDelete(BoardDTO dto, MyPageData pageData, HttpServletRequest request) {
		
		BoardDTO delDTO = mapper.detail(dto.getId()); // 삭제할 특정 dto를 가져오고
		dto.setMsg("파일 삭제 실패!!");  				// 일단 실패할 경우
		dto.setGoUrl("/board/modify/"+dto.getId());	// 다시 수정폼으로 돌아감
		
		int okDelete = mapper.fileDelete(dto);
		System.out.println("okDelete:"+okDelete);
		if(okDelete>0) {	//비밀번호가 일치한다면 일단 db에 파일이름삭제
			fileDeleteModule(delDTO, request);	//이건 업로드된 파일삭제
			dto.setMsg("파일 삭제 완료");
		}
		
		return "board/alert";
	}
	
	
	// 파일삭제모듈 메서드
	void fileDeleteModule(BoardDTO delDTO, HttpServletRequest request) { //그냥 dto 아닌 delDTO임
		if(delDTO.getUpfile()!=null) {  //업파일이 널이 아니라면
			String path = request.getServletContext().getRealPath("bup");
			path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\board\\bup";
			
			new File(path+"\\"+delDTO.getUpfile()).delete();
		}
	}
	
	
	
}
