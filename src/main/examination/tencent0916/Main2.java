package tencent0916;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/16.
 */
public class Main2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int N=0;
        while (true){
            if(N*(N+1)<(m+n)){
                N++;
                continue;
            }else if(N*(N+1)==(m+n)){
                break;
            }else {
                System.out.print(-1);
                return;
            }
        }
        int[] array = new int[N];
        for(int i=1;i<=N;i++){
            array[i-1]=i;
        }
    }
}
