package tencent0918;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Main2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int M = sc.nextInt();
        int total = W*H;
        if(M>total){
            System.out.print(total);
            return;
        }
        int oneedge = (int)Math.sqrt(M);
        int min = Math.min(W,H);
        if(oneedge>=min){
            System.out.print((M/min)*min);
        }else {
            System.out.print(oneedge*oneedge);
        }
    }
}
