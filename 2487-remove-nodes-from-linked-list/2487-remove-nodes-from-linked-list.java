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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = head;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
        
    }
    public ListNode removeNodes(ListNode head) {
        ListNode head1 = reverse(head);

        ListNode temp = head1;
        int max = temp.val;

        ListNode helo = new ListNode(temp.val);
        ListNode tail = helo;

        temp = temp.next;

        while(temp!=null){
            if(temp.val >= max){
                max = temp.val;

                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
        }
        return reverse(helo);
    }
}