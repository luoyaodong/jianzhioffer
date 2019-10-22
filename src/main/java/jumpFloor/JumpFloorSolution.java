package jumpFloor;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class JumpFloorSolution {
    public int JumpFloor(int target){
        if(target==0){
            return 1;
        }
        if(target==1){
            return 1;
        }
        return JumpFloor(target-2)+JumpFloor(target-1);
    }
}
