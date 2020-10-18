package com.iii.emp.test;

public class Test {

	public static void main(String[] args) {

		Test t = new Test();

		System.out.println(t.gcd(50, 24));
	}

	//
	public int count = 0;

	// callCountTest(7)呼叫了幾次
	int callCountTest(int n) {
		count++;
		int result = 0;
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			result = callCountTest(n - 3) + callCountTest(n - 2) + callCountTest(n - 2);
		}

		return result;
	}

	// a*b乘法遞迴
	int mult(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			return mult(a, b - 1) + a;
		}
	}

	// summation 遞迴
	int summation(int n) {
		if (n == 1) {
			return 1;
		} else {
			return summation(n - 1) + n;
		}
	}

	// summation 非遞迴
	int summation2(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;

	}

	// n階層遞迴
	int f(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * f(n - 1);
		}
	}

	// n階層非遞迴
	int f2(int n) {
		int result = 1;
		for (int i = 1; i < n; i++) {
			result *= i;
		}
		return result;
	}

	// 費式數列遞迴
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

	// 費式數列非遞迴
	int fibonacci2(int n) {
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

	// 帕斯卡遞迴
	int binomial(int n, int m) {

		if (n == m || m == 0) {
			return 1;
		} else {
			return binomial(n - 1, m) + binomial(n - 1, m - 1);
		}

	}

	// 帕斯卡非遞迴版本。integer能表示的大小有限 4bytes
	int binomial2(int n, int m) {

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

	// 最大公因數遞迴
	int gcd(int n, int m) {
		if (m == 0)
			return n;
		else {
			return gcd(m, n % m);
		}
	}

}
