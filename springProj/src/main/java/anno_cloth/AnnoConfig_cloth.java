package anno_cloth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("anno_xml/cloth.xml")  // xml 끌어오기
@ComponentScan(basePackages = "anno_cloth")
public class AnnoConfig_cloth {

	@Bean
	Gear ge1() {
		return new Gear("고글1","안경류", "일반등산용");
	}
	
	@Bean
	Gear ge2() {
		return new Gear("고글2","안경류", "스키장용");
	}
	@Bean
	Clothing clo1() {
		return new Clothing("상하의조합1", "등산용상의1", "등산용하의1");
	}
	@Bean
	Clothing clo2() {
		return new Clothing("상하의조합2", "설산용상의1", "설산용하의1");
	}
	@Bean
	Shoes sh1() {
		return new Shoes("등산화1", "등산용");
	}
	@Bean
	Shoes sh2() {
		return new Shoes("방한화1", "스키장용");
	}
	@Bean
	ClothsSet set1(Gear ge1,Clothing clo1,Shoes sh1) {
		return new ClothsSet("일반등산세트1",ge1,clo1,sh1);
	}
	@Bean
	ClothsSet set2(Gear ge2,Clothing clo2,Shoes sh2) {
		return new ClothsSet("스키장세트1",ge2,clo2,sh2);
	}

}
