package baidu0926;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/26.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int cha[] = new int[n];
        for(int i=0;i<n;i++){
            int temp = num[i];
            num[i] = 0;
            cha[i] = getCount(num);
            num[i] = temp;
        }
        int m =cha[0];
        int index =1 ;
        for(int i=0;i<n;i++){
           if(m>cha[i]){
               m = cha[i];
               index = i+1;
           }
        }

        System.out.print(m+" "+index);

    }
    static int getCount(int []num){
        int count =0;
        int n = num.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(num[i]>num[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
