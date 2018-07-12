public class MyDoublyLL {

	public int count;
	public boolean error;
	
	public MyDoublyLL() {
	}
	
	public void insert(Node givenNode, Node test1) {
		if (test1 == null) {
			error = true;
		}
		else {
			if (givenNode == null) {
				error = true;
			}
			else {
				Node nextNode = givenNode.getNextNode();
				givenNode.setNextNode(test1);
				
				test1.setPrevNode(givenNode);
				test1.setNextNode(nextNode);
				
				nextNode.setPrevNode(test1);
				count++;
			}
		}
	}
	
	public void addRoot(Node root) {
		if (root == null) {
			error = true;
		}
		else {
			root.setNextNode(root);
			root.setPrevNode(root);
			count++;			
		}
	}
	
	public void add(Node root, Node test1) {
		if (test1 == null || root.getNextNode() == null) {
			error = true;
		}
		else {
		if (root.getNextNode() == root) {
			root.setNextNode(test1);
			root.setPrevNode(test1);
			test1.setPrevNode(root);
			test1.setNextNode(root);
			count++;
		}
		else {
			Node currNode = root;
			while (currNode.getNextNode() != root) {
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(test1);
			test1.setNextNode(root);
			test1.setPrevNode(currNode);
			root.setPrevNode(test1);
			count++;
		}
		}
	}
	
	public void removeNode(Node root) {
		if (root == null) {
			error = true;
		}
		else {
			if (root.getNextNode() == root) {
				root = null;
				count--;				
			}
			else {
				Node currNode = root;
				while (currNode.getNextNode() != root) {
					currNode = currNode.getNextNode();
				}
				// currNode.getNextNode() should be null
				currNode.setNextNode(root);
				root.setPrevNode(currNode);
				count--;
			}
		}
	}
	
	public boolean contains(Node root, Node node) {
		Node currNode = root;
		if (node == root) {
			return true;
		}
		while (currNode.getNextNode() != null) {
			if (currNode == node) {
				return true;
			}
			else {
				currNode = currNode.getNextNode();						
			}
		}
		if (currNode == node) {
			return true;
		}
		return false;
	}
	
	public boolean error() {
		return error;
	}
	
	public int length() {
		return count;
	}
}
