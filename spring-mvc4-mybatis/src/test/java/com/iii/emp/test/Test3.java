package com.iii.emp.test;

public class Test3 {

	public static void main(String[] args) {
		// 被除數
		int dividend = 3;
		// 除數
		int divisor = 3;
		// 商數
		int count = 0;
		// 餘數
		int remainder = dividend;
		// divisor > remainder
		while (divisor <= remainder) {
			remainder -= divisor;
			count += 1;
		}
		System.out.println("商: " + count);
		System.out.println("餘: " + remainder);
	}

}
