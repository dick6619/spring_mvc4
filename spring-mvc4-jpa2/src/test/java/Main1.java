import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) {
		// input
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		input.close();
		// input string array
		StringTokenizer st = new StringTokenizer(inputStr);
		String[] inputStrArr = new String[st.countTokens()];
		for (int i = 0; i < inputStrArr.length; i++) {
			inputStrArr[i] = st.nextToken();
		}
		// find max
		System.out.println(findMaxAndSquareValue(inputStrArr));
		// primeFactorization
		for (String s: inputStrArr) {
			System.out.println(primeFactorization(Long.valueOf(s)));
		}
		System.out.println(primeFactorization(0));
	}

	static String findMaxAndSquareValue(String[] arr) {
		if (arr.length < 1) {
			throw new RuntimeException("長度不得為0");
		}
		String maxValue = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (Integer.valueOf(maxValue) < Integer.valueOf(arr[i])) {
				maxValue = arr[i];
			}
		}
		int sq = (int) Math.sqrt(Double.valueOf(maxValue));
		
		StringBuffer sb = new StringBuffer();
		sb.append(maxValue).append(" ").append(sq);
		
		return sb.toString();
	}

	static boolean[] primeArray(long n) {

		boolean[] primeArray = new boolean[(int) n + 1];

		for (int i = 0; i < primeArray.length; i++) {
			if (String.valueOf(i).equals(primeFactorization(i))) {
				primeArray[i] = true;
			}
		}
		return primeArray;
	}

	static String primeFactorization(long n) {
		//
		if (n == 1) {
			return "1";
		}
		List<String> exps = new ArrayList<String>();
		for (int factor = 2; factor <= n; factor++) {
			int exponent = 0;
			while (n % factor == 0) {
				n = n / factor;
				exponent++;

			}
			//
			if (exponent == 1) {
				exps.add(new StringBuffer().append(factor).toString());
			} else if (exponent > 1) {
				exps.add(new StringBuffer().append(factor).append("^").append(exponent).toString());
			}

		}

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < exps.size(); i++) {
			if (i < exps.size() - 1) {
				result.append(exps.get(i)).append(" * ");
			} else {
				result.append(exps.get(i));
			}
		}
		return result.toString();
	}

}
