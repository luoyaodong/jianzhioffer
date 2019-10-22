package alibaba;

/**
 * Created by yaodongluo on 2018/8/15.
 */

/**
 * Created by yaodongluo on 2018/8/12.
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main ah = new Main();
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int N = Integer.parseInt(stringArray[0]);
        int x[] = new int[N];
        int y[] = new int[N];
        for(int i = 0;i<=N-1;i++){
            String input = sc.nextLine();
            String array[] = input.split(",");
            x[i] = Integer.parseInt(array[0]);
            y[i] = Integer.parseInt(array[1]);

        }
        int maxX = 0;
        int maxY = 0;
        for(int i=0;i<N;i++){
            if(maxX<x[i]){
                maxX=x[i];
            }
        }
        for(int i=0;i<N;i++){
            if(maxY<y[i]){
                maxY=y[i];
            }
        }
        System.out.print((maxX+maxY)*2);
    }
}