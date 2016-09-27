/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
  ListNode p1 = head,p2 = head;
    for (int i = 1; i < n; i++) {
      if (p2 == null || p2.next == null) return head; 
      p2 = p2.next;
    }
    ListNode beforeP1 = null;
    while(p2.next!=null){
      p2 = p2.next;
      beforeP1 = p1;
      p1 = p1.next;
    }
    if (p1 == head) return p1.next;
    if (beforeP1 != null) {
      beforeP1.next = p1.next;
      p1 = null;
      return head;
    }else {
      return null;
    }
    }
}
