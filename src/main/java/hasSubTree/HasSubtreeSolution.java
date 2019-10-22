package hasSubTree;

import beans.TreeNode;
import reConstructBinaryTree.Solution;

/**
 * Created by yaodongluo on 2018/7/12.
 */
public class HasSubtreeSolution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root2 == null) return false;
        while (root1!=null){
            if(SubTree(root1,root2)){return true;}
            if(SubTree(root1.left,root2)) {return true;}
            if(SubTree(root1.right,root2)) {return true;}
            return false;
        }
        return false;
    }

    private boolean SubTree(TreeNode root1, TreeNode root2) {
        if(root1==null)return false;
        if(root1.val == root2.val){
            if(root2.left!=null&&root2.right==null){
                return SubTree(root1.left,root2.left);
            }else if(root2.left==null&&root2.right!=null){
                return SubTree(root1.right,root2.right);
            }else if(root2.left!=null&&root2.right!=null){
                boolean flag1 = SubTree(root1.left,root2.left);
                boolean flag2 = SubTree(root1.right,root2.right);
                return flag1&&flag2;
            }else{
                return true;
            }
        }else {
            return false;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(7);
        TreeNode subTreeRoot = new TreeNode(8);
        subTreeRoot.left = new TreeNode(9);
        subTreeRoot.right = new TreeNode(2);
        HasSubtreeSolution solution = new HasSubtreeSolution();
        boolean flag = solution.HasSubtree(root,subTreeRoot);
        System.out.print(flag);
    }
}
