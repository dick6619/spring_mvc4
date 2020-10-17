import java.math.BigDecimal;
import java.util.*;

class ComputeService {
	// method 1 infix
	static String[] toInfix(String args) {
		StringTokenizer st = new StringTokenizer(args, "-+*/%()", true);
		String[] infixTokens = new String[st.countTokens()];
		for (int i = 0; i < infixTokens.length; i++) {
			infixTokens[i] = st.nextToken();
		}
		return infixTokens;
	}

	// method 2 postfix
	static String[] toPostfix(String args) {
		Stack<String> stack = new Stack<>();
		List<String> tokens = new ArrayList<String>();
		for (String token : toInfix(args)) {
			if ("(".equals(token)) {
				stack.push(token);
			} else if (token.matches("[-+*/%]")) {
				while (stack.size() != 0 && priority(stack.lastElement()) >= priority(token)) {
					tokens.add(stack.pop());
				}
				stack.push(token);
			} else if (")".equals(token)) {
				while (!"(".equals(stack.lastElement())) {
					tokens.add(stack.pop());
				}
				stack.pop();
			} else {
				tokens.add(token);
			}
		}
		while (stack.size() != 0) {
			tokens.add(stack.pop());
		}
		return tokens.toArray(new String[0]);
	}
	// method 3 compute
	static BigDecimal calculate(String args) {
		java.util.LinkedList<BigDecimal> stack = new java.util.LinkedList<>();
		String[] postfixTokens = toPostfix(args);
		for (int i = 0; i < postfixTokens.length; i++) {
			if (postfixTokens[i].matches("[-+*/%]")) {
				BigDecimal rightValue = stack.removeLast();
				BigDecimal leftValue = stack.removeLast();
				stack.add(expressionToOperand(postfixTokens[i], leftValue, rightValue));
			} else {
				stack.add(new BigDecimal(postfixTokens[i]));
			}

		}
		return stack.getLast();
	}
	//
	private static BigDecimal expressionToOperand(String op, BigDecimal leftValue, BigDecimal rightValue) {
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
	//
	private static int priority(String op) {
		return op.matches("[+-]") ? 1 : op.matches("[*/%]") ? 2 : 0;
	}

}

// 中序轉後序
public class Main {
	public static void main(String[] args) {
		// input
		Scanner input = new Scanner(System.in);
		String part1Str = input.nextLine();
		input.close();
		// call Service
		System.out.print(ComputeService.calculate(part1Str).toString());
		System.out.print("\n");

	}

}