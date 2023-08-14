package anno_p;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("anno_xml/autowire.xml")  // 가능은 하지만 그렇게 권장사항은 아님 Bean을 직접만드는것은 별로
@ComponentScan(basePackages = "anno_p.com")
public class AnnoConfig {
	
	@Bean
	BiHandle hd1() {
		return new BiHandle("일자핸들", "산악용");
	}
	@Bean
	BiHandle hd2() {
		return new BiHandle("3자핸들", "오인");
	}
	
	@Bean
	BiWheel wh1() {
		return new BiWheel("디스크", 28);
	}
	@Bean
	BiWheel wh2() {
		return new BiWheel("카본", 27);
	}
	
	@Bean
	BiCycle mtb(BiHandle hd1,BiWheel wh1) {
		return new BiCycle("삼천리", hd1, wh1);
	}
	
	@Bean
	BiCycle pb(BiHandle hd2,BiWheel wh2) {
		return new BiCycle("화려강산", hd2, wh2);
	}
}
