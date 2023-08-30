package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.BoardDTO;
import aaa.model.MyPageData;

@Mapper
public interface MybatisMapper {
	
	int countList(); //보드리스트의 게시글의 총갯수 구하기
	
	List<BoardDTO> list();
	
	List<BoardDTO> listSch(BoardDTO dto);

	List<BoardDTO> cntSch(BoardDTO dto);
	
	BoardDTO detail(int id);
	
	int insseerr(BoardDTO dto);
	
	int delettt(BoardDTO dto);
	
	int modifffy(BoardDTO dto);
	
	int cntuuup(BoardDTO dto);
	
	int maxId();
	
	int fileDelete(BoardDTO dto);

	int idPwChk(BoardDTO dto);
	
}
