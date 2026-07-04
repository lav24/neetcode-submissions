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
    public void reorderList(ListNode head) {
       ListNode  f = head, s = head;

       while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
       }
       //matched at mid pt 
       ListNode second = s.next;
       s.next = null;
       ListNode prev = null;
       while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
       }
       second =prev;
       ListNode first = head;
       while(second != null){
         ListNode tmp1 = first.next;
         ListNode tmp2 = second.next;
         first.next = second;
         second.next = tmp1;
         first = tmp1 ;
         second = tmp2;

       }

    }
}
