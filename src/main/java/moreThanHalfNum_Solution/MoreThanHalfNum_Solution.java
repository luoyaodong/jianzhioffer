package moreThanHalfNum_Solution;

import java.util.*;

/**
 * Created by yaodongluo on 2018/8/16.
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int value = map.get(array[i]);
                value++;
                map.put(array[i],value);
            }else {
                map.put(array[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
//        for(Map.Entry<Integer,Integer> mapping:list){
//            System.out.println(mapping.getKey()+":"+mapping.getValue());
//        }
        if(list.get(0).getValue()>array.length/2){
            return list.get(0).getKey();

        } else {
            return 0;
        }
    }
    public static void main(String args[]){
        MoreThanHalfNum_Solution solution = new MoreThanHalfNum_Solution();
        int[] a= {1,2,3,2,2,2,5,4,2};
        solution.MoreThanHalfNum_Solution(a);
    }
}
