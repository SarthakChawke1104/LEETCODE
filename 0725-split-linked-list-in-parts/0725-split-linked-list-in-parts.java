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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[] =  new ListNode[k];

        ListNode temp = head;
        ListNode prev = null;

        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        temp = head;

        int size = length/k;
        int extra = length%k;

        for(int i = 0; i < k; i++){
            ans[i] = temp;

            int partsize = size;

            if(i < extra){
                partsize++;
            }

            for(int j = 1; j < partsize; j++){
                temp = temp.next;
            }
            if(temp != null){
                ListNode nextpart = temp.next;
                temp.next = null;
                temp = nextpart;
            }
                  
        }
        return ans;
    
        
    }
}