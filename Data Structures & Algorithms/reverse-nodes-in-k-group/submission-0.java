/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while(true){
           ListNode kthNode = findKthNode(groupPrev, k);
           if(kthNode == null){
              break;
           }
           ListNode groupNext = kthNode.next;
           //reversing the grp
           ListNode prev = kthNode.next;
           ListNode curr = groupPrev.next;
           while(curr != groupNext){
               ListNode temp = curr.next;
               curr.next = prev;
               prev = curr;
               curr = temp;
           }
          
           ListNode temp = groupPrev.next;
           groupPrev.next = kthNode;
           groupPrev = temp;
        }
        return dummy.next;
    }

    public ListNode findKthNode(ListNode node, int k ){
      while(node != null && k > 0){
         node = node.next;
         k-=1;
      }
      return node;
    }
}
