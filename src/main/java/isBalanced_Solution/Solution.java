package isBalanced_Solution;

import beans.TreeNode;

import java.util.Stack;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return true;
    }
    static void PreOder(TreeNode root){
        if(root==null){
            return;
        }
        boolean flage = false;
        while(root!=null){
            IsBalace(root.left);
            IsBalace(root.right);
        }
    }
    static boolean IsBalace(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        return true;
    }
}
