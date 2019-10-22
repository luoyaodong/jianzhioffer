package bytedance9_9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yaodongluo on 2018/9/9.
 */
public class Main2 {

        /**
         * @param s the IP string
         * @return All possible valid IP addresses
         */
        public ArrayList<String> restoreIpAddresses(String s) {
            // Write your code here
            ArrayList<String> result = new ArrayList<String>();
            String temp = new String();
            search(s , temp , result , 4 , 0 , s.length());
            return result;
        }

        public void search(String s , String temp , ArrayList<String> result , int count , int index , int len){
            //index 操作到字符串第几个字符
            //count 操作到IP第几位
            if(count == 0 && index == len){
                result.add(temp);
                return ;
            }
            if((count == 0 && index < len) || (count > 0  && index == len)){
                return ;
            }

            int value = 0;
            boolean flag = true;//第一个字符是否为0标志
            while(index < len && flag){
                if(value == 0 && s.charAt(index) == '0'){
                    flag = false;
                }
                value = value * 10 + s.charAt(index) - '0';
                index++;
                if(value < 256){
                    String record = "";
                    if(count == 1){
                        record = temp + Integer.toString(value);
                    }else{
                        record = temp + Integer.toString(value) + '.';
                    }

                    search(s , record , result , count - 1 , index , len);
                }
            }
        }
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            Main2 m = new Main2();
            ArrayList<String> ss = m.restoreIpAddresses(s);
            System.out.println(ss.size());
        }
}
