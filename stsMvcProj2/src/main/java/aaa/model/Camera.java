package aaa.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Camera {

	String name = "전방카메라";
	int pixel = 2080;
}
