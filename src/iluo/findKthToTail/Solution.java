package iluo.findKthToTail;



public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {

        if(k == 0 || head == null){
            return null;
        }

        ListNode pNode = head;
        ListNode qNode = head;


        for(int count = 0;count < k-1;){
            qNode = qNode.next;
            if(qNode == null){
                return null;
            }
            count++;
        }

        for(;qNode.next!=null;){
            pNode = pNode.next;
            qNode = qNode.next;
        }

        return pNode;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode node;
        node = head;
        for(int i = 1;i <= 0;i++){
            ListNode temp = new ListNode(i);
            temp.next = null;
            node.next = temp;
            node = temp;
        }
        int k = 10;

        ListNode listNode = solution.FindKthToTail(null,k);
        if(listNode == null){
            System.out.println(listNode);
        }else {
            System.out.println(solution.FindKthToTail(head,k).val);
        }

    }
}
