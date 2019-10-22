package stackSolution;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by yaodongluo on 2018/7/16.
 */
public class StackSolution {
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        //错误方法compare函数把stack的内在顺序给改变了
//        Collections.sort(stack, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        return stack.peek();
        int min = stack.peek();
        Iterator<Integer> iterable = stack.iterator();
        while (iterable.hasNext()){
            int temp = iterable.next();
            if(min>temp){
                min = temp;
            }
        }
        return min;

    }

    public static void main(String args[]){

        StackSolution solution = new StackSolution();
        solution.push(3);
        System.out.print(solution.min());
        solution.push(4);
        System.out.print(solution.min());
        solution.push(2);
        System.out.print(solution.min());
        solution.push(3);
        System.out.print(solution.min());
        solution.pop();
        System.out.print(solution.min());
        solution.pop();
        System.out.print(solution.min());
        solution.pop();
        System.out.print(solution.min());
        solution.push(0);
        System.out.print(solution.min());
    }
}
