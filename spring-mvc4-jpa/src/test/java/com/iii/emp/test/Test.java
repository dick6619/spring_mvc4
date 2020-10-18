package com.iii.emp.test;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		// System.out.println(t.mult(10, 3));
		// System.out.println(t.sum(10));
		// System.out.println(t.test(10));
		// System.out.println(t.f(6));
		// System.out.println(t.fibonacci(4));
		int a[] = { 8, 15, 23, 30, 7, 2, 10, 13, 6, 5 };
		for (int j = 4; j >= 1; j--) {
			a = t.func(j, 9, a);

			// for (int i = 0; i < a.length; i++) {
			// System.out.print(a[i] + ",");
			// }
			// System.out.println(a[1]);

		}
		System.out.println(a[1]);
		System.out.println(7 >> 1);

		System.out.println("test" + t.bi(4, 2));
	}

	int fib(int n) {

		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	int f(int n) {
		if (n == 0)
			return 1;
		return n * f(n - 1);

	}

	//
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
		int result = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			result = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return result;
	}

	int[] func(int s, int e, int[] a) {

		int i, r;
		r = a[s];
		for (i = s * 2; i <= e; i = i * 2) {
			if (i < e && a[i] < a[i + 1]) {
				i++;
			}
			if (r > a[i]) {
				break;
			}
			a[i / 2] = a[i];
		}
		a[i / 2] = r;

		return a;
	}

	// 0 1 2 3 4 5 6 7
	// 0 1 1 2 3 5 8 13
	int fib2(int n) {
		int a = 0, b = 1, sum = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		for (int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;

	}

	// 非遞迴版本
	int bi(int n, int m) {

		int denominator = 1;
		int fraction = 1;
		// 分子
		for (int i = n - m + 1; i <= n; i++) {
			fraction *= i;
		}
		// 分母
		for (int i = 1; i <= m; i++) {
			denominator *= i;
		}

		return fraction / denominator;
	}

}
