package Arry;

public class Arry {
	public static void main(String[] args) {				
			//배열 선언 법 - 1. 자리수만 잡아주는 선언				
			int n[] = new int[2];			//0 으로 초기화 됨.	
			// int []n = new int[2];			//0 으로 초기화 됨.	
			System.out.println(n[1]);				
							
			n[0]=1;				
			n[1]=2;				
			System.out.print(n[0]);				
			System.out.println(n[1]);				
							
			String s[] = new String[2];	//null 로 초기화 됨.			
			System.out.println(s[1]);				
			s[0]="개";				
			s[1]="괭이";				
			System.out.print(s[0]);				
			System.out.println(s[1]);				
							
			//배열 선언 법 - 2.바로 값도 주는 선언(방식1)				
			int m[] = new int[] {1,2};				
							
			System.out.print(m[0]);				
			System.out.println(m[1]);				
							
			//배열 선언 법 - 3.바로 값도 주는 선언(방식2)				
			int x[] = {1,2};				
							
			System.out.print(x[0]);				
			System.out.print(x[1]);				
		}					
	}
