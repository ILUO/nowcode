package iluo.Power;



public class Solution {
    public double Power(double base, int exponent) {
        if(exponent > 0){
            return (PostivePower(base, exponent));
        }else if(exponent < 0){
            return (1 / PostivePower(base, -exponent));
        }else{
            return (1.0);
        }
    }

    public double PostivePower(double postiveBase, int exponent){
        if(exponent == 1){
            return postiveBase;
        }
        if(exponent % 2 == 0){
            return PostivePower(postiveBase, exponent/2) * PostivePower(postiveBase, exponent/2);
        }else{
            return PostivePower(postiveBase, (exponent - 1)/2) * PostivePower(postiveBase,(exponent - 1)/2) * postiveBase;
        }
    }

    public static void main(String[] args){
        double pi = 3;
        Solution solution = new Solution();
        for(int i = -100;i < 100;i++){
            System.out.println(solution.Power(pi, i)); 
        }
    }
}