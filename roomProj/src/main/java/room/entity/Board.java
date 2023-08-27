package room.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


//JPA에서 엔티티란 쉽게 생각하면, DB 테이블에 대응하는 하나의 클래스라고 생각할 수 있습니다.
//@Entity가 붙은 클래스는 JPA가 관리해주며, JPA를 사용해서 DB 테이블과 매핑할 클래스는 @Entity를 꼭 붙여야만 매핑이 가능합니다.
@Entity
@Table(name="board")	//테이블명임
@Data
public class Board {

	@Id
	@Column(name="board_no") //@Column은 객체 필드를 테이블의 컬럼에 매핑시켜주는 어노테이션입니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //기본키
	int no;
	
	@Column(nullable=false) //nullable=false 는 null이면 안된다
	String title;  //write할때 writeForm에 name으로 된 값이 저장됨
	@Column(name="content", nullable=false, length=3000)
	String content;
	@Column(nullable=false)
	String username;
	
	
	@Column
	LocalDateTime reg_Date;
	@Column
	int cnt=0;
	
	//mappedBy=부모 , cascade=자식요소들도 다 삭제, 
	@OneToMany(mappedBy="board", cascade=CascadeType.ALL, orphanRemoval = true)
	List<BoardComment> comments = new ArrayList<>();
	
}
