package com.iii.emp.test;

public class Test {

	public static void main(String[] args) {

		Test t = new Test();
		System.out.println(t.binomial(8, 2));
		System.out.println(t.binomial2(8, 2));
		System.out.println(t.binomial3(8, 2));
	}

	// 深度變數測試次數
	public int count = 0;
	// 題目callCountTest(7)呼叫了幾次?
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

	/** a*b乘法遞迴 */
	int mult(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			return mult(a, b - 1) + a;
		}
	}

	/** summation 遞迴 */
	int summation(int n) {
		if (n == 1) {
			return 1;
		} else {
			return summation(n - 1) + n;
		}
	}

	/** summation 非遞迴 */
	int summation2(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;

	}

	/** n階層遞迴 */
	int f(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * f(n - 1);
		}
	}

	/** n階層非遞迴 */
	int f2(int n) {
		int result = 1;
		for (int i = 1; i < n; i++) {
			result *= i;
		}
		return result;
	}

	/** 費式數列遞迴 */
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

	/**
	 * 費式數列非遞迴<br>
	 * Fn = Fn-1 +Fn-2<br>
	 * 每個迴圈後a, b都一直在往右移動<br>
	 * sum = a+b, a往右移動 a=b; b往右移動b=sum;<br>
	 * 
	 */
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

	/**
	 * 帕斯卡遞迴版本<br>
	 * 佔用sys.stack，function call轉移時每次都要存取<br>
	 */
	int binomial(int n, int m) {
		if (n == m || m == 0) {
			return 1;
		} else {
			return binomial(n - 1, m) + binomial(n - 1, m - 1);
		}

	}

	/**
	 * 帕斯卡非遞迴版本<br>
	 * 當階層很大的時候相乘，怕integer 4bytes會無法表示照成overflow<br>
	 */
	int binomial2(int n, int m) {
		int fraction = 1;
		for (int i = n - m + 1; i <= n; i++) {
			fraction *= i;
		}
		int denominator = 1;
		for (int i = 1; i <= m; i++) {
			denominator *= i;
		}
		return fraction / denominator;
	}

	/**
	 * 組合公式(n,m) = n! / m!(n-m)!<br>
	 * 取MAX(m,(n-m))通分。意即分子從k+1開始乘到n;<br>
	 * 若k = m, 則 n-m = n-k;<br>
	 * 若k = n=m, 則m = n-k;<br>
	 **/
	int binomial3(int n, int m) {
		int k = Math.max(m, n - m);
		int fraction = 1;
		for (int i = k + 1; i <= n; i++) {
			fraction *= i;
		}
		int denominator = 1;
		for (int i = 1; i <= n - k; i++) {
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
	
	// 二元樹
	// 低等排序
	// 高等排序

}
