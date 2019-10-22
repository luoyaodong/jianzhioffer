package getLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by yaodongluo on 2018/8/16.
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k>input.length){
            return list;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<input.length;i++){
            arrayList.add(input[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i=0;i<k;i++){
            list.add(arrayList.get(i));
        }
        return list;
    }
}
