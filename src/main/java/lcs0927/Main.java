package lcs0927;

/**
 * Created by yaodongluo on 2018/9/27.
 */
public class Main {
    public static void main(String args[]){
        String s ="abcbda";
        String t = "bdcaba";
        int[][] array = lcs(s,t);
        printLcs(s,array,s.length(),t.length());

    }
    private static void printLcs(String s,int[][] b,int i,int j){
        if(i==0||j==0){
            return;
        }
        if(b[i-1][j-1] == 10){
            printLcs(s,b,i-1,j-1);
            System.out.print(s.charAt(i-1));
        }else if(b[i-1][j-1] == 9){
            printLcs(s,b,i-1,j);
        }else{
            printLcs(s,b,i,j-1);
        }
    }
    private static int[][] lcs(String s,String t){
        //10 means 左上 ,9,means 左，11 means 上
        int[][] c = new int[s.length()+1][t.length()+1];
        int[][] b =new int[s.length()][t.length()];

        for(int i=0;i<s.length()+1;i++){
            c[0][i]=0;
        }

        for(int i=0;i<t.length()+1;i++){
            c[i][0]=0;
        }

        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i-1][j-1] = 10;
                }else{
                    if(c[i][j-1]>=c[i-1][j]){
                        c[i][j] = c[i-1][j];
                        b[i-1][j-1] = 11;
                    }else {
                        c[i][j] = c[i][j-1];
                        b[i-1][j-1] = 9;
                    }
                }
            }
        }

        return b;
    }
}
