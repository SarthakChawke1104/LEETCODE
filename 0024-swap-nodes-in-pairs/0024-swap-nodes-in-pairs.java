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
    public ListNode merge(ListNode d1,ListNode d2){
        ListNode i = d1.next;
        ListNode j = d2.next;
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        while(i != null || j != null){
            if(j != null){
                k.next = j;
                k = k.next;
                j = j.next;
            }
            if(i != null){
                k.next = i;
                k = k.next;
                i = i.next;
            }
        }
        k.next = null;

        return dummy.next;
    }
    public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
            return head;
        }
            ListNode d1 = new ListNode(-1);
            ListNode d2 = new ListNode(-1);
            ListNode t1 = d1;
            ListNode t2 = d2;
            ListNode t = head;
            int idx = 1;
            while(t != null){
                if(idx%2 != 0){
                    t1.next = t;
                    t1 = t1.next;
                }
                else{
                    t2.next = t;
                    t2 = t2.next;
                }
                idx++;
                t = t.next;
            }
            t1.next = null;
            t2.next = null;

            return merge(d1,d2);
    }
}