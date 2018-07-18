package com.iii.emp.test;

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
		test2.getBin8(-128);
		System.out.println("");
		test2.getBin32(-2147483648);
	}

}
