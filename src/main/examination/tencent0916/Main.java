package tencent0916;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yaodongluo on 2018/9/16.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int M = Integer.parseInt(N);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<s1.length();i++){
            for(int j=i;j<s1.length();j++){
                String sub = getString(s1,i,j);
                if(sub.length()==M){
                    set.add(sub);
                }
            }
        }
        int count=0;
        for(String str:set){
            for(int i=0;i<s2.length();i++){
                for(int j=i;j<s2.length();j++){
                    String ss = getString(s2,i,j);
                    if(str.equals(ss)){
                        count++;
                    }
                }
            }
        }
        System.out.print(count);

    }
    static String getString(String s,int i,int j){
        return s.substring(i,j+1);
    }
}
