package aaa.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

import aaa.service.BoardMapper;
import jakarta.annotation.Resource;
import lombok.Data;

@Alias("mPD")	//mapper.xml에서 사용하기위해서 Alias설정해줌
@Data
public class MyPageData {

	int limit = 4; // 한 페이지에 나타낼 글 목록의 수
	int pageLimit = 5; // 페이지를 몇개씩 나타낼 것인가의 수
	// int start = 0;
	int page, start, pageStart, pageEnd, total, pageTotal;
	// 초기페이지, 게시글시작번호, 표시되는 페이지의 첫번째, 표시되는 페이지의 마지막, 게시글의 총갯수, 표시되는 페이지의 총갯수
	
	
	public MyPageData(int page) {
		this.page = page;
		
//		이건 이클립스에서 하던방법
//		page = 1; //첫번째페이지(초기값)
//		
//		 if (mpd != null && mpd.page != 1) {
//			page = mpd.page;
//		}

	}
	
	
	public void calc(int countList) {
//		total = mapper.list().size();		//게시판 리스트의 총갯수
		total = countList;		//게시판 리스트의 총갯수
		System.out.println("total: "+total);//
		//total = mapper.list().size();
		
		pageTotal = total/limit;	//표시되는 페이지의 총갯수(1~끝페이지까지)
		
		if(total%limit>0) {	//게시판 리스트의 총갯수 나누기 한페이지에 나타낼 게시글의 수의 나머지가 0보다 크다면
			pageTotal++;	//표시되는 페이지의 총갯수에 +1
		}
		
		System.out.println("pageTotal: "+pageTotal);
		
		
		start = (page-1)*limit;
		pageStart = (page-1)/pageLimit*pageLimit+1;
		pageEnd = pageStart + pageLimit -1;
		System.out.println("pageTotal, pageEnd:"+pageTotal+", "+pageEnd);
		
		if(pageEnd > pageTotal) {
			pageEnd = pageTotal;
		}
		
		System.out.println("pageTotal, pageEnd:"+pageTotal+", "+pageEnd);
		
	}
	

}
