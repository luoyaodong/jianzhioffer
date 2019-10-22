package reverseSentence;

import java.util.List;

/**
 * Created by yaodongluo on 2019/8/2.
 */
public class Solution {
    public String ReverseSentence(String str){
        if(str==null){
            return null;

        }
        String[] strings = str.split(" ");
        String[] ss = new String[strings.length];
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<strings.length;i++){
            ss[i] = strings[strings.length-1-i];
            stringBuffer.append(ss[i]);
            if(i!=strings.length-1){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        String s = solution.ReverseSentence("student. a am I");
        System.out.print(s);
    }
}
