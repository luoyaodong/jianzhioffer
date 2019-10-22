package reverseBinaryTree;

import beans.TreeNode;

/**
 * Created by yaodongluo on 2018/7/8.
 */
public class Solution {
    public TreeNode reverseBinaryTree(TreeNode root){
        TreeNode reverseRoot = reverse(root);
        //另外一种解法
        // return Mirror(root);
        return reverseRoot;


    }
    private TreeNode reverse(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = root.right;
        newRoot.right = root.left;
        newRoot.left = reverse(root.right);
        newRoot.right = reverse(root.left);
        return newRoot;
    }
    public TreeNode Mirror(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode dummyLeft = root.left;
        TreeNode dummyRight = root.right;
        root.left = dummyRight;
        root.right = dummyLeft;
        root.left = Mirror(dummyRight);
        root.right = Mirror(dummyLeft);
        return root;
    }
    public static void main(String args[]){
        int[] in = {5,6,7,8,9,10,11};
        int[] pre = {8,6,5,7,10,9,11};
        reConstructBinaryTree.Solution buildTree = new reConstructBinaryTree.Solution();
        Solution solution = new Solution();
        TreeNode root = buildTree.reConstructBinaryTree(pre,in);
        TreeNode reverseRoot = solution.reverseBinaryTree(root);
        printBinaryTree.Solution printTree = new printBinaryTree.Solution();
        printTree.printBinaryTree(root);
        printTree.printBinaryTree(reverseRoot);

    }
}
