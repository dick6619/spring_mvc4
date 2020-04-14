
public class ArrList<T> {

	private Object[] objs;
	private int size;
	private int maxSize = 10;

	public ArrList() {
		objs = new Object[maxSize];
	}

	public ArrList(int maxSize) {
		this.maxSize = maxSize;
		objs = new Object[this.maxSize];
	}

	public void add(T obj) {
		objs[size] = obj;
		size++;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) objs[index];
	}

	public void remove(int index) {
		// 最後一個直接刪除
		if (index + 1 == maxSize) {
			objs[index] = null;
		} else {
			// 從刪除的位置開始，後面的元素都要往前搬動
			for (int i = index; i < size; i++) {
				// max size的位置 是special case
				if (i + 1 < maxSize) {
					objs[i] = objs[i + 1];
				} else {
					objs[i] = null;
				}
			}
		}
		size--;
	}

	public void insert(int index, T obj) {
		if (index + 1 == maxSize) {
			objs[index] = obj;
		} else {
			// 插入位置的後面元素(包含原本元素)要往後移動
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
		ArrList<String> array = new ArrList<>();
		array.add("0");
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4");
		array.add("5");
		array.add("6");
		array.add("7");
		array.add("8");
		array.add("9");
		array.remove(3);
		array.remove(0);

		for (int i = 0; i < 10; i++) {
			System.out.print(array.get(i) + ", ");
		}
		
	}

}
