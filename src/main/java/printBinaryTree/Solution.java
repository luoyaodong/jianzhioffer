package printBinaryTree;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongluo on 2018/7/8.
 */
public class Solution {
    public void printBinaryTree(TreeNode root){
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        printBinaryTree(queue);

    }

    private void printBinaryTree(List<TreeNode> queue) {
        List<TreeNode> newqueue = new ArrayList<TreeNode>();
        if(queue.isEmpty()){
            return;

        }
        for (TreeNode node:queue) {
            if(node.left!=null){
                newqueue.add(node.left);
            }
            if(node.right!=null){
                newqueue.add(node.right);
            }
            System.out.print(node.val);
        }
        System.out.println(" ");
        printBinaryTree(newqueue);
    }


    public static void main(String args[]){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree.Solution buildTree = new reConstructBinaryTree.Solution();
        TreeNode root = buildTree.reConstructBinaryTree(pre,in);
        Solution print = new Solution();
        print.printBinaryTree(root);
    }
}
