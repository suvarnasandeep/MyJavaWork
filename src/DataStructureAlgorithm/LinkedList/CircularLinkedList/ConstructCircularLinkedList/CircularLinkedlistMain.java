package LinkedList.CircularLinkedList.ConstructCircularLinkedList;

public class CircularLinkedlistMain {

	public static void main(String[] args) {
		CircularLinkedList obj = new CircularLinkedList();
		
		obj.insertAtEnd(1);
		obj.insertAtEnd(2);
		obj.insertAtEnd(3);
		obj.insertAtEnd(4);
		obj.insertAtEnd(5);		
		obj.print();
		
		obj.insertAtStart(0);
		obj.print();
		
		obj.deleteNodeFromStart();
		obj.print();

	}

}
