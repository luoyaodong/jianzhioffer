package xiaomi0920;

/**
 * Created by yaodongluo on 2018/9/20.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean miHomeGiftBag(int[] p, int M) {
        Boolean flag = false;
        for(int i=0;i<p.length;i++){
            flag = getPermutation(p,0,p.length-1,i,M,flag);
        }

        return flag;
    }
    /******************************结束写代码******************************/

    public static boolean getPermutation(int[] array, int begin, int end,int num,int M,boolean flag){
        if(begin==end){
            int he=0;
            for(int i=0;i<num;i++){
                he+=array[i];
            }
            if(he == M){
                flag = true;
            }
            return flag;
        }else {
            for(int i=begin;i<=end;i++){
                Swap(array,begin,i);
                getPermutation(array,begin+1,end,num,M,flag);
                Swap(array,begin,i);
            }
        }
        return flag;
    }

    private static void Swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;
        int _p_size = 0;
        _p_size = Integer.parseInt(in.nextLine().trim());
        int[] _p = new int[_p_size];
        int _p_item;
        String []_ps = in.nextLine().split(" ");
        for(int _p_i = 0; _p_i < _p_size; _p_i++) {
            _p_item = Integer.parseInt(_ps[_p_i]);
            _p[_p_i] = _p_item;
        }

        int _M;
        _M = Integer.parseInt(in.nextLine().trim());

        res = miHomeGiftBag(_p, _M);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
