package printMinNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yaodongluo on 2018/9/12.
 */
public class Solution {

    public String PrintMinNumber(int[] number){
        if(number.length==0){
            return "";
        }
        List<Long> a = new ArrayList<>();
        getPermuation(number,0,number.length-1,a);
//        for(int m:a){
//            System.out.println(m);
//        }
        Long min= Collections.min(a);
        return String.valueOf(min);
    }



    private void getPermuation(int[] number, int begin, int end,List<Long> a) {

        if(begin == end){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0;i<number.length;i++){
                stringBuffer.append(String.valueOf(number[i]));
            }
            a.add(Long.valueOf(stringBuffer.toString()));
        }else {
            for(int i=begin;i<=end;i++){
                Swap(number,begin,i);
                getPermuation(number,begin+1,end,a);
                Swap(number,begin,i);
            }
        }

    }

    private void Swap(int[] number, int i, int end) {
        int temp = number[i];
        number[i] = number[end];
        number[end] = temp;
    }
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] a={3334,3,3333332};
        System.out.print(solution.PrintMinNumber(a));
    }
}
