package iluo.FindFirstCommonNode;

import java.util.ArrayList;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        int length1 = 0,length2 = 0;
        for(;n1 != null;n1=n1.next) length1++;
        for(;n2 != null;n2 = n2.next) length2++;

        int lengthDifference = 0;

        if(length1 > length2){
            lengthDifference = length1 - length2;
            for(int i = 0; i < lengthDifference;i++){
                pHead1 = pHead1.next;
            }
        }else {
            lengthDifference = length2 - length1;
            for(int i = 0; i < lengthDifference;i++){
                pHead2 = pHead2.next;
            }
        }

        for(;pHead1!=pHead2;){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
            if(pHead1 == null || pHead2 == null){
                return null;
            }
        }

        return pHead1;
    }

    public static void main(String[] args){
        ArrayList<ListNode> arrayList= new ArrayList<>();
        for(int i = 0;i < 10;i++){
            arrayList.add(new ListNode(i));
        }

        ListNode first = arrayList.get(0);
        ListNode firstBak = arrayList.get(0);
        ListNode second = arrayList.get(3);

        for(int i = 0;i < arrayList.size()-1;i++){
            if(i != 2){
                arrayList.get(i).next = arrayList.get(i+1);
            }
            if(i == 3){
                arrayList.get(i).next = arrayList.get(4);
            }
            if(i == 2){
                arrayList.get(i).next = arrayList.get(4);
            }

        }
        Solution solution = new Solution();
        System.out.println(solution.FindFirstCommonNode(first,second).val);
//        for(;first!=null; first=first.next) System.out.println(first.val);
//        System.out.println(second.val+","+second.next.val);

    }


}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}