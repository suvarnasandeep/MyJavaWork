package DataStructureAlgorithm.LinkedList.DoubleLinkedList.ConstructDoubleLinkedList;

public class DoublyLinkedList {

	int size = 0;
	Node head;
	Node tail;
	
	public void insertAtStart(int data) {
		
		Node node = new Node(data);
		
		if(size == 0){
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;		
	}
	
	public void insertAtEnd(int data) {
		
		Node node = new Node(data);
		
		if(size == 0){
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}
	
	public void print() {
		Node tmp = head;
		
		while(tmp != null){
			System.out.print(tmp.data + " -> ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}
