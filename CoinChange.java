import java.util.*;
class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,99,4,5));
      //OUTPUT: 2 {1,99}
        int amt=100;
        int ans= helper(arr,amt,arr.size());
        System.out.println(ans);
    }
    public static int helper(ArrayList<Integer> coins,int amt,int n){
      //dp arr for the size of amt to be got +1
        int[] dp=new int[amt+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
          //if the coin is 4 then only from 4th indx it will affect, not the amts 1,2,3
            for(int j=coins.get(i);j<=amt;j++){
              //if the val to be got that is (cur coins minus the dp indx vl)amt is not formed then we can't perfom coin change
                if(dp[j-coins.get(i)]!=Integer.MAX_VALUE){
                  //choose whether cur coins or prev amt coins + 1 cur is minimum
                    dp[j]=Math.min(dp[j],dp[j-coins.get(i)]+1);
                }
            }
        }//if we cant form amt
        if(dp[amt]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amt];
        }
    }
}
