package DSA.trie;

public class AppreciateRound01 {

    public static void main(String[] args) {
        int [] num = new int[]{1,3,5,2,14,1,51};
        int k =2;
        reverseInGroup(num,k);
        // 3,1,2,5,1,14,51
        reverseArray(num);
        for(int i=0;i< num.length;i++){
            //System.out.print(STR."\{num[i]} ");
        }
    }

    private static void reverseInGroup(int[] num, int k) {
        for(int i=0;i<num.length;i++){
            int low = i;
            int high = i+k-1;
            i = high;
            if(high<num.length)
            reverseGroup(num,low,high);
        }
    }

    private static void reverseGroup(int[] num, int low, int high) {
        while(low<=high){
            swapValue(num ,low,high);
            low++;
            high--;
        }

    }

    private static void reverseArray(int[] num) {
        int low = 0;
        int high =  num.length-1;
        while(low<=high){
            swapValue(num ,low,high);
            low++;
            high--;
        }
        System.out.println(num.length);
    }

    private static void swapValue(int[] num ,int lw, int hg) {
        int temp  = num[lw];
        num[lw]=num[hg];
        num[hg] = temp;

    }

    // third highest salary
    //employess  name , salary
       //select *

}
