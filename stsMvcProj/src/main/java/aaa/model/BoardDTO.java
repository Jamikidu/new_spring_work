package aaa.model;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Alias("bDTO")
@Data
public class BoardDTO {
	
	MultipartFile mmff;

	int id, cnt, seq, lev, gid;
	String title, pname, pw, upfile, content;
	String msg, goUrl;
	String grade;
	
	Date regDate;
	
	public BoardDTO() {
		super();
	}
	
//	public boolean isImg() {
//	    // 이미지 파일 확장자 목록
//		int dot = upfile.lastIndexOf(".");
//		String fDomain = upfile.substring(0, dot);
//		String ext = upfile.substring(dot);
//		
//		//이미지인지 확인
//		if(Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
//		
//			return true;
//		}
//		
//		return false;
//	}
	
	public String getUpfile() {
		if(upfile == null || upfile.trim().equals("") ||  upfile.trim().equals("null") ) {
			upfile = null;
		}
		return upfile;
	}
	
	public boolean isImg() {
		if(getUpfile()==null) {
			return false;
		}
		return Pattern.matches(".{1,}[.](bmp|png|gif|jpg|jpeg)", upfile.toLowerCase());
	}

	public BoardDTO(String title, String pname, String pw, String content) {
		super();
		this.title = title;
		this.pname = pname;
		this.pw = pw;
		this.content = content;
	}

	
}


