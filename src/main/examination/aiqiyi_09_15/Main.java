package aiqiyi_09_15;

import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/15.
 */
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       char[] chars = s.toCharArray();
       int m=0;
       int n=0;
       int mm[] = new int[3];
       int nn[] = new int[3];
       for(int i=0;i<3;i++){
           int c= chars[i]-'0';
           m=m+c;
           mm[i] = 9-c;
       }
       for(int i=3;i<6;i++){
           int c=chars[i]-'0';
           n=n+c;
           nn[i-3] = 9-c;
       }
       if(m==n){
           System.out.print(0);
       }
       if(m>n){
           int gap =m-n;
           int max=Math.max(nn[0],Math.max(nn[1],nn[2]));
           int min=Math.min(nn[0],Math.min(nn[1],nn[2]));
           if(gap<=max){
               System.out.print(1);
           }else if (gap>(nn[0]+nn[1]+nn[2]-min)){
               System.out.print(3);
           }else {
               System.out.print(2);
           }
       }else if(m<n){
           int gap =n-m;
           int max=Math.max(mm[0],Math.max(mm[1],mm[2]));
           int min=Math.min(mm[0],Math.min(mm[1],mm[2]));
           if(gap<=max){
               System.out.print(1);
           }else if (gap>(mm[0]+mm[1]+mm[2]-min)){
               System.out.print(3);
           }else {
               System.out.print(2);
           }
       }
    }
}
