package isPopOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaodongluo on 2018/7/16.
 */
public class IsPopOrderSolution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        int length = pushA.length;
        for (int i = 0; i < length; i++) {
            a.add(pushA[i]);
            b.add(popA[i]);
        }
        return isCorrectOrder(a, b);

    }

    private boolean isCorrectOrder(List<Integer> a, List<Integer> b) {
        if (a.size() == 1) {
            if (a.get(0).equals(b.get(0))) {
                return true;
            } else {
                return false;
            }
        }
        int index = 0;
        int top = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(0)) index = i;

        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(1)) top = i;
        }
        if (top > index || top == (index - 1)) {
            a.remove(index);
            b.remove(0);
            return isCorrectOrder(a, b);
        } else {
            return false;
        }
    }

    //我的方法实在很笨，真的很笨
    //构建一个辅助栈来验证就可以了
    public boolean IsPopOrderBetter(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        IsPopOrderSolution solution = new IsPopOrderSolution();

        System.out.print(solution.IsPopOrder(a, b));
    }
}
