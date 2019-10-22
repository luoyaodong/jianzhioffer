package jingdong9_9;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        int count = 0;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        if(s.length==t.length){
            for(int i=0;i<s.length;i++){
                if(s[i]==t[i]){
                    continue;
                }else {
                    return 0;
                }
            }
        }else if(s.length>t.length){
            for(int i=0;i<s.length-t.length+1;i++){
                char[] a = new char[t.length];
                for(int j=0;j<t.length;j++){
                    a[j] = s[j+i];
                }
                int as = convert(a);
                int ts = convert(t);
                if(as==ts){
                    count = count+1;
                }else {
                    continue;
                }
            }
        }else {
            for(int i=0;i<t.length-s.length;i++){
                char[] a = new char[t.length];
                for(int j=i;j<t.length;j++){
                    a[j] = t[j];
                }
                if(convert(a)==(convert(s))){
                    count = count+1;
                }else {
                    continue;
                }
            }
        }

        return count;
    }

    private static int convert(char[] s) {
        int[] a = new int[s.length];

        List<Character> list = new ArrayList<>();

        for(int j =0;j<s.length;j++){
            if(list.contains(s[j])){
                continue;
            }else {
                list.add(s[j]);
            }
        }

        for(int i=1;i<=list.size();i++){
            for(int j=0;j<s.length;j++){
                if(s[j]==list.get(i-1)){
                    a[j] = i;
                }
            }
        }
        int result =0;
        for(int i=0;i<a.length;i++){
            int m =(int) Math.pow(10,a.length-1-i);
            result = result+a[i]*m;
        }
        return result;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}

