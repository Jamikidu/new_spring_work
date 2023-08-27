package room.controll;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import room.entity.Board;
import room.entity.BoardComment;
import room.repository.BoardRepository;

@Controller
public class BoardController {

	private final BoardRepository boardRepository;
	
	public BoardController(BoardRepository boardRepository) {
		super();
		this.boardRepository = boardRepository;
	}

	@GetMapping("/board/write")
	public String writeForm() {
		return "board/boardWrite";	// 작성 폼 템플릿 경로 반환
	}

	@PostMapping("/board/write")
	public String writeReg(Board board) {	// board 객체를 데이터베이스에 저장하는 로직
		board.setReg_Date(LocalDateTime.now());	//set으로 직접입력시켜줌!
		boardRepository.save(board);		// 작성한걸 save 호출해서 저장!
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model mm) {
		List<Board> boardList = boardRepository.findAll();
		mm.addAttribute("boardList",boardList);
		
		return "board/boardList";
	}

	//디테일 게시판 만들어보기!
	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id,Model mm) {
		Optional<Board> opboard = boardRepository.findById(id);
		//System.out.println(opboard.isPresent()); ==> true
		
		if(opboard.isPresent()) {
			Board board = opboard.get();
			board.setCnt(board.getCnt()+1);
			boardRepository.save(board);
			
			mm.addAttribute("boardDetail",board);
			return "board/boardDetail";
		}else {
			
			return "redirect:/board/list";
		}
	}
	
	//게시글 삭제하기
	@GetMapping("/board/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		
		boardRepository.deleteById(id);
		
		return "redirect:/board/list";
	}
	
	//게시글 수정하기
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable int id,Model mm) {
		
		Optional<Board> opboard = boardRepository.findById(id);

		
		if(opboard.isPresent()) {
			Board board = opboard.get();
			mm.addAttribute("modifiedBoard",board);
			return "board/boardModify";
		}else {
			
			return "redirect:/board/list";
		}
		
	}
	
	@PostMapping("/board/modify/{id}")
	public String modifyReg(@PathVariable int id,Board bd) {
		Optional<Board> opboard = boardRepository.findById(id);
		if(opboard.isPresent()) {
			Board newboard = opboard.get();			
			newboard.setContent(bd.getContent());
			newboard.setTitle(bd.getTitle());
			newboard.setReg_Date(LocalDateTime.now());
			
			boardRepository.save(newboard);
			return "redirect:/board/list";
		}
			
		return "redirect:/board/list";
		
	}
	
	@PostMapping("/board/addComment/{id}")
	public String addComment(@PathVariable int id,BoardComment bdc) {
		Optional<Board> opboard = boardRepository.findById(id);
		if(opboard.isPresent()) {
			Board newboard = opboard.get();			
			BoardComment comment = new BoardComment();
			comment.setBoard(newboard);
			comment.setContent(bdc.getContent());
			comment.setUsername(bdc.getUsername());
			comment.setReg_Date(LocalDateTime.now());
			newboard.getComments().add(comment);
			
			boardRepository.save(newboard);
			
		}
			
		return "redirect:/board/detail/{id}";
		
	}
	
	
}
