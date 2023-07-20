package DataStructureAlgorithm.LinkedList.Problems;

import DataStructureAlgorithm.LinkedList.Node.Node;

public class ProblemMain {
    public static void main(String[] args) {
        RemoveDuplicatesSLL obj = new RemoveDuplicatesSLL();
        obj.createSLL(1);
        obj.insertSLL(2);
        obj.insertSLL(1);
        obj.insertSLL(4);
        obj.insertSLL(5);
        obj.insertSLL(4);
        NodeSLL node = obj.insertSLL(3);
        obj.print(node);
        obj.deleteDups(node);
    }
}
