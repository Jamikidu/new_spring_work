package room.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import room.entity.Board;
import room.entity.ZooBoard;

// 작성한 내용을 저장해주는 인터페이스!
public interface BoardRepository extends JpaRepository<Board, Integer> { // <> 뒤에 값이 기본키
	// 있는 테이블에 새로운 테이블을 저장하겠다는 뜻
	Board save(Board board);
	
}
