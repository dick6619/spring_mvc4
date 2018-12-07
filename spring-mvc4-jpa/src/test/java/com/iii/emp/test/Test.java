package com.iii.emp.test;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.mult(10, 3));
		System.out.println(t.sum(10));
		// System.out.println(t.test(10));
		System.out.println(t.f(6));
		System.out.println(t.fibonacci(4));

	}

	int f(int n) {
		if (n == 0)
			return 1;
		return n * f(n - 1);

	}

	int mult(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			return mult(a, b - 1) + a;
		}
	}

	int sum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return sum(n - 1) + n;
		}
	}

	int test(int x) {
		int result = 0;
		if (x <= 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			result = test(x - 3) + test(x - 2) + test(x - 2);
		}
		return result;
	}

	int fibonacci(int n) {
		System.out.println("call");
		int result = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int f_1 = fibonacci(n - 1);
			//
			int f_2 = fibonacci(n - 2);
			result = f_1 + f_2;
		}
		return result;
		/*
		 *
		 * 
		 * 
		 * */
	}
}
