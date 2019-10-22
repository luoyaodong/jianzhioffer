package permutation;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by yaodongluo on 2018/8/15.
 */
public class PermutationSolution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        TreeSet<String> treeSet = new TreeSet<String>();
        //这点也非常重要
        if(str==""){
            return null;
        }
        if(str==null || str.length()==0){
            return arrayList;
        }

        char c[] = str.toCharArray();
        ArrayList<Character> charArray = new ArrayList<Character>();
        for(int i=0;i<c.length;i++){
            charArray.add(c[i]);
        }

//        char array[][] = new char[c.length][c.length];
//构造一个n×n的数组
//        for(int i = 0;i<c.length;i++){
//            for(int j =0;j<c.length;j++){
//                array[i][j] = c[(j+i)%c.length];
//            }
//        }

        ArrayList<Character> temp = new ArrayList<Character>();
        PermutationCharArray(temp,charArray,treeSet);

        for(String a:treeSet){
            arrayList.add(a);

        }
        return  arrayList;
    }

    private void PermutationCharArray(ArrayList<Character> temp,ArrayList<Character> c,TreeSet<String> treeSet){
        if(c.size()==0){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<temp.size();i++){
                sb.append(temp.get(i));

            }
            treeSet.add(sb.toString());
            return;
        }
        for(int i=0;i<c.size();i++){
            //非常重要，list的复制

            ArrayList<Character> cutTemp = new ArrayList<Character>();
            cutTemp.addAll(temp);
            cutTemp.add(c.get(i));

            ArrayList<Character> cutCharArray = new ArrayList<Character>();
            cutCharArray.addAll(c);
            cutCharArray.remove(i);

            PermutationCharArray(cutTemp,cutCharArray,treeSet);
        }
    }
    public static void main(String args[]){
        PermutationSolution solution = new PermutationSolution();
        System.out.print(solution.Permutation("aba"));

    }
}
