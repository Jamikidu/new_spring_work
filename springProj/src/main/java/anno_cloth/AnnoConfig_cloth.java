package anno_cloth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("anno_xml/cloth.xml")
@ComponentScan(basePackages = "anno_cloth")
public class AnnoConfig_cloth {
	
	/*
	 * @Bean BiHandle hd1() { return new BiHandle("일자핸들", "산악용"); }
	 */
}
