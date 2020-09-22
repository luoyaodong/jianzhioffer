package fibonacci;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class FibonacciSolution {
    public int Fibonacci(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        else {
           return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    public static void main(String[] args){
        FibonacciSolution fibonacciSolution = new FibonacciSolution();
        System.out.print(fibonacciSolution.Fibonacci(5));
    }
}
