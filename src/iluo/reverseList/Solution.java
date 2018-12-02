package iluo.reverseList;

/**
 * 1.this can also be implementing by inserting to head node
 */

public class Solution {


    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = new ListNode(head.val);
        first.next = head.next;

        ListNode temp = new ListNode(head.val);
        temp.next = head.next;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode pcur = head.next;

        for(;pcur != null;){
            //head.next = copyANode(head.next.next);
            prev.next = pcur.next;

            //temp.next.next = copyANode(first);
            pcur.next = dummy.next;

            //first = copyANode(temp.next);
            dummy.next = pcur;

            //temp = copyANode(head);
            pcur = prev.next;

        }

        return dummy.next;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode node;
        node = head;
        for(int i = 1;i <= 1;i++){
            ListNode temp = new ListNode(i);
            temp.next = null;
            node.next = temp;
            node = temp;
        }
        ListNode test = head;
        for(;test.next != null;){
//            System.out.println(test.val);
            test = test.next;
        }

        ListNode listNode = solution.ReverseList(head);
        test = listNode;

        for(;test!=null;test=test.next){
            System.out.println(test.val);
        }
    }


}
