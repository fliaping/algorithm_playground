
/**
 * Created by Payne on 8/23/16.
 */

//  Definition for singly-linked list.


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode p1=l1,p2=l2,p3=null;
        int[] sum = new int[]{0,0};
        while (p1!=null && p2!=null) {
            sum = add(p1.val, p2.val+sum[1]);
            if(p3!=null) {
                p3.next = new ListNode(sum[0]);
                p3 = p3.next;
            }else {
                p3 = new ListNode(sum[0]);
                result = p3;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p2!=null) {
            sum = add(p2.val, sum[1]);
            p2.val = sum[0];
            p3.next = p2;
            p3 = p3.next;
            p2=p2.next;
        }

        while (p1!=null) {
            sum = add(p1.val, sum[1]);
            p1.val = sum[0];
            p3.next = p1;
            p3 = p3.next;
            p1=p1.next;
        }
        if(sum[1]!=0){
            p3.next = new ListNode(sum[1]);
        }
        return result;
    }

    public int[] add(int a,int b){
        //if(a>9 || b>9) throw new IllegalArgumentException("input linked list error");
        int sum = a+b;
        if (sum>9) {
            return new int[]{sum%10,1};
        }else {
            return new int[]{sum,0};
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution so = new Solution();
        so.addTwoNumbers(l1, l2);
    }
}

