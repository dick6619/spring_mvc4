package com.iii.emp.test;

// 算術的 shift
public class Test2 {

	// 8bit
	void getBin8(int num) {
		int mask = 1 << 7;
		for (int i = 0; i < 8; i++) {
			if ((num & mask) == 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
			mask >>= 1;
		}
	}
	// 32bit(4byte)
	void getBin32(int num) {
		// 1.不強制轉型，會自動變成int，+(2^31-1) ~ -(2^31), 10000....000 二補數負的最大
		// compile認為沒佔到long的長度
		long mask = (long) 1 << 31;
		for (int i = 0; i < 32; i++) {
			if ((num & mask) == 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
			// 上述1.算術的shift第一位正者恆正，負者恆負．
			mask >>= 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 test2 = new Test2();
		test2.getBin8(-32);
		System.out.println("");
		test2.getBin32(-2147483648);
		
		/*
		 * 0 0 0 0  0
		 * 0 0 0 1  1
		 * 0 0 1 0  2
		 * 0 0 1 1  3
		 * 0 1 0 0  4
		 * 0 1 0 1  5
		 * 0 1 1 0  6
		 * 0 1 1 1  7
		 * 1 0 0 0  8
		 * 1 0 0 1  9
		 * 1 0 1 0  A
		 * 1 0 1 1  B
		 * 1 1 0 0  C
		 * 1 1 0 1  D
		 * 1 1 1 0  E
		 * 1 1 1 1  F
		 * */
		System.out.println();
		System.out.println(0x7FFFFFFF);
		System.out.println(0x80000000);
		System.out.println(0xFF); // 11111111
	}

}
