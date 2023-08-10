package di_p;

import java.util.Arrays;

public class Student {

	String name;
	int[] scores;
	int sum;
	int rank = 1;
	float avg;
	
	

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int... scores) {
		this.scores = scores;
		sum = 0;
		for(int i : scores) {
			sum += i;
			avg = (float)sum/scores.length;
		}
		/* 내가 한 방식은 setSum,setAvg에서 계산해줬지만 int 불러올때 바로 계산하는게 더 편함
		setSum(scores);
		setAvg(sum, scores);
		*/
	}
	public int getSum() {
		return sum;
	}
	/* 내가 한 방식
	public void setSum(int[] scores) {
		this.sum = 0;
		 for (int i = 0; i < scores.length; i++) {
	            this.sum += scores[i];
	        }
	}
	*/
	public float getAvg() {
		return avg;
	}
	/* 내가 한 방식
	public void setAvg(int sum, int[] scores) {
		this.avg = (float)sum/scores.length;
	}
	*/
	@Override
	public String toString() {
		return "학생 [이름=" + name + ", 과목점수=" + Arrays.toString(scores) + ", 총점=" + sum + ", 등수=" + rank
				+ ", 평균=" + avg + "]\n";
	}
	
	
	/*
	 * @Override public String toString() { return "학생 class [이름=" + name +
	 * ", 과목점수들=" + Arrays.toString(scores) + ", 총점=" + sum + ", 평균=" + avg +
	 * "] \n"; }
	 */
}
