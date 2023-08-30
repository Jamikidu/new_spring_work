package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.BoardDTO;
import aaa.model.MyPageData;

@Mapper
public interface BoardMapper {
	
	int countList(); //보드리스트의 게시글의 총갯수 구하기
	
	List<BoardDTO> list(MyPageData mpd);
	
	BoardDTO detail(int id);
	
	int insseerr(BoardDTO dto);
	
	int delettt(BoardDTO dto);
	
	int modifffy(BoardDTO dto);
	
	int cntuuup(BoardDTO dto);
	
	int maxId();
	
	int fileDelete(BoardDTO dto);

	int idPwChk(BoardDTO dto);
	
}
