package aiqiyi0928;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/28.
 */
public class Main2 {


    public static void getMinCoinCounts(int coinValue[], int coinKinds,
                                        int money) {
        // 存放每个金额需要的最小硬币数
        int[] coinUsed = new int[money + 1];
        // 当金额为0，初始化需要硬币数为0
        coinUsed[1] = 1;
        for (int i = 1; i <= money; i++) {
            // 申请一个变量存储临时的money,初始化无限大
            coinUsed[i]  = i;
            for (int j = 1; j <= coinKinds; j++) {
                if(coinValue[j-1]<=i){
                    int temp = coinUsed[i - coinValue[j-1]] + 1;
                    if(temp < coinUsed[i]){
                        coinUsed[i] = temp;
                    }
                }
            }
            System.out.println(i + "最小硬币数：" + coinUsed[i]);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int a[] =  new int[n];

        int max =0;
        int min = 1000000000;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(min>a[i]){
                min = a[i];
            }
            if(max<a[i]){
                max = a[i];
            }
        }
        for(int i=max;i>=min;i--){
            for(int j=0;j<n;j++){
                a[j] = Math.abs(i-a[j]);
            }
            Main2.getMinCoinCounts(a, a.length,m);
        }
    }


}
