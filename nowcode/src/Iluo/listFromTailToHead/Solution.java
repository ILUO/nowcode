package iluo.listfromtailtohead;

/**
 * Created by Yang Xing Luo on 2018/9/28.
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList<Integer>();
        while(listNode!=null){
            arrayList.add(0,listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }

    public static void main(String []args){
        ListNode firstNode = new ListNode(0);
        for(int i = 1;i < 10;i ++){
            ListNode listNode = new ListNode(i);
            listNode.next = firstNode;
            firstNode = listNode;
        }
        Solution solution= new Solution();
        System.out.println(solution.printListFromTailToHead(firstNode));
    }
}

class ListNode {
        int val;
        ListNode next = null;
                ListNode(int val) {
                this.val = val;
            }
}