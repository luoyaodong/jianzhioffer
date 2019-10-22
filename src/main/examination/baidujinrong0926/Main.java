package baidujinrong0926;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/26.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numbers[] = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        int quanzhong[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            int count = 0;
            for(int p=0;p<=i;p++){
                for(int q=i+1;q<n;q++){
                    if(numbers[p]!=numbers[q]){
                        count++;
                    }
                }
            }
            quanzhong[i]=count;
        }
        for(int i=0;i<n-1;i++){
            System.out.print(quanzhong[i]);
            if(i!=n-2){
                System.out.print(" ");
            }

        }
    }
}
