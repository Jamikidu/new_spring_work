package aaa.model;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("dtos")
public class BoardDTOs {

	ArrayList<BoardDTO> arr;
	
	String ct = "dtos 내용이여";
	int no = 3;
	
	public BoardDTOs() {
		arr = new ArrayList<>();
		arr.add(new BoardDTO("dtos제목21", "dtos이름91", "1111", "dtos내용sgweg"));
		arr.add(new BoardDTO("dtos제목31", "dtos이름81", "1111", "dtos내용zxcvfbdfb"));
		arr.add(new BoardDTO("dtos제목41", "dtos이름71", "1111", "dtos내용fdgdfgsd"));
		arr.add(new BoardDTO("dtos제목51", "dtos이름61", "1111", "dtos내용ihkul"));

	}
	
	
}
