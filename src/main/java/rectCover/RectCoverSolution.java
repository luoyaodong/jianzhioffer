package rectCover;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class RectCoverSolution {
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }
        return Cover(target);


    }

    private int Cover(int target) {
        if(target==0){
            return 1;
        }
        if(target==1){
            return 1;
        }
        return Cover(target-1)+Cover(target-2);
    }
}
