package DataStructureAlgorithm.LinkedList.SingleLinkedList.ConstructLinkedList;

import DataStructureAlgorithm.LinkedList.Node.Node;
import DataStructureAlgorithm.LinkedList.TestClass;

public class LinkedListOp {

	Node head;
	Node head1;

	public void createList(int data){
		Node tmp = head;
		Node node = new Node(data);

		if(head == null){
			head = node;
		} else {
			while(tmp.next != null){
				tmp = tmp.next;
			}
			tmp.next = node;
		}
	}

	public void printList(String msg){
		System.out.println(msg);
		Node tmp = head;

		while(tmp != null){
			System.out.print(tmp.data + " -> ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public void insertStart(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public void insertEnd(int data) {
		Node tmp = head;

		Node node = new Node(data);

		while(tmp.next != null){
			tmp = tmp.next;
		}

		tmp.next = node;
	}

	public void reverseList() {
		Node curr = head;
		Node next = null;
		Node prev = null;

		while(curr != null){
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public void reverseSecondHalfFromKNode(int k){

		Node firstNode = head;		

		for(int i = 1; i<k; i++){
			firstNode = firstNode.next;			
		}

		Node secondHalf = firstNode.next;
		firstNode.next = null;


		Node next = null;
		Node prev = null;

		while(secondHalf != null){
			next = secondHalf.next;
			secondHalf.next = prev;

			prev = secondHalf;
			secondHalf = next;
		}

		Node res = head;

		while(res.next != null){
			res = res.next;
		}
		res.next = prev;
	}

	public void reverseFirstHalfFromKNode(int k){

		Node firstNode = head;		

		for(int i = 1; i<k; i++){
			firstNode = firstNode.next;			
		}

		Node secondHalf = firstNode.next;
		firstNode.next = null;

		Node start = head;
		Node next = null;
		Node prev = null;

		while(start != null){
			next = start.next;
			start.next = prev;

			prev = start;
			start = next;
		}

		head = firstNode;

		while( firstNode.next != null){
			firstNode = firstNode.next;
		}
		firstNode.next = secondHalf;
	}

	public void reverseFirstHalf() {

		Node slowNode, fastNode;
		slowNode = fastNode = head;

		while(fastNode != null && fastNode.next != null){
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}

		Node secondHalf = slowNode.next;
		slowNode.next = null;

		Node start = head;
		Node next = null;
		Node prev = null;

		while(start != null){
			next = start.next;
			start.next = prev;

			prev = start;
			start = next;
		}
		head = slowNode;

		while( slowNode.next != null){
			slowNode = slowNode.next;
		}
		slowNode.next = secondHalf;
	}

	public void reverseSecondHalf() {

		Node slowNode, fastNode;
		slowNode = fastNode = head;

		while(fastNode != null && fastNode.next != null){
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}

		Node secondHalf = slowNode.next;
		slowNode.next = null;

		Node next = null;
		Node prev = null;

		while(secondHalf != null){
			next = secondHalf.next;
			secondHalf.next = prev;

			prev = secondHalf;
			secondHalf = next;
		}
		Node res = head;
		while(res.next != null){
			res = res.next;
		}
		res.next = prev;		
	}

	public void printNodeFromEnd(int n){
		System.out.println("Element at " + n + "th index from end : ");
		Node firstNode = head;
		Node secNode = head;

		for(int i=1; i<n; i++){
			firstNode = firstNode.next;
		}

		while(firstNode.next != null){
			firstNode = firstNode.next;
			secNode = secNode.next;
		}
		System.out.println(secNode.data);
	}

	public void checkPalindrome(){
		Node slowNode, fastNode;
		slowNode = fastNode = head;

		while(fastNode != null && fastNode.next != null){
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}

		Node secondHalf = slowNode.next;
		slowNode.next = null;

		Node next = null;
		Node prev = null;

		while(secondHalf != null){
			next = secondHalf.next;
			secondHalf.next = prev;
			prev = secondHalf;
			secondHalf = next;
		}

		Node cur = head;
		while(cur != null && prev != null){
			if(cur.data == prev.data){
				cur = cur.next;
				prev = prev.next;
			} else {
				System.out.println("Linkedlist is not palindrome");
				return;
			}
		}
		System.out.println("Linkedlist is palindrome");
	}

	public void printList1(String msg){
		System.out.println(msg);
		Node tmp = head1;

		while(tmp != null){
			System.out.print(tmp.data + " -> ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public void createLoopList(Node node) {

		if(head1 == null){
			head1 = node;
		} else {
			Node tmp = head1;
			while(tmp.next != null){
				tmp = tmp.next;
			}
			tmp.next = node;
		}
	}

	public void checkLoop() {

		Node firstNode = head1;
		Node secNode = head1;

		while(firstNode != null && firstNode.next != null){
			firstNode = firstNode.next.next;
			secNode = secNode.next;

			if(firstNode == secNode){
				System.out.println("Linkedlidt is loop");
				return;
			}
		}

		System.out.println("Linkedlist is not loop");
	}

	public void loopStarting() {
		Node firstNode = head1;
		Node secNode = head1;
		boolean flag = false;

		while(firstNode != null && firstNode.next != null){
			firstNode = firstNode.next.next;
			secNode = secNode.next;

			if(firstNode == secNode){
				flag = true;
				break;
			}
		}

		if(flag){
			firstNode = head1;
			while(firstNode != secNode){
				firstNode = firstNode.next;
				secNode = secNode.next;
			}
			System.out.println("Linkedlist loop point id : " + firstNode.data);

			//length of loop
			int len = 0;
			do{
				firstNode = firstNode.next;
				len++;
			} while(firstNode != secNode);
			System.out.println("length of loop is : " + len);

			//loop removal
			while(firstNode.next != secNode){
				firstNode = firstNode.next;
			}
			firstNode.next = null;

		} else {
			System.out.println("Linkedlist is not loop");
		}
	}

	public void insertAtK(int k, int data) {

		Node firstNode = head;	
		Node node = new Node(data);

		for(int i = 1; i<k; i++){
			firstNode = firstNode.next;			
		}

		node.next = firstNode.next;
		firstNode.next = node;
	}

	private boolean search(int data){
		Node tmp = head;

		while(tmp != null){
			if(tmp.data == data){
				return  true;
			}
			tmp = tmp.next;
		}
		return  false;
	}

	private void deleteNode(int position){
		Node tmp = head;

		if(position == 0){
			head = tmp.next;
		}

		for(int i = 1 ; i < position; i++){
			tmp = tmp.next;
		}

		Node node = tmp.next.next;
		tmp.next = node;

	}

	private void sortList(){
		Node current = head;
		Node index;
		int tmp;

		while(current != null){
			index = current.next;
			while (index != null){
				if(current.data > index.data){
					tmp = current.data;
					current.data = index.data;
					index.data = tmp;
				}
				index = index.next;
			}

			current = current.next;
		}

	}
}
