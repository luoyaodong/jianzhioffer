package jumpFloor;

/**
 * Created by yaodongluo on 2018/7/9.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorIISolution {
    public int JumpFloorII(int target){
        if(target==0){
            return 1;
        }
        if(target==1){
            return 1;
        }
        int count = 0;
        for(int i = target-1;i>=0;i--){

            count = count+JumpFloorII(i);

        }
        return count;

    }
}
