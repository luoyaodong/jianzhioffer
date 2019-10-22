package alibaba9_7;

import java.util.*;

/**
 * Created by yaodongluo on 2018/9/7.
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int m = Integer.parseInt(stringArray[0]);
        int n = Integer.parseInt(stringArray[1]);
        String input = sc.nextLine();
        String array[] = input.split(",");
        int x[] =new int[array.length/2];
        int y[] =new int[array.length/2];
        for(int i = 0;i<array.length/2;i++){
            x[i] = Integer.parseInt(array[i]);
            y[i] = Integer.parseInt(array[i+1]);
        }
        boolean flag=false;
        double min =10000.0;
        for(int i=0;i<x.length;i++){
            if((m*m+n*n)<(x[i]*x[i]+y[i]*y[i])){
                flag =true;
            }
            double c =pointToLine(m,n,x[i],y[i],x[(i+1)/x.length],y[(i+1)/x.length]);
            if(min>c){
                min=c;
            }
        }

        if(flag=true){
            System.out.print("yes");
        }else {
            System.out.print("no");
        }
        System.out.print(",");
        System.out.print(Integer.parseInt(new java.text.DecimalFormat("0").format(min)));
    }

    private static double pointToLine(int x1, int y1, int x2, int y2, int x0,
                               int y0) {
        double space = 0;
        double a, b, c;
        a = lineSpace(x1, y1, x2, y2);// 线段的长度
        b = lineSpace(x1, y1, x0, y0);// (x1,y1)到点的距离
        c = lineSpace(x2, y2, x0, y0);// (x2,y2)到点的距离
        if (c <= 0.000001 || b <= 0.000001) {
            space = 0;
            return space;
        }
        if (a <= 0.000001) {
            space = b;
            return space;
        }
        if (c * c >= a * a + b * b) {
            space = b;
            return space;
        }
        if (b * b >= a * a + c * c) {
            space = c;
            return space;
        }
        double p = (a + b + c) / 2;// 半周长
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// 海伦公式求面积
        space = 2 * s / a;// 返回点到线的距离（利用三角形面积公式求高）
        return space;
    }
    private static double lineSpace(int x1, int y1, int x2, int y2) {
        double lineLength = 0;
        lineLength = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)
                * (y1 - y2));
        return lineLength;
    }

}
