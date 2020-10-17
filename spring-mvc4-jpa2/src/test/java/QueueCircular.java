import java.util.ArrayList;
import java.util.List;

public class QueueCircular<T> {

	private List<T> list;
	private int size;
	private int front;
	private int rear;
	private final int DEFFAULT_SIZE = 5;

	public QueueCircular() {
		front = 0;
		rear = 0;
		list = new ArrayList<T>(DEFFAULT_SIZE);
		for (int i = 0; i < DEFFAULT_SIZE; i++) {
			list.add(i, null);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == DEFFAULT_SIZE;
	}

	public int size() {
		return size;
	}

	public void push(T element) {
		if (isFull()) {
			throw new RuntimeException("queue is full, please pop 1 element");
		}
		rear = (rear + 1) % DEFFAULT_SIZE;
		list.set(rear, element);
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty, so its cant pop");
		}
		front = (front + 1) % DEFFAULT_SIZE;
		T element = list.get(front);
		list.set(front, null);
		size--;
		return element;
	}

	public String print() {
		return list.toString();
	}

	public static void main(String[] args) {

		QueueCircular<String> que = new QueueCircular<>();
		que.push("1");
		System.out.println(que.print());
		que.push("2");
		que.push("3");
		que.push("4");
		System.out.println(que.print());
		que.push("5");
		System.out.println(que.print());
		que.pop();
		System.out.println(que.print());
	}
}
