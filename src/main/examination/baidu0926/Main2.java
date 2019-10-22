package baidu0926;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/26.
 */
public class Main2 {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int t =sc.nextInt();
            if(s==1){
                a[i][t] = 1;
            }else {
                a[i][t] = 0;
            }
        }
        int guaiwu = 0;
        int putong = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    if(a[j][i]==0){
                        guaiwu++;
                    }else if(a[j][i]==1){
                        putong++;
                    }
                }else if(a[i][j]==0){
                    if(a[j][i]==0){
                        putong++;
                    }else if(a[j][i]==1){
                        guaiwu++;
                    }
                }

            }
        }
        System.out.print(putong/2+" "+guaiwu/2);
    }

}
