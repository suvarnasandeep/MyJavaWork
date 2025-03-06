package DataStructureAlgorithm.LinkedList.DoubleLinkedList.ConstructDoubleLinkedList;

public class DoublyLinkedList {

	int size = 0;
	Node head;
	Node tail;

	public void createDLL(int data){
		Node node = new Node(data);
		head = node;
		tail = node;
		size++;
	}

	public void insertDLL(int val, int location){
		Node node = new Node(val);
		if(size == 0){
			createDLL(val);
			return;
		} else if(location == 0){
			node.next = head;
			head.prev = node;
			head = node;
		} else if(location >= size){
			node.prev = tail;
			tail.next = node;
			tail=node;
		} else {
			Node tmp = head;
			int index=0;
			while(index < location-1){
				tmp = tmp.next;
				index++;
			}
			node.next = tmp.next;
			tmp.next.prev = node;
			node.prev = tmp;
			tmp.next = node;

		}
		size++;
	}

	public void deleteDLL(int location){
		if(location == 0){
			if(size == 1){
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
		} else if(location >= size){
			tail = tail.prev;
			tail.next = null;
		} else {
			Node tmp = head;
			int index = 0;
			while (index < location-1){
				tmp = tmp.next;
				index++;
			}

			tmp.next = tmp.next.next;
			tmp.next.prev = tmp;

		}
		size--;
	}
	
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
