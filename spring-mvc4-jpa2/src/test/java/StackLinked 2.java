import java.util.LinkedList;
import java.util.List;

public class StackLinked<T> {

	List<T> list;

	public StackLinked() {
		list = new LinkedList<T>();
	}

	/**
	 * 1. 表示成從右邊放進去，左邊是Top最後放的元素，與Array相反<br>
	 * 2. 如是從左邊放進去，每次放都需要找到最後一個元素<br>
	 * 3. 只要將指標指向新放入的元素即可<br>
	 */
	void push(T element) {
		list.add(0, element);
	}

	T pop() {
		if (list.size() != 0) {
			return list.remove(0);
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLinked<Integer> st = new StackLinked<>();
		st.push(1);
	}

}
