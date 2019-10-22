package sanliulin;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/8/27.
 */
public class Question2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int a[] = new int[M];
        int b[] = new int[M];
        for(int i=0;i<M;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<M;i++){
            b[i] = sc.nextInt();
        }
        int max =0;
        for(int i=0;i<M-1;i++){
            for(int j=i+1;j<M;j++){
                int c[] = new int[j-i];
                for(int p=0;p<j-i;p++){
                    c[p] = a[i+p];
                }
                boolean flag = true;
                outer:for(int m=0;m<j-i-1;m++){
//                    if(flag==false) break;
                    for(int n=m+1;n<j-i;n++){
//                        if(flag==false) break;
                        if(find(c[m],c[n],b)){
                            continue;
                        }else {
                            flag=false;
                            //break跳出的是最里层的for循环
                            break outer;
                        }
                    }
                }
                if(flag==true){
                    if(c.length>max){
                        max=c.length;
                    }
                }else{
                    continue;
                }
            }
        }
        System.out.print(max);
     }

    private static boolean find(int i, int i1, int[] b) {
        int m=0;
        int n=0;
        for(;m<b.length;m++){
            if(b[m]==i) break;
        }
        for(;n<b.length;n++){
            if(b[n]==i1) break;
        }
        if(m>n){
            return false;
        }else{
            return true;
        }
    }
}
