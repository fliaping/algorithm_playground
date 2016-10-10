/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if(l1.val<l2.val) head = l1;
        else head = l2;

        ListNode cur = head;
        while(l1 != null && l2 != null){
            if (cur == l1) {
                if (l1.next !=null && (l1.next.val == l1.val || l1.next.val < l2.val)) {
                    l1 = l1.next;
                    cur = l1;
                }else{
                    ListNode next = l1.next;
                    l1.next = l2;
                    l1 = next;
                    cur = l2;
                }
            }else{
                if (l2.next !=null && (l2.next.val == l2.val || l2.next.val < l1.val)) {
                    l2 = l2.next;
                    cur = l2;
                }else{
                    ListNode next = l2.next;
                    l2.next = l1;
                    l2 = next;
                    cur = l1;
                }

            }
        }
    
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
