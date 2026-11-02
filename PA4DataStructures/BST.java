public class BST {

	protected BSTNode root;
	protected int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(int A[]) {
		root = null;
		size = 0;
		for (int a : A)
			insert(a);
	}

	public BSTNode search(int key) {
		BSTNode tmp = root;
		while (tmp != null) {
			if (tmp.value == key)
				return tmp;
			else if (tmp.value > key)
				tmp = tmp.left;
			else
				tmp = tmp.right;
		}
		return null;
	}

	public BSTNode insert(int val) { // complete this method
		if (size == 0){
			root = new BSTNode(val);
			size++;
			return root;
		}
		else{
			BSTNode tmp = root;
			BSTNode parent = null;
			while (tmp != null){
				if (tmp.value == val){
					return null;
				}
				else if (tmp.value < val){
					parent = tmp;
					tmp = tmp.right;
				}
				else{
					parent = tmp;
					tmp = tmp.left;
				}
			}
			BSTNode newNode = new BSTNode(val);
			newNode.parent = parent;
			if (parent.value > val){
				parent.left = newNode;
			}
			else{
				parent.right = newNode;
			}
			size++;
			return newNode;
		}
	}

	public boolean remove(int val) { // complete this method
		BSTNode noteToBeDeleted = search(val);
		if (noteToBeDeleted == null){
			return false;
		}
		else if ((noteToBeDeleted.left != null) && (noteToBeDeleted.right != null)){
			BSTNode max = findMax(noteToBeDeleted.left);
			noteToBeDeleted.value = max.value;
			noteToBeDeleted = max;
		}
		else if ((noteToBeDeleted.left == null) && (noteToBeDeleted.right == null)){
			removeLeaf(noteToBeDeleted);
		}
		else{
			removeNodeWithOneChild(noteToBeDeleted);
		}
		size--;
		return true;
	}

	private void removeLeaf(BSTNode leaf) { // complete this method
		if (leaf == root){
			root = null;
		}
		else{
			BSTNode parent = leaf.parent;
			if (parent.left == leaf){
				parent.left = null;
			}
			else{
				parent.right = null;
			}
		}
	}

	private void removeNodeWithOneChild(BSTNode node) { // complete this method
		BSTNode child;
		if (node.left != null){
			child = node.left;
			node.left = null;
		}
		else{
			child = node.right;
			node.right = null;
		}

		if (root == node){
			root = child;
			child.parent = null;
		}
		else{
			if (node.parent.left == node){
				node.parent.left = child;
			}
			else{
				node.parent.right = child;
			}
			child.parent = node.parent;
		}
		
	}

	public int getPredecessor(int key) { // complete this method
		BSTNode tmp = root;
		int pred = Integer.MIN_VALUE;
		while (tmp != null){
			if (tmp.value == key){
				return key;
			}
			else if (tmp.value < key){
				pred = tmp.value;
				tmp = tmp.right;
			}
			else tmp = tmp.left;
		}
		return pred;
	}

	public int getSuccessor(int key) { // complete this method
		BSTNode tmp = root;
		int pred = Integer.MAX_VALUE;
		while (tmp != null){
			if (tmp.value == key){
				return key;
			}
			else if (tmp.value > key){
				pred = tmp.value;
				tmp = tmp.left;
			}
			else tmp = tmp.right;
		}
		return pred;
	}

	public int nearestNeighbour(int key) throws Exception { // complete this method
		int pred = getPredecessor(key);
		int succ = getSuccessor(key);
		if (pred == Integer.MIN_VALUE){
			return succ;
		}
		else if (succ == Integer.MAX_VALUE){
			return pred;
		}
		else{
			int pdist = key - pred;
			int sdist = succ - key;
			if (pdist >= sdist){
				return succ;
			}
			else return pred;
		}
	}

	private static BSTNode findMin(BSTNode node) {
		if (null == node)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static BSTNode findMax(BSTNode node) {
		if (null == node)
			return null;
		while (node.right != null)
			node = node.right;
		return node;
	}

	private static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private void print(BSTNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	public void print() {
		print(root);
	}

	public int getSize() {
		return size;
	}
}
