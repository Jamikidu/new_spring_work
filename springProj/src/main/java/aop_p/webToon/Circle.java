package aop_p.webToon;

import org.springframework.stereotype.Component;

public class Circle {
	final static float PI = (float)Math.floor(Math.PI*100)/100;
	float r;
	float cirArea;
	float cirRound;
	
	
	public float getR() {
		return r;
	}
	public void setR(float r) {
		this.r = r;
		this.cirArea = r*r*PI;
		this.cirRound = 2*PI*r;
	}
	public float getCirArea() {
		return cirArea;
	}

	public float getCirRound() {
		return cirRound;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + ", cirArea=" + cirArea + ", cirRound=" + cirRound + "]";
	}
}
