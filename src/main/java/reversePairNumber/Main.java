package reversePairNumber;

/**
 * Created by yaodongluo on 2018/11/5.
 */
public class Main {
    static int count;
    public int InversePairs(int[] array){
        count = 0;
        mergesort(array,0,array.length-1);
        return count%1000000007;
    }

    public static void merge(int a[] , int low,int mid ,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k=0;
        while(i<=mid&&j<=high){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
                count += mid-i+1;
            }
        }
        while (i<=mid){
            temp[k++] = a[i++];
        }
        while (j<=high){
            temp[k++] = a[j++];
        }
        for(int m=0;m<temp.length;m++){
            a[low+m] = temp[m];
        }
    }
    public void  mergesort(int a[],int low, int high){
        int mid = (high+low)/2;
        if(low<high){
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void main(String args[]){
        Main m = new Main();
        int[] array = {1,2,3,0};
        System.out.print(m.InversePairs(array));
    }
}
