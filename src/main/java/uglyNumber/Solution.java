package uglyNumber;

import java.util.*;

/**
 * Created by yaodongluo on 2018/9/12.
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
//        double a =  Math.log((double) (index-1))/Math.log((3));
        if(index==1){
            return 1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int i2 =0,i3=0,i5=0;
        while (res.size()<index){
            int m2=res.get(i2)*2;
            int m3=res.get(i3)*3;
            int m5=res.get(i5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            res.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return res.get(res.size()-1);

//        超时的方法
//        List<Integer> arrays = new ArrayList<>();
//        arrays.add(1);
//        int num = index*2;
//
//        BuildSet(arrays,num);
//        Collections.sort(arrays);
//
//
//        return arrays.get(index-1);
    }
//错误的方法，这个方法会先把10，9添加到8的前面，然后返回set
    private void BuildSet(List<Integer> list, int index) {
        for(int i=0;i<list.size();i++){
            int a = list.get(i);
            if(!list.contains(a*2)){
                list.add(a*2);
                if(list.size()==index){
                    return;
                }
            }
            if(!list.contains(a*3)){
                list.add(a*3);
                if(list.size()==index){
                    return;
                }
            }
            if(!list.contains(a*5)){
                list.add(a*5);
                if(list.size()==index){
                    return;
                }
            }
        }

    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.print(solution.GetUglyNumber_Solution(100));
    }
}
