package DataStructureAlgorithm.LinkedList.CircularLinkedList.ConstructCircularLinkedList;

import DataStructureAlgorithm.LinkedList.Node.Node;

public class CircularLinkedList {
	
	int size = 0;
	Node head;
	Node tail;

	public void createCSLL(int val){
		Node node = new Node(val);
		head = node;
		tail = node;
		node.next = head;
		size++;
	}

	public void insertCSLL(int val, int location){
		Node node = new Node(val);
		if(head == null){
			createCSLL(val);
			return;
		}
		if(location == 1){
			node.next = head;
			head = node;
			tail.next = node;
		} else if(location >= size){
			tail.next = node;
			node.next = head;
			tail = node;
		} else {
			Node tmp = head;
			for(int i=0; i<location-1; i++){
				tmp = tmp.next;
			}
			node.next = tmp.next;
			tmp.next = node;
		}
		size++;
	}
	
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
