package firstNotRepeatingChar;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        for(int i=0;i<str.length();i++){
            boolean flag = true;
            for(int j=0;j<i;j++){
                if(str.charAt(j) == str.charAt(i)){
                    flag = false;
                    break;
                }
            }
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)==str.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.print(solution.FirstNotRepeatingChar("google"));
    }
}
