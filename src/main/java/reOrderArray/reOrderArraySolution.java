package reOrderArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongluo on 2018/7/9.
 *
 * 两处错误：
 第一：List是接口，需要实现类ArrayList或者LinkedList,不能new List；
 第二：int是基本数据类型，只能用Integer
 正解：List<Integer>  list = new ArrayList<Integer>()
 */
public class reOrderArraySolution {
    public void reOrderArray(int[] array){
        List<Integer> list = new ArrayList<Integer>();


        for(int i =0 ;i<array.length;i++){
            if(array[i]%2==1){
                list.add(array[i]);
            }
        }
        for(int i =0 ;i<array.length;i++){
            if(array[i]%2==0){
                list.add(array[i]);
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=list.get(i);
            System.out.print(array[i]);
        }
    }
    public static void main(String args[]){
        int[] array = {2,4,6,3,4,67,89};

        reOrderArraySolution solution = new reOrderArraySolution();
        solution.reOrderArray(array);

    }
}
