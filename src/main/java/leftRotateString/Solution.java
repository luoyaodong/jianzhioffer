package leftRotateString;

/**
 * Created by yaodongluo on 2019/8/1.
 */
public class Solution {
    public String LeftRotateString(String str,int n){
       char c[] = str.toCharArray();
       char temp[] = new char[c.length];
       int length = c.length;
       for(int i=0;i<length;i++){
           temp[(i+length-n)%length] = c[i];
       }
       //注意Char转化为String的方法
       return String.valueOf(temp);
    }
    public static void main(String args[]){
        String s = "abcXYZdef";
        Solution solution = new Solution();
        String ss =solution.LeftRotateString(s,3);
        System.out.println(ss);
    }
}
