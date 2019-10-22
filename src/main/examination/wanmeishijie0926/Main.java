package wanmeishijie0926;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/26.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ye[] = new int[7];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            ye[i] = sc.nextInt();
        }
        for (int i = 0; i < 7; i++) {
            count = count + ye[i];
        }
        int m = n/count;
        int c = n-m*count;
        int s =0;
        for(int i=0;i<7;i++){
            s = s+ye[i];
            if(s>=c){
                System.out.print(i+1);
                return;
            }
        }
    }
}
