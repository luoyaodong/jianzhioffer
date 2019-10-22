package findContinuousSequence;

/**
 * Created by yaodongluo on 2019/7/29.
 */
import java.util.ArrayList;

public class FindContinuousSequence {
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        for(int i=sum/2+1;i>1;i--){
            function1(i,sum);
        }

    return arrayLists;
    }

    private void function1(int i,int sum) {

        if(i<2) return;
        ArrayList<Integer> list = new ArrayList<>();
        int topedge = sum -i+1;

        for(int j=1;j<topedge;j++){
            int s = 0;
            s = (2*j+i-1)*i/2;
            if(s==sum){
                for(int m =0;m<i;m++){
                    list.add(j+m);
                }
                arrayLists.add(list);
            }
        }

    }

    public static void main(String args[]){
        FindContinuousSequence sequence = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = sequence.FindContinuousSequence(3);
        System.out.print(lists);
    }
}


