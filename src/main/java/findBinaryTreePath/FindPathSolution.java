package findBinaryTreePath;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yaodongluo on 2018/7/23.
 */
public class FindPathSolution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathArray = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int sum=0;
        AddPaths(target,sum,path,pathArray,root);
        return pathArray;
    }

    private void AddPaths(int target,int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathArray, TreeNode root) {
        if(root==null) return;
        path.add(root.val);
        sum+=root.val;
        //&&root.left==null&&root.right==null
        if(sum == target&&root.left==null&&root.right==null){
            pathArray.add(path);
        }

        if(root.left!=null||root.right!=null){
            if(root.left!=null){
                int temp = sum;
                ArrayList<Integer> tempPath = new ArrayList<>();
                for(int i:path){
                    tempPath.add(i);
                }
                AddPaths(target,temp,tempPath,pathArray,root.left);

            }
            if(root.right!=null){
                int temp = sum;
                ArrayList<Integer> tempPath = new ArrayList<>();
                for(int i:path){
                    tempPath.add(i);
                }
                AddPaths(target,temp,tempPath,pathArray,root.right);
            }
        }

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        FindPathSolution solution = new FindPathSolution();
        ArrayList<ArrayList<Integer>> path = solution.FindPath(root,22);
        System.out.print(path);
    }
}
