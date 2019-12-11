package com.iii.emp.test;

public class Test2 {
	
	int recv(int n) {
		if(n == 0) return 1;
		return 2* recv(n-1) +3;
	}
	
	public static void main(String[] args) {
		
		Integer i = new Integer(20);
		Integer jj = 20;
		int j = 20;
		
		System.out.println(i==j);
			
			
	}

}
