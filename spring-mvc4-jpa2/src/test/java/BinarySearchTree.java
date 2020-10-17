
class TreeNode {

	private TreeNode left;
	private TreeNode right;
	private int key;

	public TreeNode(int key) {
		this.key = key;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}

public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	void insert(int key) {
		if (this.root == null) {
			this.root = new TreeNode(key);
		} else {
			// recursive
			insert(this.root, key);
		}
	}

	// recursive
	void insert(TreeNode root, int key) {
		// node < root key
		if (root.getKey() > key) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode(key));
			} else {
				insert(root.getLeft(), key);
			}
		}

		// node >= root key
		else if (root.getKey() <= key) {
			if (root.getRight() == null) {
				root.setRight(new TreeNode(key));
			} else {
				insert(root.getRight(), key);
			}
		}
	}

	void traverseInOrder(TreeNode node) {

		if (node == null) {
			System.out.println();
		} else {
			// L
			if (node.getLeft() != null) {
				traverseInOrder(node.getLeft());
			}
			// D
			System.out.print(node.getKey() + ",");
			// R
			if (node.getRight() != null) {
				traverseInOrder(node.getRight());
			}
		}
	}

	void traverseInOrderByLoop(TreeNode node) {


	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(7);
		bst.insert(5);
		bst.insert(15);
		bst.insert(44);
		bst.insert(30);
		bst.traverseInOrder(bst.getRoot());

	}

}
