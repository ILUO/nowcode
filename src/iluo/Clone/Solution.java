package iluo.Clone;

import java.util.ArrayList;

/**
 *  1.copy a new node after every origin node
 *  2.make origin node.random = new node.next.random
 *  3.split origin node and new node
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        ArrayList<RandomListNode> originListNodes = new ArrayList<>();
        ArrayList<RandomListNode> copyedListNodes = new ArrayList<>();

        if(pHead != null){

            for(;pHead != null;pHead = pHead.next){
                originListNodes.add(pHead);
            }

            for(int i = 0;i < originListNodes.size();i++){
                RandomListNode temp = new RandomListNode(originListNodes.get(i).label);
                copyedListNodes.add(temp);
            }

            for(int i = 0;i < originListNodes.size();i++){
                if(originListNodes.get(i).random != null){
                    int index = originListNodes.indexOf(originListNodes.get(i).random);
                    copyedListNodes.get(i).random = copyedListNodes.get(index);
                }else{
                    copyedListNodes.get(i).random = null;
                }


            }

            RandomListNode firstNode = copyedListNodes.get(0);


            for(int i = copyedListNodes.size()-1;i > 0;i--){
                RandomListNode temp = copyedListNodes.get(i);
                temp.next = firstNode.next;
                firstNode.next = temp;
            }
            return firstNode;
        }else{
            return  null;
        }
    }

    public static  void main(String[] args){
        int [] next = {1,2,3,4,5,6,7};
        int [] random = {3,1,2,0,6,0,5};
        ArrayList<RandomListNode> randomListNodes = new ArrayList<>();

        for(int i=0;i < next.length;i++){
            RandomListNode temp = new RandomListNode(next[i]);
            randomListNodes.add(temp);
        }

        for(int i = 0;i < next.length - 1;i++){
            randomListNodes.get(i).next = randomListNodes.get(i+1);
        }

        for(int i = 0;i < random.length;i++){
            if(random[i] != 0){
                randomListNodes.get(i).random = randomListNodes.get(random[i]-1);
            }else {
                randomListNodes.get(i).random = null;
            }

        }

        Solution solution = new Solution();

        RandomListNode newNode = solution.Clone(randomListNodes.get(0));

        System.out.println("success");

        for(;newNode != null;newNode = newNode.next){
            System.out.print(newNode.label);
            if(newNode.random != null){
                System.out.print(newNode.random.label);
            }else{
                System.out.print("#");
            }

        }

        if(newNode == randomListNodes.get(0)){
            System.out.print("yes");
        }

    }

}

