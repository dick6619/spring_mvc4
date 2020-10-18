import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) {
		// input
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		caculate(inputStr);
		input.close();
		

	}

	static BigDecimal caculate(String exp) {
		StringTokenizer st = new StringTokenizer(exp, "-+*/%()", true);
		LinkedList<String> expression = new LinkedList<>();
		while (st.hasMoreElements()) {
			expression.add(st.nextToken());
		}
		BigDecimal pre = new BigDecimal(0);
		String op = "";
		BigDecimal post = new BigDecimal(0);
		;

		while (!expression.isEmpty()) {
			op = expression.remove((expression.size()) + 1 / 2);
			pre = new BigDecimal(expression.removeFirst());
			post = new BigDecimal(expression.removeLast());
		}
		System.out.println(new StringBuffer().append(pre).append(" ").append(op).append(" ").append(post).append(" = ")
				.append(compute(pre, op, post)).append("\n"));
		return compute(pre, op, post);
	}

	static BigDecimal compute(BigDecimal leftValue, String op, BigDecimal rightValue) {
		switch (op) {
		case "+":
			return leftValue.add(rightValue);
		case "-":
			return leftValue.subtract(rightValue);
		case "*":
			return leftValue.multiply(rightValue);
		case "/":
			return leftValue.divide(rightValue);
		case "%":
			return leftValue.remainder(rightValue);
		default:
			throw new ArithmeticException(op + " not defined");
		}

	}

}
