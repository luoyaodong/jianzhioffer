package wangyi9_8;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/8.
 */
public class Main2 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int n[] = new int[len];
        int m[] = new int[len];
        for(int i=0;i<len;i++){
            n[i] = in.nextInt();
            m[i] = in.nextInt();
        }


        for(int i=0;i<len;i++){
            System.out.println(getNum(n[i],m[i]));
        }

    }

    public static int getNum(int N, int M) {
        int a=0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int count=1;
                for(int k = 0; k <= 7; k++){
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    //判断是否越界
                    if (x > N-1 || x < 0 || y > M-1 || y < 0)
                        continue;
                    //如果该点为小岛且未被遍历
                    else
                        count++;
                }
                if(count%2==1){
                    a++;
                }else {
                    continue;
                }
            }
        }
        return a;
    }
}
