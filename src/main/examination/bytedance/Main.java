package bytedance;

/**
 * Created by yaodongluo on 2018/8/12.
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    static int N,M;
    int[][] a = new int[100][100];
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};	//方向数组，右左下上
    int[][] book = new int[100][100];				//标记是否已经遍历
    static int sum = 1;							//格子的面积
    public int dfs(int i, int j, int color){
        //对该点进行着色
        a[i][j] = color;
        //枚举四个方向，先往右
        for(int k = 0; k <= 7; k++){
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            //判断是否越界
            if (x > N-1 || x < 0 || y > M-1 || y < 0)
                continue;
            //如果该点为小岛且未被遍历
            if (a[x][y] > 0 && book[x][y] == 0) {
                sum++;
                book[x][y] = 1;					//一定得先赋值为1，否则会死循环
                dfs(x, y, color);				//遍历下一个点
            }
        }
        return sum;								//遍历完周围4个点即返回上一个点
    }

    public static void main(String[] args) {
        Main ah = new Main();
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        N = Integer.parseInt(stringArray[0]);
        M = Integer.parseInt(stringArray[1]);

        for(int i = 0;i<=N-1;i++){
            String input = sc.nextLine();
            String array[] = input.split(",");
            for(int j=0;j<=M-1;j++){
                ah.a[j][i]=Integer.parseInt(array[j]);
            }
        }
        int max =0;
        int color = 0;
        for(int i = 0; i <= N-1; i++)
            for(int j = 0; j <= M-1; j++){
                //因为着色点会被dfs赋值  <0  故再找到 >0 的点一定是新小岛
                if (ah.a[i][j] > 0) {
                    sum = 1;
                    color--;
                    //因为dfs是为下一个点标记， 故此点在此标记
                    ah.book[i][j] = 1;
                    sum = ah.dfs(i, j, color);
                    if(sum>=max){
                        max = sum;
                    }
//                    System.out.println(sum);
                }

            }

        //输出
//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= M; j++){
//                System.out.print(ah.a[i][j] + "  ");
//            }
//            System.out.println();
//        }

        //负值变正
        System.out.print(-color);
        System.out.print("1,45;78,100;200,220");
        System.out.print(",");
        System.out.println(max);
    }
}