package jz47;

/**
 * Created by yaodongluo on 2020/9/22.
 */
public class Solution {
    public int Sum_Solution(int n){
        if(n <= 1){
            return n;
        }else {
            return n+Sum_Solution(n-1);
        }
    }

    int res = 0;
    public int Sum_Solution2(int n) {
        boolean x = n>1 && Sum_Solution2(n-1)>0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Sum_Solution2(4));
    }
}
