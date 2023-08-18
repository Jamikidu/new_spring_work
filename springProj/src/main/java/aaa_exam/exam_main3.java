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
		/*
		String str2 = sc.nextLine();
		char maxchar = str2.charAt(0);
		
		String[] strarr1 = str2.split("");
		System.out.println(Arrays.toString(strarr1));
		for(int i=0;i<strarr1.length;i++) {
			if((int)maxchar<(int)str2.charAt(i)) {
				maxchar = str2.charAt(i);
			}
			System.out.print((int)str2.charAt(i)+",");
		}
		System.out.println("\n제일 큰 글자: "+maxchar);
		*/
		String eng1 = sc.nextLine();

		char[] ceng2 = eng1.toCharArray();
		char[] ceng3 = new char[ceng2.length];
		System.out.println(ceng2);
		for(int i=0;i<ceng2.length;i++) {
			
			ceng3[i] = ceng2[ceng2.length-i];
		}
		
	}
}
