package com.iii.emp.test;

import java.math.BigDecimal;

public class MathService {

	
	/**
	 * @param p 本金
	 * @param r 年利率
	 * @param k 一年計息次數
	 * @param t 一年發息次數
	 * @param d 每月存入金額
	 * @param n 存入月數

	 * */
	double getResult(int p, double r, double k, double t, int d, int n) {
		double result = p * Math.pow(Math.pow(1 + r / k, k / t), n)
				+ d * (Math.pow(Math.pow(1 + r / k, k / t), n) - Math.pow(1 + r / k, k / t))
						/ (Math.pow(1 + r / k, k / t) - 1);
		return result;

	}

	public static void main(String[] args) {
		MathService service = new MathService();
		// 本金20000, 年利率0.01, 每日計息(365次), 每月發息(一年12次), 每月存入20000, 12個月後
		double result = service.getResult(750000, 0.01, 365, 12, 20000, 13);
		BigDecimal deci = new BigDecimal(result).setScale(0, BigDecimal.ROUND_HALF_UP);
		System.out.println(deci.intValue());
	}

}
