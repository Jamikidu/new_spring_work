package room.controll;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import room.entity.ZooBoard;
import room.repository.ZooBoardRepository;

@Controller
@RequestMapping("zooboard")
public class ZooController {
	
	//ZooBoardRepository 인터페이스!!
	private final ZooBoardRepository zooboardRepository;

	public ZooController(ZooBoardRepository zooboardRepository) {
		super();
		this.zooboardRepository = zooboardRepository;
	}

	@GetMapping("/zooBoardWrite")
	public String zooWriteForm() {
		return "zooboard/zooBoardWrite";	// 작성 폼 템플릿 경로 반환
	}
	
	@PostMapping("/zooBoardWrite")
	public String zooWriteReg(ZooBoard zb) {	// board 객체를 데이터베이스에 저장하는 로직
		zb.setReg_Date(LocalDateTime.now());	// 날짜는 set으로 LocalDateTime클래스 이용해서 직접입력시켜줌!
		zooboardRepository.save(zb);		// 작성한걸 save 호출해서 저장!
		return "redirect:/zooboard/zooBoardList";
	}
	
	@GetMapping("/zooBoardList")
	public String zooBoardWrite(Model mm) {
		List<ZooBoard> zooBoardList = zooboardRepository.findAll();
		mm.addAttribute("zooBoardList",zooBoardList);
		
		return "zooboard/zooBoardList";
	}
	
}
