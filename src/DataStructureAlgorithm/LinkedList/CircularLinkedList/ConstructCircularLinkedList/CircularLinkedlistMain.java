package DataStructureAlgorithm.LinkedList.CircularLinkedList.ConstructCircularLinkedList;

public class CircularLinkedlistMain {

	public static void main(String[] args) {
		CircularLinkedList obj = new CircularLinkedList();
		
//		obj.insertAtEnd(1);
//		obj.insertAtEnd(2);
//		obj.insertAtEnd(3);
//		obj.insertAtEnd(4);
//		obj.insertAtEnd(5);
//		obj.print();
//
//		obj.insertAtStart(0);
//		obj.print();
//
//		obj.deleteNodeFromStart();
//		obj.print();

		obj.createCSLL(1);
		obj.print();
		obj.insertCSLL(2,1);
		obj.print();
		obj.insertCSLL(3,1);
		obj.insertCSLL(4,1);
		obj.print();
		obj.insertCSLL(5,10);
		obj.print();
		obj.insertCSLL(50,2);
		obj.print();
		System.out.println(obj.tail.next.data);

	}

}
