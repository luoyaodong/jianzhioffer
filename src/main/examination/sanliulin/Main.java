package sanliulin;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by yaodongluo on 2018/8/27.
 */
public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int array[] = new int[M];
        for(int i=0;i<M;i++){
            array[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int array2[] = new int[q];
        for(int i=0;i<q;i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<Integer>();
            for(int j = m-1;j<n;j++){
                set.add(array[j]);
            }
            array2[i]=set.size();
        }
        for(int i=0;i<array2.length;i++){
            System.out.println(array2[i]);
        }

    }
}
