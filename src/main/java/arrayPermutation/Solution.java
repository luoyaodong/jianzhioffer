package arrayPermutation;

import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * Created by yaodongluo on 2018/9/12.
 */
public class Solution {
    static char[] array={'3','5','2','1','4'};
    public static void main(String args[]){
        Solution.getPermutation(array,0,array.length-1);
    }


    public static void getPermutation(char[] array, int begin, int end){
        if(begin==end){
            System.out.println(String.valueOf(array));
            return;
        }else {
            for(int i=begin;i<=end;i++){
                Swap(array,begin,i);
                getPermutation(array,begin+1,end);
                Swap(array,begin,i);
            }
        }
    }

    private static void Swap(char[] array, int i, int j) {
        char a = array[i];
        array[i] = array[j];
        array[j] = a;
    }


}
