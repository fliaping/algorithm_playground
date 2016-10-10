/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
       ListNode beforePointer=null,pointer = head;
        if(head != null && head.next != null) head = head.next;
        else return head;
        while(pointer != null){
            if (pointer.next != null) {
                
                if(beforePointer != null) beforePointer.next = pointer.next;
                beforePointer = pointer;
                ListNode three = pointer.next.next;
                pointer.next.next = pointer;
                pointer.next = three;
                
                pointer = three;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
