package numberOf1Between1AndN_Solution;

/**
 * Created by yaodongluo on 2018/9/12.
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            char[] chars;
            String s = Integer.toString(i);
            chars = s.toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j]=='1'){
                    count++;
                }
            }
        }
        return count;
    }
}
