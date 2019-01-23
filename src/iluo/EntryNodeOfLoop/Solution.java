package iluo.EntryNodeOfLoop;
import java.util.HashMap;

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode result = null;
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        for(;pHead != null; pHead = pHead.next){
            if(hashMap.containsKey(pHead)){
                return pHead;
            }
            hashMap.put(pHead,1);
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}