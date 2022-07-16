package LinkedList.DoubleLinkedList.ConstructDoubleLinkedList;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		DoublyLinkedList obj = new DoublyLinkedList();
		
		obj.insertAtEnd(1);
		obj.insertAtEnd(2);
		obj.insertAtEnd(3);
		obj.insertAtEnd(4);
		obj.insertAtEnd(5);
		obj.print();
		
		obj.insertAtStart(0);
		obj.print();

	}

}
