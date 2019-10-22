package baidujinrong0926;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/26.
 */
public class Main2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numbers[][] = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                numbers[i][j] = sc.nextInt();
                if(getNum(numbers[i][0],numbers[i][1],numbers[i][2])){
                    System.out.print("A");
                }else {
                    System.out.print("B");
                }
            }
        }




    }

    private static boolean getNum(int x, int y, int m) {
        int count =0;
        if(getNumber(x,y,m,count)%2==1){
            return true;
        }else {
            return false;
        }
    }


    static int getNumber(int x, int y, int m, int count){
        if(Math.pow(x,y)>=m){
            return count;
        }else {
            if(Math.pow(x+1,y)>Math.pow(x,y+1)){
                getNumber(x+1,y,m,count++);
            }else {
                getNumber(x,y+1,m,count++);
            }
        }
        return count;
    }
}
