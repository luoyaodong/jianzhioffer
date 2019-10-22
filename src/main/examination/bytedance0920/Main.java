package bytedance0920;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/20.
 */
public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
//        System.out.print(factorial(m+n)/(factorial(m)*factorial(n)));
        System.out.print(factorial(n+m+k)/(factorial(n)*factorial(m)*factorial(k)));
    }
    /**
     * 使用递归方法计算n的阶乘
     *
     * @param n
     * @return
     */
    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            long num = n * factorial(n - 1);
            return num;
        }
    }

}
