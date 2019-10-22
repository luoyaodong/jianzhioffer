package numberOf1Solution;

/**
 * Created by yaodongluo on 2018/7/9.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1Solution {
    public int NumberOf1(int n){

        String binary = Integer.toBinaryString(n);
        int count =0;
        for(int i=0;i<binary.length();i++){
            char a = binary.charAt(i);
            if (a=='1'){
                count++;
            }

        }
        return count;
    }
}
