package iluo.coinchanging;

public class Solution{
        public int charge(int[] coinsValues, int n){
            int[][] c = new int[coinsValues.length + 1][n + 1];
            
            for(int i = 0; i <= coinsValues.length; i++)
                c[i][0] = 0;
            for(int i = 0; i <= n; i++)
                c[0][i] = Integer.MAX_VALUE;
            
            for(int j_money = 1; j_money <=n; j_money++)
            {
                
                for(int i_coinKinds = 1; i_coinKinds <= coinsValues.length; i_coinKinds++)
                {
                    if(j_money < coinsValues[i_coinKinds-1])
                    {
                        c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
                        continue;
                    }
                    
                    if(c[i_coinKinds - 1][j_money] < (c[i_coinKinds][j_money - coinsValues[i_coinKinds-1]] +1))
                        c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
                    else
                        c[i_coinKinds][j_money] = c[i_coinKinds][j_money - coinsValues[i_coinKinds-1]] +1;
                }
            }
            return c[coinsValues.length][n];
        }
        public static void main(String []args){
            int [] coinsValues = {1,2,5,10,25};
            Solution solution = new Solution();
            
            for(int i=1;i<101;i++){
                 System.out.println(solution.charge(coinsValues, i));
            }
        }
    
    }