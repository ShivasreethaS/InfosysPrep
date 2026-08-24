import java.util.*;
class Main {
    public static void main(String[] args) 
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,99,4,5));
        int ans= helper(arr,arr.size(),0,new ArrayList<>());
        System.out.println(ans);
    }
    public static int helper(ArrayList<Integer> arr,int n,int cur,ArrayList<Integer> res){
        int pick=0,notpick=0;
        if(cur==n){
            //if all are in asc order then we will reach the end, if so return the size of res
            return res.size();
        }
        //while checking the prev res val and curr arraylist val we may have res as empty so check that and check the increasing order
        if(res.isEmpty() || res.get(res.size()-1)<arr.get(cur)){
            //add to res
            res.add(arr.get(cur));
            //proceed with the cur added to res
            pick=helper(arr,n,cur+1,res);
            // now remove the cur
            res.remove(res.size()-1);
            //proceed with removed curr
            notpick=helper(arr,n,cur+1,res);
        }
        //find whether pick or not pick has max length
        return Math.max(pick,notpick);
    }
}
//OUTPUT: 4 {1<2<3<5}
