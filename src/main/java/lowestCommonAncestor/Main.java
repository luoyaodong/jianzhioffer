package lowestCommonAncestor;

import beans.TreeNode;

import java.util.*;

/**
 * Created by yaodongluo on 2018/9/17.
 */
public class Main {
    public static TreeNode LowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        findPath2(root,p,pstack);
        findPath2(root,q,qstack);
        while (!pstack.isEmpty()){
            if(qstack.contains(pstack.peek())){
                return pstack.peek();
            }else{
                pstack.pop();
            }
        }
        return root;
    }

    //这个先序遍历二叉树的非递归实现
    private static void findPath(TreeNode root, TreeNode p,Stack<TreeNode> stack ) {
        //非递归实现

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                if (root == p) {
                    return;
                }
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.peek();
                stack.pop();
                root = root.right;
            }
        }
    }
    public static void findPath2(TreeNode root,TreeNode p,Stack<TreeNode> path){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                path.add(root);
                root = root.left;
                if(root==p){
                    return;
                }
            }
            if (!stack.isEmpty()) {
                root = stack.peek();
                stack.pop();
                if(root.right==null){
                    path.pop();
                }
                root = root.right;
                if(root==p){
                    return;
                }
            }
        }
    }
    //这个代码非常简洁
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l != null && r != null?root : l == null?r: l;
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;
        TreeNode node = LowestCommonAncestor(root,p,q);
        System.out.print(node.val);
    }
}
