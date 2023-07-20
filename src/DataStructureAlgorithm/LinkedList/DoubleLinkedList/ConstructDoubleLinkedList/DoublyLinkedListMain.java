package DataStructureAlgorithm.LinkedList.DoubleLinkedList.ConstructDoubleLinkedList;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		DoublyLinkedList obj = new DoublyLinkedList();
		
//		obj.insertAtEnd(1);
//		obj.insertAtEnd(2);
//		obj.insertAtEnd(3);
//		obj.insertAtEnd(4);
//		obj.insertAtEnd(5);
//		obj.print();
//
//		obj.insertAtStart(0);

		obj.createDLL(1);
		obj.print();
		obj.insertDLL(2,0);
		obj.print();
		obj.insertDLL(3,0);
		obj.print();
		obj.insertDLL(4,10);
		obj.print();
		obj.insertDLL(5,10);
		obj.print();
		obj.insertDLL(10,2);
		obj.print();
		obj.deleteDLL(0);
		obj.print();
		obj.deleteDLL(10);
		obj.print();
		obj.deleteDLL(2);
		obj.print();

	}

}
