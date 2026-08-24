import java.util.*;
//pair(pow,bon)>>monster
class monster{
    int pow;
    int bon;
    monster(int pow,int bon){
        this.pow=pow;
        this.bon=bon;
    }
}
class Main {
    public static void main(String[] args) {
        int[] pow={101,100,301};
        int[] bon={23,1,799};
      //the exp that should be >= power of monster to kill it
        int e=100;
        monster[] monsters=new monster[pow.length];
        for(int i=0;i<pow.length;i++){
            monsters[i]=new monster(pow[i],bon[i]);
        }
      //sorting based on pow of monter (asc)
        Arrays.sort(monsters,(a,b)->a.pow-b.pow);
        int c=0;
        for(monster m:monsters){
          //when exp greater or equal to power add that monster's bon and increment count
            if(e>=m.pow){
                e+=m.bon;
                c++;
            }
        }System.out.print(c);
    }
}
//OUTPUT: 2
