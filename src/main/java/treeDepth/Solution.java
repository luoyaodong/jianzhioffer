package treeDepth;

import beans.TreeNode;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by yaodongluo on 2018/9/18.
 */
//代码错的不能将stack弹出干净
public class Solution {
    public static int TreeDepth(TreeNode root) {
        int max =0;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (root!=null||!stack1.isEmpty()){
            while (root!=null){
                stack1.push(root);
                stack2.push(root);
                root = root.left;
            }
            if(!stack1.isEmpty()){
                root = stack1.peek();
                stack1.pop();
                if(root.right==null){
                    if(max<stack2.size()){
                        max = stack2.size();
                    }
                    stack2.pop();
                }
                root = root.right;
            }
        }
        return max;
    }
    static int getDepth2(TreeNode root){
//        int max =0;
//        LinkedHashMap<TreeNode,Boolean> stack = new LinkedHashMap<>();
//
//        while(root!=null||!stack.isEmpty()){
//            while (root!=null){
//                stack.put(root,false);
//                root = root.left;
//            }
//            if(!stack.isEmpty()){
//                Iterator<Map.Entry<TreeNode,Boolean>> iterator = stack.entrySet().iterator();
//                Map.Entry<TreeNode,Boolean> tail = null;
//                while (iterator.hasNext()){
//                    tail = iterator.next();
//                }
//                root = tail.getKey();
//                if(root.right!=null){
//                    tail.setValue(true);
//                    root = root.right;
//                    break;
//                }else {
//                }
//
//
//            }
//        }
        int pos =0;
        Stack<TreeNode> stack  = new Stack<>();
        Stack<Boolean> tags = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                tags.push(false);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.peek();
                if(root.right!=null){
                    tags.pop();
                    tags.push(true);
                    root = root.right;
                    break;
                }else {
                    tags.pop();
                    stack.pop();
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        System.out.print( TreeDepth(root));
    }
}
