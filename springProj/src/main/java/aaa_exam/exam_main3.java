package aaa_exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exam_main3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		System.out.println("문자 하나 입력하세요.");
		String str1 = sc.nextLine();
		if(str1.length()>30) {
			System.exit(0);
		}else {
			String[] strarr1 = new String[str1.length()];
			System.out.println("str의 길이:"+ strarr1.length);
			System.out.println("str의 길이:"+ str1.length());
		}
		*/
		String str2 = sc.nextLine();
		String[] strarr1 = str2.split("");
		System.out.println(Arrays.toString(strarr1));
		for(int i=0;i<strarr1.length;i++) {
		}
	}
}
