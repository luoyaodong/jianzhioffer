package verifySquenceOfBST;

/**
 * Created by yaodongluo on 2018/7/17.
 */
public class VerifySquenceOfBSTSolution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        int root = sequence[sequence.length-1];
        int divide = 0;
        boolean flag = false;

        for(int i=0;i<sequence.length;i++){
            if (sequence[i]<root) continue;
            else{
                for(int temp = i;temp<sequence.length-1;temp++){
                    if(sequence[temp]>root){
                        continue;
                    }else{
                        return false;
                    }

                }
                divide=i;
                break;
            }

        }


        int[] left = new int[divide];
        int[] right = new int[sequence.length-divide-1];

        for(int i=0;i<divide;i++){
            left[i] = sequence[i];
        }
        for(int i = 0;i<sequence.length-divide-1;i++){
            right[i] = sequence[divide+i];
        }

        boolean leftboolean;
        boolean rightboolean;
        if(left.length<2){
            leftboolean=true;
        }else {
            leftboolean=VerifySquenceOfBST(left);
        }
        if(right.length<2){
            rightboolean=true;
        }else {
            rightboolean=VerifySquenceOfBST(right);
        }

        flag = leftboolean&&rightboolean;
        return flag;
    }
    public static void main(String[] args){
        int[] array = {4,6,7,5};
        VerifySquenceOfBSTSolution solution = new VerifySquenceOfBSTSolution();
        System.out.print(solution.VerifySquenceOfBST(array));
    }
}
