package iluo.MergeList;

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode last = dummy;

        if(list1  != null && list2 != null){
            for(;;){
                if(list1 != null && list2 != null){
                    if(list1.val <= list2.val){
                        last.next = list1;
                        last = last.next;
                        list1 = list1.next;
                    }else{
                        last.next = list2;
                        last = last.next;
                        list2 = list2.next;
                    }
                }else if(list1 == null){
                    last.next = list2;
                    break;
                }else{
                    last.next = list1;
                    break;
                }
            }
        }else if (list1 == null){
            last.next = list2;
        }else{
            last.next = list1;
        }



        return dummy.next;
    }

    public ListNode generateList(Integer start,Integer end,Integer step){
        ListNode head = new ListNode(-100);
        ListNode node = head;
        for(int i = start;i < end ;i = i + step){
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = temp;
        }
        return head;
    }


    public static void main(String []args){
        Solution solution = new Solution();
        ListNode head1 = solution.generateList(-2,10,2);
        ListNode head2 = solution.generateList(-2,10,3);

        ListNode dummy = solution.Merge(null,head2);
        for(ListNode node = dummy;node != null;node = node.next){
            System.out.println(node.val);
        }
    }

}
