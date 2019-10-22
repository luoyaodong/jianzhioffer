package printBinaryTree;

import beans.TreeNode;

import java.util.ArrayList;

/**
 * Created by yaodongluo on 2018/7/17.
 */
public class printBinaryTreeSolution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        return printTree(nodeList,list);
    }

    private ArrayList<Integer> printTree(ArrayList<TreeNode> nodeList, ArrayList<Integer> list) {
        if(nodeList.isEmpty()){
            return list;
        }
        ArrayList<TreeNode> nextList = new ArrayList<TreeNode>();
        for(TreeNode n:nodeList){
            if(n.left!=null){
                nextList.add(n.left);
            }
            if(n.right!=null){
                nextList.add(n.right);
            }
            list.add(n.val);
        }
        return printTree(nextList, list);
    }
}
