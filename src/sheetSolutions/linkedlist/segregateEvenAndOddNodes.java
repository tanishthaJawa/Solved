package sheetSolutions.linkedlist;

public class segregateEvenAndOddNodes {
    static Node divide(Node head) {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;

        while (currentNode != null) {
            int element = currentNode.value;

            if (element % 2 == 0) {

                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }

            } else {

                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            // Move head pointer one step in forward direction
            currentNode = currentNode.next;
        }


        if (oddStart == null || evenStart == null) {
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}

