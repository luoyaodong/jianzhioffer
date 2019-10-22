package sortAlgorithm;

/**
 * Created by yaodongluo on 2018/8/17.
 */
public class SortSolution {
    //时间复杂度n2 稳定

    public void BubbleSort(int input[]){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length-1-i;j++){
                if(input[j]>input[j+1]){
                    Swap(input,j,j+1);
                }
            }
        }
        return ;
    }
    public void MyBubbleSort(int input[]){
        for(int i=1;i<input.length;i++){
            for(int j=0;j<input.length-i;j++){
                if(input[j]>input[j+1]){
                    Swap(input,j,j+1);
                }
            }
        }
        return;
    }
    //时间复杂度n2 不稳定
    public void SelectSort(int input[]){
        for(int i=0;i<input.length;i++){
            int min = i;
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[min]){
                    min = j;

                }
            }
            if(i!=min){
                Swap(input,i,min);
            }
        }
    }
    //插入排序时间复杂度n2
    public void InsertSort(int input[]){
        for(int i=1;i<input.length;i++){
            int j =0;
            int temp = input[i];
            for(j=i;j>0&&input[j-1]>temp;j--){
                input[j] = input[j-1];
            }
            input[j] = temp;
        }

    }

    public void InserSort2(int input[]){
        for(int i=1;i<input.length;i++){
            for(int j=i;j>0;j--){
                if(input[j]<input[j-1]){
                    Swap(input,j,j-1);
                }
            }
        }
    }

    public void MyInertSort(int input[]){
        for(int i=0;i<input.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(input[j]<input[j-1]){
                    Swap(input,j,j-1);
                }
            }
        }
        return;
    }
    public void ShellSort(int input[]){
        int j = 0;
        int temp = 0;
        for(int increment = input.length/2;increment>0;increment/=2){
            for(int i=increment;i<input.length;i++){
                temp = input[i];
                for(j=i;j>=increment&&temp<input[j-increment];j-=increment){
                    input[j] = input[j-increment];
                }
                input[j] = temp;
            }

        }
    }

    //快速排序时间复杂度nlogn，空间不稳定n
    public void Quick(int input[]){
        if(input.length>0){
            QuickSort(input,0,input.length-1);
        }

    }


    public void QuickSort(int input[],int low,int high){
        if(low<high){
            int pivot =getPivot(input,low,high);
            QuickSort(input,low,pivot-1);
            QuickSort(input,pivot+1,high);
        }
    }
    private int getPivot(int input[],int low, int high){
        int pivot = input[low];
        while (low<high){
            while ((low<high&&input[high]>pivot)){
                high--;
            }
            input[low] = input[high];
            while (low<high&&input[low]<pivot){
                low++;
            }
            input[high] = input[low];
            input[low] = pivot;
        }
        return low;
    }

    public static void Merge(int input[],int low,int mid, int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k=0;
        //把较小的数先移入新的数组中
        while(i<=mid&&j<=high){
            if(input[i]<input[j]){
                temp[k++] = input[i++];
            }else {
                temp[k++] = input[j++];
            }
        }
        while (i<=mid){
            temp[k++] = input[i++];
        }
        while (j<=high){
            temp[k++] = input[j++];
        }

        //这里有一个非常细节的点
        for(int m=0;m<temp.length;m++){
            input[m+low] = temp[m];
        }
    }
    public void MergeStart(int input[],int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            MergeStart(input,low,mid);
            MergeStart(input,mid+1,high);
            Merge(input,low,mid,high);
        }
    }
    public void MergeSort(int input[]){
        MergeStart(input,0,input.length-1);
    }

    public void buildMaxHeap(int input[],int lastindex){
        for(int i=(lastindex-1)/2;i>=0;i--){
            int k=i;
            while (k*2+1<=lastindex){
                int biggerIndex = 2*k+1;
                if(biggerIndex<lastindex){
                    if(input[biggerIndex]<input[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(input[k]<input[biggerIndex]){
                    Swap(input,k,biggerIndex);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }

    }
    public void HeapSort(int[] input){
        for(int i=0;i<input.length;i++){
            buildMaxHeap(input,input.length-i-1);
            Swap(input,0,input.length-1-i);
        }
    }

    private void Swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }


    public static void main(String args[]){
        SortSolution solution = new SortSolution();
        int input[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
        String a ="abc";
        a.split("a");
//        solution.BubbleSort(input);
//        solution.MyBubbleSort(input);
//        solution.MyInertSort(input);
//        solution.InsertSort(input);
//        solution.Quick(input);
//        solution.ShellSort(input);
//        solution.MergeSort(input);
        solution.InserSort2(input);
//        solution.HeapSort(input);
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
    }
}
