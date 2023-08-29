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
	Date regDate;
	
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
	
	public boolean isImg() {

		boolean res = Pattern.matches(".*[.](jpg|bmp|png|gif)", upfile.toLowerCase());
		
		return res;
	}
	
}


