import java.util.*;
class Main {
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,99,4,5));
        int ans= helper(arr,arr.size(),0,0);
        System.out.println(ans);
    }
    public static int helper(ArrayList<Integer> arr,int n,int cur, int xor){
        if(cur==n){
            // if cur reaches n then arraylist over so return the xor val 
            return xor;
        }
        // cur val is taken so change the xor to xor^cur --> proceed
        int take= helper(arr,n,cur+1,xor^arr.get(cur));
        //cur is not taken so no change in xor --> proceed
        int notTake=helper(arr,n,cur+1,xor);
        //return the max xor val of take or not take
        return Math.max(take,notTake);
    }
}

//OUTPUT: 103
// 103 comes from the subset [99, 4].

// Your recursion tries every possible subset using TAKE / DON'T TAKE.

// For this branch:

// Don't take 1
// Don't take 2
// Take 99
// Take 4
// Don't take 5

// The XOR becomes:

// 0 ^ 99 = 99
// 99 ^ 4 = 103

// Binary:

// 99 = 1100011
//  4 = 0000100
//       -------
//       1100111 = 103

// Your code compares every branch:

// return Math.max(take, notTake);

// So after checking all 2⁵ = 32 subsets, the largest XOR is:

// 103
