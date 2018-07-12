public class MyDoublyLL {

	public int count;
	public boolean error;
	
	public static void main(String[] args) {
		MyDoublyLL dll = new MyDoublyLL();
		Node root = new Node();
		root.setData("tree");
		Node node1 = new Node();
		node1.setData("of");
		Node node2 = new Node();
		node2.setData("peaches");
		
		dll.addRoot(root);
		dll.add(root, node1);
		dll.add(root, node2);
		
		dll.traverse(root);
	}
	
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
	
	public void traverse(Node root) {
		Node currNode = root;
		while (currNode.getNextNode() != root) {
			System.out.println("node: " + currNode.getData());
			currNode = currNode.getNextNode();
		}
		System.out.println("last node: " + currNode.getData());
	}
	
	public boolean error() {
		return error;
	}
	
	public int length() {
		return count;
	}
}
