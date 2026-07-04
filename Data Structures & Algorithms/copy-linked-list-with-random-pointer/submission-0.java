/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            oldToCopy.put(current, newNode);
            current = current.next;
        }
        current = head;
        while(current != null){
            Node newRef = oldToCopy.get(current);
            newRef.next = current.next == null ? null : oldToCopy.get(current.next);
            newRef.random =  current.random == null ? null : oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }
}
