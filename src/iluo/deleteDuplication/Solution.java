package iluo.deleteDuplication;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode latestNode = null;
        ListNode node = pHead;
        for(;node != null && node.next != null;){
            if(node.val == node.next.val){
                node = deleteNode(latestNode,node,node.val);
                if(latestNode == null){
                    pHead = node;
                }
            }else{
                latestNode = node;
                node = node.next;
            }
        }
        return pHead;
    }


    private ListNode deleteNode(ListNode latestNode,ListNode node,int val){
        for(;node != null && node.val == val;){
            node = node.next;
        }
        if(latestNode == null){
            return node;
        }else{
            latestNode.next = node;
            return node;
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {1,1,1,1,1,1};
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 0;i < a.length;i++){
            ListNode node = new ListNode(a[i]);
            node.next = temp.next;
            temp.next = node;
            temp = node;
        }
        solution.deleteDuplication(head);
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}