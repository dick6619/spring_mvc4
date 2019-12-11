package com.iii.emp.test;

public class TEST4 {

	int getGCD(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) {
		TEST4 t = new TEST4();

		System.out.println(t.getGCD(35, 528));

	}
}
