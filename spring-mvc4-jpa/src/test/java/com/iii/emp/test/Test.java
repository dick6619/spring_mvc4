package com.iii.emp.test;

/**
 * 1. 遞迴在演算法內是button up的一種<br>
 * 2. 也是divide and conquer，將問題越切越小，直到找到答案，再反解回去<br>
 * 3. 以上得知是收斂特性<br>
 * 4. merge sort合併排序，也是。<br>
 * 
 */
public class Test {

	public static void main(String[] args) {
		Test fuctionTest = new Test();
		System.out.println(fuctionTest.ack(2, 2));
		System.out.println(fuctionTest.gcd2(4, 0));
		System.out.println(fuctionTest.gcd(0, 4));
		System.out.println(fuctionTest.pow(-2, 9));
		System.out.println(fuctionTest.pow2(-2, 9));

		// fuctionTest.hanoi(4, 'A', 'B', 'C');

		fuctionTest.hanoi(8, 'A', 'B', 'C', 'D');
		fuctionTest.perm(new String[]{"1","2","3"}, 0, 2);
		
		
		int i = 1;
		
		System.out.println(2*--i);
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

	/** GCD最大公因數遞迴 */
	int gcd(int n, int m) {
		if (m == 0)
			return n;
		else {
			return gcd(m, n % m);
		}
	}

	/** GCD非遞迴 */
	int gcd2(int n, int m) {
		int tmep = -1;
		while (m != 0) {
			tmep = m;
			m = n % m;
			n = tmep;
		}
		return n;
	}

	/** GCD非遞迴，輾轉相除 */
	int gcd3(int n, int m) {
		while (n != 0 && m != 0) {
			if (n > m) {
				n = n % m;
			} else {
				m = m % n;
			}
		}
		if (n == 0) {
			return m;
		} else {
			return n;
		}
	}

	/**
	 * 阿克曼函數<br>
	 * definition:<br>
	 * Ackerman(m,n): 1.n+1, if m=0; 2.a(m-1, 1), if n=0; 3.a(m-1, a(m, n-1))
	 * otherwise;
	 * 
	 * ack(1,2) = 4<br>
	 * ack(2.1) = 5<br>
	 * ack(2,2) = 7<br>
	 */
	int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return ack(m - 1, 1);
		} else {
			return ack(m - 1, ack(m, n - 1));
		}
	}

	/**
	 * 求x的y次方，此function求y>=0狀況，不探討y<0 若y < 0 則求出來為倒數<br>
	 * 遞迴版本<br>
	 * 
	 */

	int pow(int x, int y) {
		if (y == 0) {
			return 1;
		} else {
			return x * pow(x, y - 1);
		}
	}

	/**
	 * 非遞迴版本
	 */
	int pow2(int x, int y) {
		int count = 1;
		for (int i = 1; i <= y; i++) {
			count *= x;
		}
		return count;
	}

	/**
	 * Hanoi(河內塔)<BR>
	 * 1. 從A移動n-1,到B<BR>
	 * 2. 從A將最大的移動到C<BR>
	 * 3. 把B上的n-1個塔移動到C<BR>
	 * 
	 * n個塔，T(n) = T(n - 1) + 1 + T(n - 1) = 2T(n - 1) + 1;<br>
	 * 
	 * T(n) = 2^1T(n-1)+1<br>
	 * = 2^2T(n-2)+2+1<br>
	 * = 2^3T(n-3)+4+2+1<br>
	 * = 2^4T(n-4)+8+4+2+1<br>
	 * ....<br>
	 * = 2^nT(n-n)+2^n-1+....+4+2+1<br>
	 * 前面為0，算後面等比級數，0~n-1項共n項．依等比級數公式，a(1-r^n) / 1-r = 1-2^n / -1 = (2^n) -1 <br>
	 * 得知結果為(2^n) -1次<br>
	 * Big0(2^n)<br>
	 * 推演移動過程<br>
	 *
	 * @param n:
	 *            disk數目
	 * @param a:
	 *            source
	 * @param b:
	 *            bridge
	 * @param c:
	 *            target
	 */
	void hanoi(int n, char a, char b, char c) {
		// 1個直接移動至target
		if (n == 1) {
			// move disc from a to c
			System.out.println("move disc from" + a + " to " + c);
		} else {
			// step 1 : 將n-1個盤子，由A透過中繼C移至B
			hanoi(n - 1, a, c, b);
			// step 2 : 剩下的盤子由A移至C
			System.out.println("move disc from" + a + " to " + c);
			// step 3 : 最後將B上的n-1個盤子移至C
			hanoi(n - 1, b, a, c);
		}
	}

	/**
	 * 4個棍子，證明8盤最佳解33步
	 *  step 1: m取n/2個盤子, 從a過程會經過c和d到b(使用k根棍子)
		move disc fromA to D
		move disc fromA to C
		move disc fromD to C
		move disc fromA to D
		move disc fromA to B
		move disc fromD to B
		move disc fromC to A
		move disc fromC to B
		move disc fromA to B
		-------------------------
		step 2 : 剩下n/2個盤子，因大小規則關係b棍無法使用，所以等同於3棍河內塔a,c,d(k-1根棍子)
		move disc fromA to C
		move disc fromA to D
		move disc fromC to D
		move disc fromA to C
		move disc fromD to A
		move disc fromD to C
		move disc fromA to C
		move disc fromA to D
		move disc fromC to D
		move disc fromC to A
		move disc fromD to A
		move disc fromC to D
		-------------------------
		step 3 : b上的n/2個盤子, 從b過程會經過a和c到d(使用k根棍子)
		move disc fromB to C
		move disc fromB to A
		move disc fromC to A
		move disc fromB to C
		move disc fromB to D
		move disc fromC to D
		move disc fromA to B
		move disc fromA to D
		move disc fromB to D
	 */
	void hanoi(int n, char a, char b, char c, char d) {
		if (n == 1) {
			// move disc from a to d
			System.out.println("move disc from" + a + " to " + d);
		} else {
			// step 1 : 將m個移至b棍
			hanoi(n / 2, a, c, d, b);
			// step 2 : 大小規則只有k-1根棍子可以使用，等同3塔，將n-m個移至d棍
			hanoi(n / 2, a, c, d);
			// step 3 : 將b棍上m個移至d
			hanoi(n / 2, b, a, c, d);
		}
	}

	/**
	 * 排列組合遞迴印出所有可能
	 */
	void perm(String[] elements, int start, int end) {

		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(elements[i]);
			}
			System.out.print(",");
		} else {
			for (int i = start; i <= end; i++) {
				String temp = elements[start];
				elements[start] = elements[i];
				elements[i] = temp;

				perm(elements, start + 1, end);

				String temp1 = elements[start];
				elements[start] = elements[i];
				elements[i] = temp1;
			}
		}
	}

	/**
	 * 排序問題
	 */
	// 二元樹
	// 低等排序
	int[] insertionSort(int[] arr) {
		return null;
	}

	int[] selectionSort(int[] arr) {
		return null;
	}

	int[] bubbleSort(int[] arr) {
		return null;
	}

	// 高等排序
	int[] quickSort(int[] arr) {
		return null;
	}

	int[] mergeSort(int[] arr) {
		return null;
	}

	int[] heapSort(int[] arr) {
		return null;
	}

}
