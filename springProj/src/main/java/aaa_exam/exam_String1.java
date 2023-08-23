package aaa_exam;

import java.util.Scanner;

public class exam_String1 {

	public static void main(String[] args) {
		/*
		String str1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		str1 = sc.nextLine();
		String str2[] = new String[str1.length()];
		for(int i=0;i<str1.length();i++) {
			System.out.println(str1.charAt(str1.length()-1-i));
			//str2[str1.length()-i]= str1.charAt(i);
		}
		for(int i=str1.length()-1;i>=0;i--) {
			System.out.println(str1.charAt(i));
			//str2[str1.length()-i]= str1.charAt(i);
		}
		*/
		String www = "www.google.com";
		
		int 앞점위치 = www.indexOf(".");
		int 뒤점위치 = www.lastIndexOf(".");
		
		System.out.println(www.indexOf("."));
		System.out.println(www.lastIndexOf("."));
		System.out.println("앞에 점 앞에 문자: "+www.substring(0,앞점위치));
		System.out.println("뒤에 점 뒤에 문자: "+www.substring(뒤점위치+1));
		System.out.println("앞에 점과 뒤에 점 사이의 값: "+www.substring(앞점위치+1,뒤점위치));
		System.out.println("앞에 점과 뒤에 점 사이의 값 대문자로: "+www.substring(앞점위치+1,뒤점위치).toUpperCase());
	}

}
