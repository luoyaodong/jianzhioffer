package aiqiyi0928;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/28.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = (n+1)/2;
        int cout =0;

        for(int i=0;i<=s;i++){
            int h = n-i;

            int a1 = (int)getNFactorial1(h+1);
            int a2 = (int)getNFactorial1(i);
            int a3 = (int) getNFactorial1(i);
            cout = cout+a1/(a2*a3);
        }
        System.out.print(cout-1);
        return;


    }

    public static long getNFactorial1(int n){
        if(n==0){
            return 1l;
        }
        long sum=1l;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }
}
