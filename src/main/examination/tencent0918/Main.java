package tencent0918;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];

        for(int i =0;i<N;i++){
            array[i] = sc.nextInt();
        }
        int max=0;
        getPermutation(array,0,N,max);

    }
    public static void getPermutation(int[] array, int begin, int end,int max){
        if(begin==end){
            return;
        }else {
            for(int i=begin;i<=end;i++){
                Swap(array,begin,i);
                getPermutation(array,begin+1,end,max);
                Swap(array,begin,i);
            }
        }
    }

    private static void Swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }
}
