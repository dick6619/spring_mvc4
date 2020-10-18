import java.util.*;

//中序轉後序 
public class Testtt {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String part1Str = input.nextLine();
		input.close();
		StringTokenizer st = new StringTokenizer(part1Str, "-+*/%()", true);
		String[] tokens = new String[st.countTokens()];
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = st.nextToken();
		}
		//
		Stack<String> stack = new Stack<String>();
		List<String> strArr = new ArrayList<String>();
		for (String token : tokens) {
			// 左括號除了優先權最小之外，也不參與權重比較是否要丟出的邏輯，只有在遇到右括號，才會起作用
			if ("(".equals(token)) {
				stack.push(token);
			} else if (token.matches("[-+*/%]")) {
				while (stack.size() != 0 && priority(stack.lastElement()) >= priority(token)) {
					strArr.add(stack.pop());
				}
				stack.push(token);
			} else if (")".equals(token)) {
				while (!"(".equals(stack.lastElement())) {
					strArr.add(stack.pop());
				}
				stack.pop();
			} else {
				// 運算元直接取出
				strArr.add(token);
			}
		}
		// 剩下的依序取出
		while (stack.size() != 0) {
			strArr.add(stack.pop());
		}
		for (int i = 0; i < strArr.size(); i++) {
			if (i != strArr.size() - 1) {
				System.out.print(strArr.get(i) + " ");
			} else {
				System.out.print(strArr.get(i));
			}

		}
		System.out.print("\n");
	}

	/**
	 * 運算子優先級
	 */
	private static int priority(String op) {
		return op.matches("[+-]") ? 1 : op.matches("[*/%]") ? 2 : 0;
	}
}