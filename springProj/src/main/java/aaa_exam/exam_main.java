package aaa_exam;

import java.util.Scanner;

public class exam_main {
	
	public static void main(String[] args) {
//		String h = "Hello World";
//		
//		for(int i=0; i<3; i++) {
//			System.out.println(h);
//		}
//		
//		System.out.println("Hello World\nHello World\nHello World");*/
//		
//		System.out.println("홍길동\n홍 길 동\n홍  길  동");
//		
//		for(int i=0; i<3; i++) {
//			String j = " ";
//			System.out.println("홍"+j*i-1+"길"+"동");
//		}
		
		
//		System.out.printf("강정현\n");
//		System.out.printf("강남구논현동\n");
//		System.out.printf("010-2570-2909\n");
//		
//		System.out.printf("제 이름은 %s입니다.\n제 나이는 %d살 이고요.\n제가 사는 곳의 번지수는 %d-%d입니다.","홍길동",20,123,456);
//		System.out.println();
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("두 수를 입력해보자");
//		int su1 = sc.nextInt();
//		int su2 = sc.nextInt();
//		System.out.println(su1-su2+", "+su1*su2);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int num3 = sc.nextInt();
//		System.out.println(num1+num2);
//		System.out.println(num1*num2);
//		System.out.println(num1*num2+num3);
//		System.out.printf("%d*%d+%d=%d",num1,num2,num3,num1*num2+num3);
//		System.out.println();
//		
		
//		System.out.println("자 제곱 할 수를 입력해 주세요");
//		Scanner sc = new Scanner(System.in);
//		int gob1 = sc.nextInt();
//		String str_gob1 = Integer.toString(gob1);
//		
//		System.out.println(str_gob1+" * "+str_gob1+" = "+gob1*gob1);
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("두 수를 입력해 주세요");
//		int na1 = sc.nextInt();
//		int na2 = sc.nextInt();
//		System.out.println("몫: "+na1/na2+", 나머지: "+na1%na2);
		
		
		
		int max = 0;
		System.out.println("시작");
		while(max<5) {
			int soo1 = sc.nextInt();
			if(soo1%2 == 1) {
				System.out.println("홀수입니다.");
				max++;

			}else {
				System.out.println("짝수입니다.");
				max++;
			}
		}
		System.out.println("종료");
		int adult = 18;
		int age = sc.nextInt();
		if(age>adult) {
			System.out.println(age+"살은 성인입니다.");
		}else {
			System.out.println(age+"살은 미성년자입니다.");
		}
		
		int [] arr1 = {23,45,67};
		int arrmax = arr1[0];
		if(arr1[1]>arrmax) {
			arrmax = arr1[1];
		}
		if(arr1[2]>arrmax) {
			arrmax = arr1[2];
		}
		System.out.println(arrmax);
	}
}
