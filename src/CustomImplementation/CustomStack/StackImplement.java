package CustomStack;

public class StackImplement {
	Node head;
	int size = 0;

	public int getSize() {
		return size;
	}

	public void push(int data) {
		Node node = new Node(data);

		if(getSize() == 0){
			head = node;
		} else{		 
			node.next = head;
			head = node;
		}
		size++;
	}

	public void pop() {

		if(getSize() == 0)
			return;

		Node temp = head;
		head = head.next;
		System.out.println("pop -> " + temp.data);
		size--;
	}

	public void printStack() {
		Node temp = head;

		while(temp != null){
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
}
