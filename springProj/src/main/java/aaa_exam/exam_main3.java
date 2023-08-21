package aaa_exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.springframework.cglib.transform.impl.AddDelegateTransformer;

public class exam_main3 {
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("array문제2");
		System.out.println("문자 하나 입력하세요.");
		
		while(true) {
			String str1 = sc.nextLine();
			if(str1.length()<30) {
				String[] strarr1 = str1.split("");
				System.out.println(Arrays.toString(strarr1));
				System.out.println("str의 길이:"+ strarr1.length);
				System.out.println("str의 길이:"+ str1.length());
				break;
			}
			System.out.println("글자 수가 30개가 넘었습니다 다시입력하세요.");
		}
		*/
		/* while문 안쓰고
		if(str1.length()>30) {
			System.out.println("글자 수가 30개가 넘었습니다 종료합니다.");
			System.exit(0);
		}else {
			//String[] strarr1 = new String[str1.length()];
			String[] strarr1 = str1.split("");
			System.out.println(Arrays.toString(strarr1));
			System.out.println("str의 길이:"+ strarr1.length);
			System.out.println("str의 길이:"+ str1.length());
		}
		*/
/*		char[] ch1 = new char[4];
		ch1[0] = '가';
		ch1[1] = '나';
		ch1[2] = '다';
		ch1[3] = '라';
		System.out.println(Arrays.toString(ch1));*/
		/*
		System.out.println("array문제3");
		Scanner sc = new Scanner(System.in);
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
		System.out.println("LOVE를 입력했을때 V가 나오게끔 하시오");
		for(int i=0;i<strarr1.length;i++) {
			if(strarr1[i].equals("V")) {
				System.out.println(strarr1[i]+": 배열의 "+(i+1)+"번째입니다.");
			}
		}
		System.out.println("a: "+'a');
		System.out.println("A: "+'A');
		char V = 'V';
		
		//char로 비교하기
		for(int i=0;i<strarr1.length;i++) { 
			
			if((int)str2.charAt(i) == (int)V) {
				System.out.println(str2.charAt(i));
			}
		}
		*/
		/*
		Scanner sc = new Scanner(System.in);
		String eng1 = sc.nextLine();
		String[] eng2 = new String[eng1.length()];
		for(int i=eng1.length();i<eng1.length();i--) {
			
		}

		char[] ceng2 = eng1.toCharArray();
		char[] ceng3 = new char[ceng2.length];
		System.out.println(ceng2);
		for(int i=0;i<ceng2.length;i++) {
			
			ceng3[i] = ceng2[ceng2.length-i];
		}
		*/
	}
}
