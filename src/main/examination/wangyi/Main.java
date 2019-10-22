package wangyi;
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for(int j = 0;j<n;j++ ){
            array[j] = sc.nextInt();
        }
        int[][] last  = new int[2][k];
        int mingap = 0;
        for(int j=0;j<k;j++){
            int max = array[0];
            int maxindex = 0;
            for(int i=0;i<array.length;i++){
                if(array[i]>max){
                    max = array[i];
                    maxindex = i;
                }else {
                    continue;
                }
            }
            int min = array[0];
            int minindex = 0 ;
            for(int i = 0;i<array.length;i++){
                if(array[i]<min){
                    min = array[i];
                    minindex = i;
                }else {
                    continue;
                }

            }
            array[maxindex] = max-1;
            array[minindex] = min+1;
            last[0][j] = maxindex+1;
            last[1][j] = minindex+1;
        }
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }else {
                continue;
            }
        }
        int min = array[0];
        for(int i = 0;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }else {
                continue;
            }

        }
        mingap = max-min;
        System.out.print(mingap);
        System.out.print(' ');
        System.out.println(k);
        for(int i =0;i<k;i++){
            System.out.print(last[0][i]);
            System.out.print(' ');
            System.out.println(last[1][i]);
        }

    }

}