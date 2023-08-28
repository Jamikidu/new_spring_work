package aaa.model;

import lombok.Data;

@Data
public class MyPageData {

	int limit = 3; // 한 페이지에 나타낼 글 목록의 수
	int pageLimit = 4; // 페이지를 몇개씩 나타낼 것인가의 수
	// int start = 0;
	int page, start, pageStart, pageEnd, total, pageTotal;
	// 초기페이지, 게시글시작번호, 표시되는 페이지의 첫번째, 표시되는 페이지의 마지막, 게시글의 총갯수, 표시되는 페이지의 총갯수

	public MyPageData(MyPageData mpd) {
		
		page = 1; //첫번째페이지(초기값)
		
		 if (mpd != null && mpd.page != 1) {
			page = mpd.page;
		}
	}

}
