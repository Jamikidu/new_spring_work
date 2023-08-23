package aaa.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import aaa.model.UploadData;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value="upload", method= RequestMethod.GET)
	String fileForm() {
		return "file/uploadForm";
	}
	
	@RequestMapping(value="upload", method= RequestMethod.POST)
	String fileReg(
			Model mm,
			@ModelAttribute("id")String id,
			@ModelAttribute("age")int age,
			MultipartFile ff1,
			MultipartFile ff2) {
		
		System.out.println("ff1: "+ff1);
		System.out.println("ff2: "+ff2);
		System.out.println("OriginalFilename(): "+ff1.getOriginalFilename());
		System.out.println("getName(): "+ff1.getName());
		System.out.println("getContentType(): "+ff1.getContentType());
		System.out.println("getSize(): "+ff1.getSize());
		System.out.println("isEmpty(): "+ff1.isEmpty());
		
		mm.addAttribute("ff1",ff1.getOriginalFilename());
		mm.addAttribute("ff2",ff2.getOriginalFilename());
		return "file/uploadReg";
	}
	
	@RequestMapping(value="upload2")
	String fileReg2(
			Model mm,
			MultipartHttpServletRequest mr) {
		
		
		MultipartFile ff1 = mr.getFile("ff1");
		MultipartFile ff2 = mr.getFile("ff2");
		System.out.println("ff1:"+ ff1);
		System.out.println("ff2:"+ ff2);
		System.out.println("OriginalFilename(): "+ff1.getOriginalFilename());
		System.out.println("getName(): "+ff1.getName());
		System.out.println("getContentType(): "+ff1.getContentType());
		System.out.println("getSize(): "+ff1.getSize());
		System.out.println("isEmpty(): "+ff1.isEmpty());
		
		mm.addAttribute("id",mr.getParameter("id"));
		mm.addAttribute("age",mr.getParameter("age"));
		mm.addAttribute("ff1", ff1.getOriginalFilename());
		mm.addAttribute("ff2", ff2.getOriginalFilename());

		return "file/uploadReg";
	}
	
	@RequestMapping(value="upload3")
	String fileReg3(UploadData ud, HttpServletRequest request) {
		

		System.out.println("ud:"+ ud);
		
		System.out.println("OriginalFilename(): "+ud.getFf1().getOriginalFilename());
		System.out.println("getName(): "+ud.getFf1().getName());
		System.out.println("getContentType(): "+ud.getFf1().getContentType());
		System.out.println("getSize(): "+ud.getFf1().getSize());
		System.out.println("isEmpty(): "+ud.getFf1().isEmpty());
		
		fileSave(ud.getFf1());
		fileSave2(ud, request);
		

		return "file/uploadReg3";
	}
	
	@RequestMapping("download")
	@ResponseBody
	void download(String ff,
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
	
	void fileSave(MultipartFile mf) {
		String path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\file\\up";
		
		File ff = new File(path+"\\"+mf.getOriginalFilename());
		
//		String fileName = ff.getName(); //올릴 파일의 이름
//		String extension = fileName.substring(fileName.lastIndexOf(".")+1); //파일 확장자 (jpg,png...)
//		String shortFn = fileName.substring(0, fileName.lastIndexOf(".")); //확장자를 제외한 파일이름
//		System.out.println("shortFn: "+shortFn);
//		System.out.println("extension: "+extension);
//		
//		int p = 1;
//		
//		System.out.println("ff.getName(): "+ff.getName());
//		System.out.println("mf.getOriginalFilename():"+mf.getOriginalFilename());
//		System.out.println("path\"+shortFn+p+extension : "+path+"\\"+shortFn+p+"."+extension);
//		
//		if(ff.exists()) { //올릴파일이 현재 파일과 이름이 같다면
//			System.out.println("파일이 이미 존재합니다.");		// 이론은 확장자를 제외한 파일이름끝에 1을 추가해서 저장하고 싶었지만
//			int newName = Integer.parseInt(shortFn)+p;  	// 파일 끝자리에 1씩 추가하고 싶었는데 오류가...
//			String strnewName = Integer.toString(newName);  // 숫자 1 추가하고 다시 문자변환
//			System.out.println(strnewName+"."+extension);
//			ff = new File(strnewName+"."+extension);		// 재결합
//			if(ff.getName().equals(mf.getOriginalFilename())) { 
//
//				
//			}
//		}else {
//			System.out.println("업로드합니다.");
//		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(mf.getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void fileSave2(UploadData ud, HttpServletRequest request) {
		ud.setMsg(null);
		//파일 업로드 유무 확인
		if(ud.getFf2().isEmpty()) {
			
			ud.setMsg("파일이 비었어");
			return;
		}
		
		String path = request.getServletContext().getRealPath("up");
		path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		int dot = ud.getFf2().getOriginalFilename().lastIndexOf(".");
		String fDomain = ud.getFf2().getOriginalFilename().substring(0, dot);
		String ext = ud.getFf2().getOriginalFilename().substring(dot);
		
		//이미지인지 확인
		if(!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
			
			ud.setMsg("이미지 파일이 아님");
			return;
		}
		
		ud.setFf2Name(fDomain+ext); 
		File ff = new File(path+"\\"+ud.getFf2Name());
		int cnt = 1;
		while(ff.exists()) {
			 
			ud.setFf2Name(fDomain+"_"+cnt+ext);
			ff = new File(path+"\\"+ud.getFf2Name());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(ud.getFf2().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
