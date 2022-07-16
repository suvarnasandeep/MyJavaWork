package DataStructureAlgorithm.LinkedList.CircularLinkedList.ConstructCircularLinkedList;

import DataStructureAlgorithm.LinkedList.Node.Node;

public class CircularLinkedList {
	
	int size = 0;
	Node head;
	Node tail;
	
	public void insertAtStart(int data) {
		
		Node node = new Node(data);
		
		if(size ==0){
			head = node;
			tail = node;
			node.next = head;
		} else {
			Node tmp = head;
			head = node;
			node.next = tmp;
			tail.next = head;
		}
		size++;
	}
	
	public void insertAtEnd(int data) {
		
		if(size == 0){
			insertAtStart(data);
		} else {
			Node node = new Node(data);
			tail.next = node;
			tail = node;
			tail.next = head;
			size++;
		}
	}
	
	public void deleteNodeFromStart() {
		
		head = head.next;
		tail.next = head;
		size--;
	}
	
	public void print() {
		Node tmp = head;
		
		do{
			System.out.print(tmp.data + " -> ");
			tmp = tmp.next;
		} while(tmp!= head);
		System.out.println();
	}

}
