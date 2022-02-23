/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Stack<Node> s = new Stack<>();
        s.push(head);
        Node p = null;
        while(!s.empty()) {
            Node n = s.pop();
            if(n.next != null) s.push(n.next);
            if(n.child != null) {
                s.push(n.child);
                n.child = null;
            }
            n.next = s.empty() ? null : s.peek();
            n.prev = p;
            p = n;
        }
        return head;
    }
}