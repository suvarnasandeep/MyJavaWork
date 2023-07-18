package DataStructureAlgorithm.LinkedList.SingleLinkedList.ConstructLinkedList;

import DataStructureAlgorithm.LinkedList.Node.Node;
import DataStructureAlgorithm.LinkedList.TestClass;

public class LinkedListOp {

	static Node head;
	Node head1;
	Node tail;
	int size;

	public static void main(String[] args) {
		LinkedListOp obj = new LinkedListOp();

//		obj.createSLL(1);
//		obj.insertSLL(2,0);
//		obj.insertSLL(3,5);
//		obj.insertSLL(6,2);
//		obj.insertSLL(7,1);
//		obj.printList("SLL");

		//create linkedlist
		obj.createList(1);
		obj.createList(2);
		obj.createList(3);
		obj.createList(4);
		obj.createList(5);
		//obj.createList(6);
		obj.printList("LinkedList is : ");

		//obj.deleteOnlyNode(head.next.next);
		obj.rotateListByK(2);
		obj.printList("list");
		//obj.deleteNode(2);
		//obj.deleteKNodefromEnd(4);
		//obj.printList("LinkedList is : ");
//
		//print kth node from end
		//obj.printNodeFromEnd(4);

		//insert node at start
		//obj.insertStart(0);
		//obj.printList("Inserting element 0 at start : ");

		//insert node at end
		//obj.insertEnd(6);
		//obj.printList("Inserting element 6 at end : ");

		//reverse linkedlist
		//obj.reverseList();
		//obj.printList("Reversed LinkedList : ");

		//reverse second half of linkedlist
		//obj.reverseSecondHalf();
		//obj.printList("Reversed Second half : ");

		//reverse first half of linkedlist
		//obj.reverseFirstHalf();
		//obj.printList("Reversed First half : ");

		//reverse second half of linkedlist from kth node
		//obj.reverseSecondHalfFromKNode(3);
		//obj.printList("Reversed second half from 3rd element : ");

		//reverse first half of linkedlist from kth node
//		obj.reverseFirstHalfFromKNode(3);
//		obj.printList("Reversed first half from 3rd element : ");
//
//		obj.insertAtK(1, 15);
//		obj.printList("Inserting element 15 at index 1 : ");
//
		//check linkedlist palindrome
		//obj.checkPalindrome();

		// check loop in linkedlist
		/*obj.createLoopList(new Node(1));
		obj.createLoopList(new Node(2));
		Node loopNode = new Node(3);
		obj.createLoopList(loopNode);
		obj.createLoopList(new Node(4));
		obj.createLoopList(new Node(5));
		obj.createLoopList(new Node(6));
		obj.createLoopList(new Node(7));
		obj.createLoopList(loopNode);

		//obj.printList1("");

		obj.checkLoop();
		obj.loopStarting();
		obj.checkLoop();*/


	}

	//create single linked list O(1)
	public void createSLL(int val){
		Node node = new Node(val);
		head = node;
		tail = node;
		size = 1;
	}

	//O(N)
	//insert at beginning - O(1)
	//insert at end - O(1)
	//insert at middle - O(N)
	public void insertSLL(int val, int location){
		Node node = new Node(val);

		if (head == null) {
			createSLL(val);
			return;
		} else if (location == 0){		//insert at beginning
			node.next = head;
			head = node;
		} else if (location >= size){	//insert at end
			tail.next = node;
			tail = node;
		} else {						//insert at middle
			Node tmpNode = head;
			int index=0;
			while(index < location - 1){
				tmpNode = tmpNode.next;
				index++;
			}
			Node nextNode = tmpNode.next;
			tmpNode.next = node;
			node.next = nextNode;
		}
		size++;
	}

	//O(N)
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

	//O(1)
	public void insertStart(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	//O(N)
	public void insertEnd(int data) {
		Node tmp = head;
		Node node = new Node(data);

		while(tmp.next != null){
			tmp = tmp.next;
		}

		tmp.next = node;
	}

	//O(N)
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

	//O(N)
	public void deleteNode(int position){
		Node tmp = head;

		if(position == 0){
			head = tmp.next;
			return;
		}

		for(int i = 1 ; i < position; i++){
			tmp = tmp.next;
		}

		Node node = tmp.next.next;
		tmp.next = node;
	}

	//O(N)
	public void deleteKNodefromEnd(int position){
		Node node1,node2;
		node1 = node2 = head;
		for(int i=0; i<position; i++){
			node1 = node1.next;
		}
		while (node1.next != null){
			node1 = node1.next;
			node2 = node2.next;
		}
		Node node = node2.next.next;
		node2.next = node;


	}

	//delete node when only node is given
	//No head given
	public void deleteOnlyNode(Node node){
		node.data = node.next.data;
		node.next = node.next.next;
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

	//https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=13
	public void rotateListByK(int k){
		int len = 0;
		Node node = head;
		while (node.next != null){
			node = node.next;
			len++;
		}
		k= k % len;
		node.next = head;

		Node tmp = head;
		for(int i=0; i<len-k;i++){
			tmp = tmp.next;
		}
		head = tmp.next;
		tmp.next = null;
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

}
