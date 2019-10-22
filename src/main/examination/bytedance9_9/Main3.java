package bytedance9_9;

/**
 * Created by yaodongluo on 2018/9/9.
 */

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    /**
     * UTF-8编码规则
     Bits of code point    First code point    Last code point    Bytes in sequence    Byte 1    Byte 2    Byte 3    Byte 4    Byte 5    Byte 6
     U+0000    U+007F    1    0xxxxxxx
     U+0080    U+07FF    2    110xxxxx    10xxxxxx
     U+0800    U+FFFF    3    1110xxxx    10xxxxxx    10xxxxxx
     U+10000    U+1FFFFF    4    11110xxx    10xxxxxx    10xxxxxx    10xxxxxx
     U+200000    U+3FFFFFF    5    111110xx    10xxxxxx    10xxxxxx    10xxxxxx    10xxxxxx
     U+4000000    U+7FFFFFFF    6    1111110x    10xxxxxx    10xxxxxx    10xxxxxx    10xxxxxx    10xxxxxx
     */

    public static boolean isUtf8(byte[] bytes) {
        boolean flag = false;
        if (bytes != null && bytes.length > 0) {
            boolean foundStartByte = false;
            int requireByte = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte current = bytes[i];
                //当前字节小于128，标准ASCII码范围
                if ((current & 0x80) == 0x00) {
                    if (foundStartByte) {
                        foundStartByte = false;
                        requireByte = 0;
                    }
                    continue;
                    //当前以0x110开头，标记2字节编码开始，后面需紧跟1个0x10开头字节
                }else if ((current & 0xC0) == 0xC0) {
                    foundStartByte = true;
                    requireByte = 1;
                    //当前以0x1110开头，标记3字节编码开始，后面需紧跟2个0x10开头字节
                }else if ((current & 0xE0) == 0xE0) {
                    foundStartByte = true;
                    requireByte = 2;
                    //当前以0x11110开头，标记4字节编码开始，后面需紧跟3个0x10开头字节
                }else if ((current & 0xF0) == 0xF0) {
                    foundStartByte = true;
                    requireByte = 3;
                    //当前以0x111110开头，标记5字节编码开始，后面需紧跟4个0x10开头字节
                }else if ((current & 0xE8) == 0xE8) {
                    foundStartByte = true;
                    requireByte = 4;
                    //当前以0x1111110开头，标记6字节编码开始，后面需紧跟5个0x10开头字节
                }else if ((current & 0xEC) == 0xEC) {
                    foundStartByte = true;
                    requireByte = 5;
                    //当前以0x10开头，判断是否满足utf8编码规则
                }else if ((current & 0x80) == 0x80) {
                    if (foundStartByte) {
                        requireByte--;
                        //出现多个0x10开头字节，个数满足，发现utf8编码字符，直接返回
                        if (requireByte == 0) {
                            return true;
                        }
                        //虽然经当前以0x10开头，但前一字节不是以0x110|0x1110|0x11110肯定不是utf8编码，直接返回
                    }else {
                        return false;
                    }
                    //发现0x8000~0xC000之间字节，肯定不是utf8编码
                }else {
                    return false;
                }
            }
        }
        return false;
    }
    public static byte intToByte4(int i) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
//        System.out.println(targets[3]);
        return targets[3];
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int a[] = new int[M];
        byte[] bytes = new byte[M];
        ArrayList<Byte> s = new ArrayList<>();
        for(int i=0;i<M;i++){
            a[i] = in.nextInt();
            bytes[i] = intToByte4(a[i]);
        }


        if(Main3.isUtf8(bytes)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

}
