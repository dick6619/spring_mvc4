
class BstNode<T> {

	private BstNode<T> left;
	private BstNode<T> right;
	private int key;
	private T value;

	public BstNode(int key, T value) {
		this.key = key;
		this.value = value;
	}

	public BstNode<T> getLeft() {
		return left;
	}

	public void setLeft(BstNode<T> left) {
		this.left = left;
	}

	public BstNode<T> getRight() {
		return right;
	}

	public void setRight(BstNode<T> right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}

public class BST_2<T> {

	private BstNode<T> root;

	void delete(int key) {

	}

	T search(int key) {
		if (this.root == null) {
			return null;
		} else {
			return search(this.root, key);
		}
	}

	// recursive
	T search(BstNode<T> root, int key) {
		if (root.getKey() > key) {
			return root.getLeft() == null ? null : search(root.getLeft(), key);
		} else if (root.getKey() < key) {
			return root.getRight() == null ? null : search(root.getRight(), key);
		} else {
			return root.getValue();
		}
	}

	void insert(BstNode<T> node) {

		if (this.root == null) {
			this.root = node;
		} else {
			insert(this.root, node);
		}
	}

	// recursive
	void insert(BstNode<T> root, BstNode<T> node) {
		if (root.getKey() > node.getKey()) {

			if (root.getLeft() == null) {
				root.setLeft(node);
			} else {
				insert(root.getLeft(), node);
			}
		}
		if (root.getKey() <= node.getKey()) {
			if (root.getRight() == null) {
				root.setRight(node);
			} else {
				insert(root.getRight(), node);
			}
		}

	}

	void printInOrder(BstNode<T> root) {
		if (root.getLeft() != null) {
			printInOrder(root.getLeft());
		}
		System.out.print(root.getKey() + " ");
		if (root.getRight() != null) {
			printInOrder(root.getRight());
		}
	}

	void printPreOrder(BstNode<T> root) {
		System.out.print(root.getKey() + " ");
		if (root.getLeft() != null) {
			printInOrder(root.getLeft());
		}
		if (root.getRight() != null) {
			printInOrder(root.getRight());
		}
	}

	void printPostOrder(BstNode<T> root) {
		if (root.getLeft() != null) {
			printInOrder(root.getLeft());
		}
		if (root.getRight() != null) {
			printInOrder(root.getRight());
		}
		System.out.print(root.getKey() + " ");
	}

	public BstNode<T> getRoot() {
		return root;
	}

	public static void main(String[] args) {
		BST_2<String> bst = new BST_2<>();
		bst.insert(new BstNode<>(20, "209"));
		bst.insert(new BstNode<>(7, "79"));
		bst.insert(new BstNode<>(5, "59"));
		bst.insert(new BstNode<>(15, "159"));
		bst.insert(new BstNode<>(44, "449"));
		bst.insert(new BstNode<>(30, "309"));
		bst.printInOrder(bst.getRoot());
		System.out.println();
		bst.printPreOrder(bst.getRoot());
		System.out.println();
		bst.printPostOrder(bst.getRoot());
		System.out.println();
		System.out.println(bst.search(2));
	}

}
