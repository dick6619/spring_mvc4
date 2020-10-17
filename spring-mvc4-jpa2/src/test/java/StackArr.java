import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackArr<T> implements Iterable<T> {
	List<T> list;

	public StackArr() {
		list = new ArrayList<T>(10);
	}

	void push(T element) {
		list.add(element);
	}

	T pop() {
		if (list.size() > 0) {
			return list.remove(list.size() - 1);
		} else {
			return null;
		}
	}


	boolean isEmpty() {
		return list.size() == 0;
	}

	int size() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArr<Integer> stackArr = new StackArr<>();
		stackArr.push(10);
		stackArr.push(11);
		stackArr.push(12);

	}

}
