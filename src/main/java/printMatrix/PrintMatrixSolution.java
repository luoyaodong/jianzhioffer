package printMatrix;

import java.util.ArrayList;

/**
 * Created by yaodongluo on 2018/7/16.
 */
public class PrintMatrixSolution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        return printOutCircle(matrix,0,rowLength-1,0,colLength-1,array);

    }

    private ArrayList<Integer> printOutCircle(int[][] matrix,int startRow,int endRow, int startCol, int endCol,ArrayList<Integer> array) {
        if((endRow-startRow)>0&&(endCol-startCol)>0){
            for(int i =startCol;i<endCol;i++){
                array.add(matrix[startRow][i]);
            }
            for(int i=startRow;i<endRow;i++){
                array.add(matrix[i][endCol]);
            }
            for(int i=endCol;i>startCol;i--){
                array.add(matrix[endRow][i]);
            }
            for(int i=endRow;i>startRow;i--){
                array.add(matrix[i][startCol]);
            }
            array = printOutCircle(matrix,startRow+1,endRow-1,startCol+1,endCol-1,array);
        }else {
            if(endCol==startCol&&endRow==startRow){
                array.add(matrix[startRow][startCol]);
                return array;
            }else if (endRow==startRow&&endCol!=startCol){
                for(int i = startCol;i<endCol+1;i++){
                    array.add(matrix[endRow][i]);
                }
                return array;
            }else if(endCol==startCol&&endRow!=startRow){
                for(int i=startRow;i<endRow+1;i++){
                    array.add(matrix[i][startCol]);
                }
                return array;
            }else {
                return array;
            }
        }
        return array;
    }


    public static void main(String args[]){
        int[][] m= new int[4][4];
        for(int i =0;i<4;i++){
            for(int j = 0;j<4;j++){
                m[i][j] = i+j+1;
            }
        }
        int[][] n = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> array = new ArrayList<Integer>();
        PrintMatrixSolution solution = new PrintMatrixSolution();
        array = solution.printMatrix(n);
        for(int i=0;i<array.size();i++){
            System.out.print(array.get(i)+" ");
        }
    }
}
