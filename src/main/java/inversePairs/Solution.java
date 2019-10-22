package inversePairs;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Solution {
    public int InversePairs(int [] array) {
        int num=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<i;j++){
                if(array[j]>array[i]){
                    num++;
                }
            }
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    num++;
                }
            }
        }
        return num/2;
    }
//    public static void main(String args[]){
//        Solution solution = new Solution();
//        int[] array = {1,2,3,4,5,6,7,0};
//        System.out.print(solution.InversePairs(array));
//    }
}
