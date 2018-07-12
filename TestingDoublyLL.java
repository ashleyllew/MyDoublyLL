import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestingDoublyLL {

	@Test
	public void initialList() {
		MyDoublyLL newList = new MyDoublyLL();
		int count = newList.length();
		assertEquals(count, 0);
	}
	
	@Test
	public void addNode() {		
		MyDoublyLL list = new MyDoublyLL();
		Node root = new Node();
		root.setData("hello");
		list.addRoot(root);
		int count = list.length();
		assertEquals(count, 1);
	}
	
	@Test
	public void removeTwoNodes() {
		MyDoublyLL list = new MyDoublyLL();
		Node root = new Node();
		root.setData("hello");
		list.addRoot(root);
		
		Node node1 = new Node();
		root.setData("world");
		list.add(root, node1);
		
		int count = list.length();
		assertEquals(count, 2);
		list.removeNode(root);
		list.removeNode(root);
		count = list.length();
		assertEquals(count, 0);
	}
	
	@Test
	public void removeOneNode() {
		MyDoublyLL list = new MyDoublyLL();
		Node root = new Node();
		root.setData("hello");
		list.addRoot(root);
		
		int count = list.length();
		assertEquals(count, 1);
		list.removeNode(root);
		count = list.length();
		assertEquals(count, 0);
	}
	
	@Test
	public void insertNode() {
		MyDoublyLL list = new MyDoublyLL();

		Node root = new Node();
		root.setData("peach");
		
		Node node1 = new Node();
		node1.setData("grows");
		
		Node node2 = new Node();
		
		node2.setData("tree");
		list.addRoot(root);
		list.add(root, node2);
		
		list.insert(node2, node1);
		assertEquals(list.length(), 3);
	}
	
	@Test
	public void containsNode() {
		MyDoublyLL list = new MyDoublyLL();

		Node root = new Node();
		root.setData("peach");
		
		Node node1 = new Node();
		node1.setData("grows");
		
		Node node2 = new Node();
		node2.setData("tree");

		list.addRoot(root);
		list.add(root, node1);
		list.add(root, node2);
		
		boolean contains = list.contains(root, root);
		contains = list.contains(root, node2);
		contains = list.contains(root, node1);
		assertEquals(contains, true);	
	}
	
	@Test
	public void doesNotContainNode() {
		MyDoublyLL list = new MyDoublyLL();

		Node root = new Node();
		root.setData("peach");
		
		Node node1 = new Node();
		node1.setData("grows");
		
		Node node2 = new Node();
		node2.setData("tree");
		
		list.add(root, node1);
		
		boolean contains = list.contains(root, node2);
		assertEquals(contains, false);	
	}

	
	@Test
	public void nullNodeAdd() {
		Node root = new Node();
		Node node1 = null;
		MyDoublyLL list = new MyDoublyLL();
		list.addRoot(root);
		list.add(root, node1);
		
		boolean error = list.error();
		assertEquals(error, true);
	}
	
	@Test
	public void addNullRoot() {
		Node root = null;
		MyDoublyLL list = new MyDoublyLL();
		list.addRoot(root);
		
		boolean error = list.error();
		assertEquals(error, true);
	}

	
	@Test
	public void nullNodeInsert() {
		Node node1 = new Node();
		Node node2 = null;
		
		MyDoublyLL list = new MyDoublyLL();
		list.insert(node1, node2);
		
		boolean error = list.error();
		assertEquals(error, true);
	}
	
	@Test
	public void nullGivenNodeInsert() {
		Node node1 = null;
		Node node2 = new Node();
		
		MyDoublyLL list = new MyDoublyLL();
		list.insert(node1, node2);
		
		boolean error = list.error();
		assertEquals(error, true);
	}
	
	@Test
	public void bothNullInsert() {
		Node node1 = null;
		Node node2 = null;
		
		MyDoublyLL list = new MyDoublyLL();
		list.insert(node1, node2);
		
		boolean error = list.error();
		assertEquals(error, true);
	}
	
	@Test
	public void removeFromEmptyList() {		
		MyDoublyLL list = new MyDoublyLL();
		list.removeNode(null);
		
		boolean error = list.error();
		assertEquals(error, true);
	}
	
	@Test
	public void removeRootNode() {		
		MyDoublyLL list = new MyDoublyLL();
		Node root = new Node();
		list.addRoot(root);
		int count = list.length();
		assertEquals(count, 1);
		list.removeNode(root);
		count = list.length();
		assertEquals(count, 0);
	}	
}
