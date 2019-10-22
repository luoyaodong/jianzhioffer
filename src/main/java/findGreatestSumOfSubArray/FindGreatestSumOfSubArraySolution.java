package findGreatestSumOfSubArray;

/**
 * Created by yaodongluo on 2018/9/12.
 */
public class FindGreatestSumOfSubArraySolution {
    public int FindGreatestSumOfSubArray(int[] array){
        int[][] a = new int[array.length][array.length];
        int max =-10000000;
        for(int i=0;i<array.length;i++){
            int temp = array[i];
            int sum =array[i];
            for(int j=i+1;j<array.length;j++){
               sum = sum+array[j];
               a[i][j] = sum;
               if(sum>max){
                   max =sum;
               }
               if(temp>max){
                   max =temp;
               }
            }
        }
        System.out.print(max);
        return max;
    }
    public static void main(String args[]){
        int a[] = {-2,-8,-1,-5,-9};
        FindGreatestSumOfSubArraySolution f = new FindGreatestSumOfSubArraySolution();
        f.FindGreatestSumOfSubArray(a);
    }
}
