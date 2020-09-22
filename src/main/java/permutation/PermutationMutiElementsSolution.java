package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodongluo on 2020/9/5.
 */
public class PermutationMutiElementsSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> tempList=new ArrayList<Integer>();
        boolean used[]=new boolean[nums.length];
        backTracking(nums, result, tempList, used);
        return result;
    }

    private static void backTracking(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean []used){
        if(nums.length==tempList.size()){
            System.out.println(tempList);
            result.add(new ArrayList<Integer>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false||used[i]==true){
                    continue;
                }else{
                    used[i]=true;
                    tempList.add(nums[i]);
                    backTracking(nums, result, tempList, used);
                    used[i]=false;
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,1,3};
        PermutationMutiElementsSolution solution = new PermutationMutiElementsSolution();
        solution.permuteUnique(nums);
    }
}
