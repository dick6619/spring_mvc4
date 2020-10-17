
class LinkedList2<T> {

	private Node2<T> firstNode;
	private int size;
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

	public void insert(int index, T obj) {
		if (index == 0 && firstNode == null) {
			firstNode.setObj(obj);
			size++;
		}
		
		if (index == 0 && firstNode != null) {
			Node2<T> insertNode = new Node2<T>(obj);
			insertNode.setNextNode(firstNode);
			firstNode = insertNode;
			size++;
		}
		
		if (firstNode != null) {
			Node2<T> preNode = firstNode;
			for (int i = 0; i < index - 1; i++) {
				preNode = preNode.getNextNode();
			}
			Node2<T> insertNode = new Node2<T>(obj);
			insertNode.setNextNode(preNode.getNextNode());
			preNode.setNextNode(insertNode);
			size++;
		}
	}

	public void remove(int index) {

		if (index == 0) {
			firstNode = firstNode.getNextNode();
			size--;
		}
		Node2<T> deleteNode = firstNode;
		for (int i = 0; i < index - 1; i++) {
			deleteNode = deleteNode.getNextNode();
		}
		deleteNode.setNextNode(deleteNode.getNextNode().getNextNode());
		size--;

	}

	public void add(T obj) {

		if (firstNode == null) {
			firstNode = new Node2<T>(obj);

		} else {
			Node2<T> linkedNode = firstNode;
			while (linkedNode.getNextNode() != null) {
				linkedNode = linkedNode.getNextNode();
			}
			linkedNode.setNextNode(new Node2<T>(obj));
		}
		size++;
	}

	public T get(int index) {
		if (index == 0) {
			return firstNode.getObj();
		}
		Node2<T> resultNode = firstNode;

		for (int i = 0; i < index; i++) {
			resultNode = resultNode.getNextNode();
		}
		return resultNode.getObj();
	}

}

// JAVA<T> 相當於C 宣告template<class T>掛於方法或類別前代表此類別或方法有個還不確定的型態T物件
class Node2<T> {
	private T obj;
	private Node2<T> nextNode;

	public Node2(T obj) {
		this.obj = obj;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}


	public Node2<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node2<T> nextNode) {
		this.nextNode = nextNode;
	}

}

public class LinkedListTest2 {

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		list.add("蔡Yu"); // 0
		list.add(1); // 2
		list.add("緒Dick"); // 3
		list.add("遊戲王"); // 4
		// list.remove(0);
		list.insert(1, 87);
		System.out.println(list.get(1));

	}

}
