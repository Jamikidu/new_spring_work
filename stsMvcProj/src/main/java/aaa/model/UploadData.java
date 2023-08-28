package aaa.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadData {

	String id, ff1Name, msg, ff2Name, mmffName;
	int age;
	MultipartFile ff1, ff2, mmff;
	
	public String getFf1Name() {
		return ff1.getOriginalFilename();
	}
	
	public String getMmffName() {
		return mmff.getOriginalFilename();
	}
	
}
