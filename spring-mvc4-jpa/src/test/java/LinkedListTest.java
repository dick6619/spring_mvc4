
class LinkedList {

	private Node firstNode;
	private int size;
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

	public void insert(int index, String name) {
		if (index == 0 && firstNode == null) {
			firstNode.setName(name);
			size++;
		}
		
		if (index == 0 && firstNode != null) {
			Node insertNode = new Node(name);
			insertNode.setNextNode(firstNode);
			firstNode = insertNode;
			size++;
		}
		
		if (firstNode != null) {
			Node preNode = firstNode;
			for (int i = 0; i < index - 1; i++) {
				preNode = preNode.getNextNode();
			}
			Node insertNode = new Node(name);
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
		Node deleteNode = firstNode;
		for (int i = 0; i < index - 1; i++) {
			deleteNode = deleteNode.getNextNode();
		}
		deleteNode.setNextNode(deleteNode.getNextNode().getNextNode());
		size--;

	}

	public void add(String name) {

		if (firstNode == null) {
			firstNode = new Node(name);

		} else {
			Node linkedNode = firstNode;
			while (linkedNode.getNextNode() != null) {
				linkedNode = linkedNode.getNextNode();
			}
			linkedNode.setNextNode(new Node(name));
		}
		size++;
	}

	public String get(int index) {
		if (index == 0) {
			return firstNode.getName();
		}
		Node resultNode = firstNode;

		for (int i = 0; i < index; i++) {
			resultNode = resultNode.getNextNode();
		}
		return resultNode.getName();
	}

}

class Node {
	private String name;
	private Node nextNode;

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

}

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		list.add("蔡Yu"); // 0
		list.add("陳Tim"); // 2
		list.add("緒Dick"); // 3
		list.add("遊戲王"); // 4
		// list.remove(0);
		list.insert(10, "海馬王");
		System.out.println(list.get(4));

	}

}
