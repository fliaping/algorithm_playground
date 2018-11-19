/**
 * Created by Payne on 3/27/16.
 * 快速排序
 *
 * 原理:
 *      采用分治法思想,将整个序列分通过进行"分区"的操作,将一个"基准"数放在正确排序的位置,基准数两边分为两个子区域.
 *      对每个区域,再进行"分区"操作,每个子区又分为两个子区,并分别将各自的一个"基准"数放到正确的位置
 *      知道没有区要分记得到已排序序列
 */
public class QuickSort {
    public static void quickSort(int data[]){
        sort(data,0,data.length-1);
    }

    public static void sort(int data[],int left,int right){
        if(left > right){
            return;
        }
        int storeIndex = partition(data,left,right);
        sort(data,left,storeIndex-1);
        sort(data,storeIndex+1,right);
    }
    public static int partition(int data[],int left,int right){
        int storeIndex = left;
        int pivotIndex = right;
        for (int i = left; i < right; i++) {
            if(data[i] < data[pivotIndex]){
                swap(data,i,storeIndex);

                storeIndex++;
            }
        }
        swap(data,storeIndex,pivotIndex);
        return storeIndex;
    }

    public static void swap(int data[],int a,int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
