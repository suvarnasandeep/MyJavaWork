package DataStructureAlgorithm.LinkedList;

public class TestClass {

    Node head;

    class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
            next = null;
        }
    }


    public static void main(String[] args) {

        TestClass obj = new TestClass();
        obj.createList(10);
        obj.createList(2);
        obj.createList(3);
        obj.createList(7);

        obj.printList();

        obj.insertAtBegining(33);
        obj.insertAtBegining(3);
        obj.printList();
        obj.insertAtEnd(50);
        obj.insertAtEnd(51);
        obj.printList();

        obj.insertAtK(2,22);
        obj.insertAtK(4,44);
        obj.printList();

        System.out.println(obj.search(2));

        obj.deleteNode(3);
        obj.printList();

        obj.sortList();
        obj.printList();

    }

    private void createList(int i) {
         Node node = new Node(i);
         Node tmp = head;
         if(head == null){
             head = node;
         } else {
             while(tmp.next != null){
                 tmp = tmp.next;
             }
             tmp.next = node;
         }
    }

    private void printList() {

        Node tmp = head;
        System.out.print("[ ");
        while (tmp != null){
            System.out.print(tmp.data + "-> ");
            tmp = tmp.next;
        }
        System.out.println(" ]");
    }

    private void insertAtBegining(int data){

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private void insertAtEnd(int data){
        Node node = new Node(data);
        Node tmp = head;

        while (tmp.next != null){
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    private  void insertAtK(int pos, int data){
        Node tmp = head;
        Node node = new Node(data);
        for(int i=1; i<pos; i++){
            tmp = tmp.next;
        }

        node.next = tmp.next;
        tmp.next = node;
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
