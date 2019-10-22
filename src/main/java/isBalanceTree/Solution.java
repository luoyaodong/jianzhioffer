package isBalanceTree;

import beans.TreeNode;

/**
 * Created by yaodongluo on 2018/11/7.
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftdepth = getDepth(root.left);
        int rightdepth = getDepth(root.right);
        if(Math.abs(leftdepth-rightdepth)>1){
            return false;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        return left&&right;
    }

    private int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left>right)?(left+1):(right+1);
    }
}
