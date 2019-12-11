
public class ArrayLists<T> {

	private Object[] objs;
	private int size;
	private int maxSize = 4;

	public ArrayLists() {
		objs = new Object[maxSize];
	}

	public ArrayLists(int maxSize) {
		this.maxSize = maxSize;
		objs = new Object[this.maxSize];
	}

	//
	public void add(T obj) {
		objs[size] = obj;
		size++;
	}

	//
	public T get(int index) {
		return (T) objs[index];
	}

	//
	public void remove(int index) {
		if (index + 1 == maxSize) {
			objs[index] = null;
		} else {
			for (int i = index; i < size; i++) {
				objs[i] = objs[i + 1];
			}
		}
		size--;
	}

	// 
	public void insert(int index, T obj) {
		if (index + 1 == maxSize) {
			objs[index] = obj;
		} else {
			for (int i = size - 1; i >= index; i--) {
				objs[i + 1] = objs[i];
			}
			objs[index] = obj;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		ArrayLists<String> array = new ArrayLists<>();
		array.add("蔡G");
		array.add("拉G");
		array.add("GG");
		array.insert(1, "大GG");
		System.out.println(array.get(2));
	}

}
