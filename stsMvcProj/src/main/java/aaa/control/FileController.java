package aaa.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import aaa.model.UploadData;

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
	String fileReg3(UploadData ud) {
		

		System.out.println("ud:"+ ud);
		
		System.out.println("OriginalFilename(): "+ud.getFf1().getOriginalFilename());
		System.out.println("getName(): "+ud.getFf1().getName());
		System.out.println("getContentType(): "+ud.getFf1().getContentType());
		System.out.println("getSize(): "+ud.getFf1().getSize());
		System.out.println("isEmpty(): "+ud.getFf1().isEmpty());
		
		fileSave(ud.getFf1());
		//fileSave(ud.getFf2());
		

		return "file/uploadReg3";
	}
	
	void fileSave(MultipartFile mf) {
		String path = "C:\\green_project\\new_jspwork\\new_spring_work\\stsMvcProj\\src\\main\\webapp\\views\\file\\up";
		
		File ff = new File(path+"\\"+mf.getOriginalFilename());
		
		String fileName = ff.getName(); //올릴 파일의 이름
		String extension = fileName.substring(fileName.lastIndexOf(".")+1); //파일 확장자
		String shortFn = fileName.substring(0, fileName.lastIndexOf(".")); //확장자를 제외한 파일이름
		System.out.println("shortFn: "+shortFn);
		System.out.println("extension: "+extension);
		
		int p = 1;
		
		System.out.println("ff.getName(): "+ff.getName());
		System.out.println("mf.getOriginalFilename():"+mf.getOriginalFilename());
		System.out.println("path\"+shortFn+p+extension : "+path+"\\"+shortFn+p+"."+extension);
		
		if(ff.exists()) { //올릴파일이 현재 파일과 이름이 같다면
			System.out.println("파일이 이미 존재합니다.");
			int newName = Integer.parseInt(shortFn)+1;
			String strnewName = Integer.toString(newName);
			System.out.println(strnewName+"."+extension);
			ff = new File(strnewName+"."+extension);
			if(ff.getName().equals(mf.getOriginalFilename())) { 

				
			}
		}else {
			System.out.println("업로드합니다.");
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(mf.getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
