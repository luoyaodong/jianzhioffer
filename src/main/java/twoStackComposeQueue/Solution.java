package twoStackComposeQueue;

import java.util.Stack;

/**
 * Created by yaodongluo on 2018/7/6.
 * 总结：java中的形参是复制实参的一份拷贝（对于引用型则是复制引用的拷贝）（在栈中的拷贝），
 * 所以在函数中改变形参是无法改变实参的值的，改变引用只是将形参所代表的引用指向另外的新的对象，
 * 而实参的引用还指向原来的对象，改变形参引用的成员当然会影响实参引用成员的值，因为他们的引用都指向同一个对象
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
//    错误方法
//    public void push(int node){
//        this.stack1.push(node);
//
//        this.stack2 = copyStack(this.stack1);
//
//    }
//
//    public int pop(){
//        int pop = this.stack2.pop();
//        //指针指向的stack推出了，所以最后的stack1给清空了
//        this.stack1 = copyStack(this.stack2);
//        return  pop;
//    }
//    private Stack<Integer> copyStack(Stack<Integer> stack){
//        Stack<Integer> newStack1 = new Stack<Integer>();
//        Stack<Integer> newStack2 = new Stack<Integer>();
//
//        newStack1 = stack;
//        while (!newStack1.isEmpty()){
//            newStack2.push(newStack1.pop());
//        }
//        return newStack2;
//    }

    public void push(int node){
        stack1.push(node);

    }

    public int pop(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }


    public static void main(String args[]){
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.pop();
        solution.pop();
        solution.push(4);
        solution.push(5);
        solution.pop();
        solution.pop();
    }


}

