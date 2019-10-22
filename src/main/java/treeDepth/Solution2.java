package treeDepth;

import beans.TreeNode;

/**
 * Created by yaodongluo on 2019/6/27.
 */
public class Solution2 {
    private boolean isbanlance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isbanlance;
    }

    private int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left-right)>1){
            isbanlance = false;
        }
        return right>left?right+1:left+1;
    }

}
