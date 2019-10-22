package guazi0917;

/**
 * Created by yaodongluo on 2018/9/17.
 */
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            int num = in.nextInt();

            System.out.println(coin_counts(num));

    }

    public static int coin_counts(int n) {
        int[] coins = { 1, 2,5, 10 };
        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i = 0; i < 4; ++i) {
            for (int j = coins[i]; j <= n; ++j) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }
}
