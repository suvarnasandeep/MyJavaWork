package DataStructureAlgorithm.LinkedList.SingleLinkedList.ConstructLinkedList;

import DataStructureAlgorithm.LinkedList.Node.Node;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedListOp obj = new LinkedListOp();
		
		//create linkedlist
		obj.createList(1);
		obj.createList(2);
		obj.createList(3);
		obj.createList(4);
		obj.createList(5);		
		obj.printList("LinkedList is : ");
		
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
		obj.reverseFirstHalfFromKNode(3);
		obj.printList("Reversed first half from 3rd element : ");
		
		obj.insertAtK(1, 15);
		obj.printList("Inserting element 15 at index 1 : ");
		
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

}
