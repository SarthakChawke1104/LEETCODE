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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head; 

        ListNode before = dummy;

        for(int i = 1; i < left; i++){
            before = before.next;
        }
        ListNode slow = before.next;
        ListNode fast = slow;

        for(int i = left; i < right; i++){
            fast = fast.next;
        }
        ListNode curr = slow;
        ListNode end = fast.next;
        ListNode prev = end;

        while(curr != end){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        before.next = prev;
        
        return dummy.next;
    }
}