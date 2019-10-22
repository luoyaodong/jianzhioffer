package convertBinaryTreeToList;

import beans.TreeNode;

/**
 * Created by yaodongluo on 2018/8/6.
 */
public class ConvertBinaryTreeToListSolution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return pRootOfTree;
        }
        TreeNode mostleft = pRootOfTree;
        while (mostleft.left!=null){
            mostleft = mostleft.left;
        }

        adjust(pRootOfTree);
        return mostleft;
    }
    private void adjust(TreeNode pRootOfTree){
        if(pRootOfTree.left!=null){
            TreeNode mostRight = pRootOfTree.left;
            while (mostRight.right!=null){
                mostRight = mostRight.right;
            }
            adjust(pRootOfTree.left);
            mostRight.right = pRootOfTree;
            pRootOfTree.left = mostRight;
        }
        if(pRootOfTree.right!=null){
            TreeNode mostLeft = pRootOfTree.right;
            while (mostLeft.left!=null){
                mostLeft = mostLeft.left;
            }
            adjust(pRootOfTree.right);
            pRootOfTree.right = mostLeft;
            mostLeft.left = pRootOfTree;
        }
        return;

    }
    public static void main(String args[]){
        ConvertBinaryTreeToListSolution solution = new ConvertBinaryTreeToListSolution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode head = solution.Convert(root);

    }
}
