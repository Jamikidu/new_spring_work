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

import aaa.model.BoardDTO;
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

	@RequestMapping("list/{page}")
	String list(Model mm,  BoardDTO dto) {
		
		
		dto.calc(mapper.listCnt());
		System.out.println(dto);
		List<BoardDTO>data = mapper.list(dto);
		
		mm.addAttribute("mainData", data);
		return "board/list";
	}
	
	
	@RequestMapping("detail/{page}/{id}")
	String detail(Model mm, @PathVariable int page, @PathVariable int id) {
		mapper.addCount(id);
		BoardDTO dto = mapper.detail(id);
		dto.setPage(page);
		mm.addAttribute("dto", dto);
		return "board/detail";
	}
	
	
	@GetMapping("insert/{page}")
	String insert(BoardDTO dto) {

		return "board/insertForm";
	}
	
	@PostMapping("insert/{page}")
	String insertReg(BoardDTO dto, HttpServletRequest request) {
		dto.setId(mapper.maxId()+1);
		fileSave(dto,request);
		mapper.insseerr(dto);
		dto.setMsg("작성되었습니다.");
		dto.setGoUrl("/board/list/1");
		//System.out.println(dto);

		return "board/alert";
	}
	
	
	@GetMapping("delete/{page}/{id}")
	String delete(BoardDTO dto) {
		
		return "board/deleteForm";
	}
	
	@PostMapping("delete/{page}/{id}")
	String deleteReg(BoardDTO dto, HttpServletRequest request) {
		

		dto.setMsg("삭제실패");
		dto.setGoUrl("/board/delete/"+dto.getPage()+"/"+dto.getId());
		
		BoardDTO delDTO = mapper.detail(dto.getId());
		
		int cnt = mapper.delettt(dto);
		System.out.println("deleteReg:"+cnt);
		if(cnt>0) {
			
			
			fileDeleteModule(delDTO, request);
			
			dto.setMsg("삭제되었습니다.");
			dto.setGoUrl("/board/list/1");
		}

		return "board/alert";
	}
	
	@GetMapping("modify/{page}/{id}")
	String modify(Model mm, @PathVariable int page, @PathVariable int id) {
		
		BoardDTO dto = mapper.detail(id);
		dto.setPage(page);
		mm.addAttribute("dto", dto);
		
		return "board/modifyForm";
	}
	
	
	@PostMapping("modify/{page}/{id}")
	String modifyReg(BoardDTO dto,  HttpServletRequest request) {
		

		dto.setMsg("수정실패");
		dto.setGoUrl("/board/modify/"+dto.getPage()+"/"+dto.getId());
		int cnt = mapper.idPwChk(dto);
		
		System.out.println("modifyReg:"+cnt);
		if(cnt>0) {
			if(dto.getUpfile()==null) {
				fileSave(dto,request);
			}
			mapper.modifffy(dto);
			dto.setMsg("수정되었습니다.");
			dto.setGoUrl("/board/detail/"+dto.getPage()+"/"+dto.getId());
		}

		return "board/alert";
	}
	
	
	
	
	@PostMapping("fileDelete")
	String fileDelete(BoardDTO dto,  HttpServletRequest request) {
		
		BoardDTO delDTO = mapper.detail(dto.getId());
		dto.setMsg("파일 삭제실패");
		dto.setGoUrl("/board/modify/"+dto.getPage()+"/"+dto.getId());
		
		int cnt = mapper.fileDelete(dto);
		System.out.println("modifyReg:"+cnt);
		if(cnt>0) {
			fileDeleteModule(delDTO, request);
			dto.setMsg("파일 삭제되었습니다.");
		}

		return "board/alert";
	}
	
	
	void fileSave(BoardDTO dto, HttpServletRequest request) {
		
		//파일 업로드 유무 확인
		if(dto.getMmff().isEmpty()) {
			
			return;
		}
		
		String path = request.getServletContext().getRealPath("up");
		path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		int dot = dto.getMmff().getOriginalFilename().lastIndexOf(".");
		String fDomain = dto.getMmff().getOriginalFilename().substring(0, dot);
		String ext = dto.getMmff().getOriginalFilename().substring(dot);
		
		
		
		dto.setUpfile(fDomain+ext); 
		File ff = new File(path+"\\"+dto.getUpfile());
		int cnt = 1;
		while(ff.exists()) {
			 
			dto.setUpfile(fDomain+"_"+cnt+ext);
			ff = new File(path+"\\"+dto.getUpfile());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(dto.getMmff().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@GetMapping("download/{ff}")
	void download(@PathVariable String ff, 
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String path = request.getServletContext().getRealPath("up");
		path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		try {
			FileInputStream fis = new FileInputStream(path+"\\"+ff);
			String encFName = URLEncoder.encode(ff,"utf-8");
			System.out.println(ff+"->"+encFName);
			response.setHeader("Content-Disposition", "attachment;filename="+encFName);
			
			ServletOutputStream sos = response.getOutputStream();
			
			byte [] buf = new byte[1024];
			
			//int cnt = 0;
			while(fis.available()>0) { //읽을 내용이 남아 있다면
				int len = fis.read(buf);  //읽어서 -> buf 에 넣음
											//len : 넣은 byte 길이
				
				sos.write(buf, 0, len); //보낸다 :  buf의 0부터 len 만큼
				
				//cnt ++;
				//System.out.println(cnt+":"+len);
			}
			
			sos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void fileDeleteModule(BoardDTO delDTO, HttpServletRequest request) {
		if(delDTO.getUpfile()!=null) {
			String path = request.getServletContext().getRealPath("up");
			path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
			
			new File(path+"\\"+delDTO.getUpfile()).delete();
		}
	}
	
	
}
