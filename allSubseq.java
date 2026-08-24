import java.util.*;
class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        helper(arr,arr.size(),0,new ArrayList<>());
        // arraylist, length, cur val to be taken or not, list to store the current subsequence
    }
    public static void helper(ArrayList<Integer> arr,int n,int cur,ArrayList<Integer> seq){
        if(cur==n){
            //when cur is the last element in arraylist stop and return the subseq
            System.out.println(seq);
            return;
        }
        //add cur to seq
        seq.add(arr.get(cur));
        //continue the seq with cur
        helper(arr,n,cur+1,seq);
        //remove cur from seq
        seq.remove(seq.size()-1);
        //continue the seq without cur
        helper(arr,n,cur+1,seq);
    }
}

// OUTPUT:
// [1, 2, 3, 4, 5]
// [1, 2, 3, 4]
// [1, 2, 3, 5]
// [1, 2, 3]
// [1, 2, 4, 5]
// [1, 2, 4]
// [1, 2, 5]
// [1, 2]
// [1, 3, 4, 5]
// [1, 3, 4]
// [1, 3, 5]
// [1, 3]
// [1, 4, 5]
// [1, 4]
// [1, 5]
// [1]
// [2, 3, 4, 5]
// [2, 3, 4]
// [2, 3, 5]
// [2, 3]
// [2, 4, 5]
// [2, 4]
// [2, 5]
// [2]
// [3, 4, 5]
// [3, 4]
// [3, 5]
// [3]
