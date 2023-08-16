package aaa_exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exam_main2 {
	
	public static void main(String[] args) {
		for(int i=1;i<=100/3;i++) {
			System.out.print(3*i+",");
		}
		System.out.println();
		for(int i=3;i<=100;i+=3) {
			System.out.print(i+",");
		}
		System.out.println();
		for(int i=1;i<100;i++) {
			if(i%3==0) {
				System.out.print(i+",");
			}
		}
		System.out.println("\n===========================================================================");
		System.out.println();
		for(int i=1;i<=100/6;i++) {
			System.out.print(6*i+",");
		}
		System.out.println();
		for(int i=6;i<=100;i+=6) {
			System.out.print(i+",");
		}
		System.out.println();
		for(int i=1;i<100;i++) {
			if(i%6==0) {
				System.out.print(i+",");
			}
			
		}
		System.out.println("\n===========================================================================");
		int 홀수합=0;
		int 짝수합=0;
		for(int i=1;i<100;i++) {
			if(i%2==1) {
				System.out.print(i+",");
				홀수합 += i;
			}
		}
		System.out.println("\n===========================================================================");
		System.out.print("홀수 합계:" + 홀수합);
		System.out.println("\n===========================================================================");
		for(int i=1;i<100;i++) {
			if(i%2==0) {
				System.out.print(i+",");
				짝수합 += i;
			}
		}
		System.out.println("\n===========================================================================");
		System.out.print("짝수 합계:" + 짝수합);
		System.out.println("\n===========================================================================");
		//m과 n의 공배수를 구하시오 1~1000
		Random ran = new Random();
		int m = ran.nextInt(9)+1;
		int n = ran.nextInt(1,9);
		System.out.println("두 수: "+m+", "+n);
		for(int i=1;i<1000;i++) {
			if(i%m==0 && i%n==0) {
				System.out.print(i+",");
			}
		}
		System.out.println("\n===========================================================================");
		int count1 = 0;
		int count2 = 0;
		for(int i=1;i<100;i++) {
			if(i%2==0) {
				count1++;
			}
			if(i==40) {
				System.out.println(i+"는 "+count1+"번째");
			}
		} 
		for(int i=1;i<100;i++) {
			if(i%2==1) {
				count2++;
			}
			if(i==67) {
				System.out.println(i+"는 "+count2+"번째");
			}
		}
		
		int[] arr1 = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("5개의 수를 입력해주세요");
		int maxnum=0, minnum=0, sum=0;
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = sc.nextInt();
			maxnum = arr1[0];
			minnum = arr1[0];
			sum += arr1[i];
			if(maxnum < arr1[i]) {
				maxnum = arr1[i];
			}
			if(minnum > arr1[i]) {
				minnum = arr1[i];
			}
			
		}
		System.out.println("최대값: "+maxnum);
		System.out.println("최소값: "+minnum);
		System.out.println("배열의합: "+sum);
		System.out.println(Arrays.toString(arr1));
	}
}
