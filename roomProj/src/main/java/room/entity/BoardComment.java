package room.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="boardComment")	//테이블명임
@Data
public class BoardComment {

	@Id
	@Column(name="boardcomment_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //기본키
	int no;
	
	//댓글 입장에서는 다대일의 관계
	@ManyToOne(fetch = FetchType.LAZY)	// fetch ==> 댓글이 있을때만 작동하는 방식! 메모리낭비를 방지
	@JoinColumn(name = "board_no")		// 기존 board 에 board_no와 연관됨!
	Board board;
	
	@Column(name="content", nullable=false, length=3000)
	String content;
	@Column(nullable=false)
	String username;
	
	@Column
	LocalDateTime reg_Date;

}
