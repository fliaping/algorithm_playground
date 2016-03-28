/**
 * Created by Payne on 3/27/16.
 * 归并排序
 *
 * 原理:
 *      **先分解再合并**
 *
 *      先将整个序列看做是n个长度是1的序列,此时每个序列一个元素,可看做已经有序.
 *      合并这n个序列为n/2个长度为2的数列,合并的同时保证每个数列有序
 *      不断增加每个序列的长度,直到合并为一个长度为n的序列
 *
 */
public class MergeSort {
    public static void mergeSort(int data[]){
        int len = data.length;
        int [] temp = new int[len];
        merge_recursive(data,temp,0,len-1);

    }

    /**
     * 归并到长度为(end-start)的序列暂时放到temp中
     * @param data
     * @param temp
     * @param start
     * @param end
     */
    public static void merge_recursive(int data[],int temp[],int start,int end){
        if(start >= end){
            return;
        }
        //TODO:分析为何len不是(end-start+1)
        int len = end - start,mid = len/2 + start;
        int start1 = start,end1 = mid;
        int start2 = mid+1,end2 = end;
        merge_recursive(data,temp,start1,end1);
        merge_recursive(data,temp,start2,end2);
        int index = start;
        //TODO: 待详细分析
        while (start1 <= end1 && start2 <= end2){
            temp[index++] = data[start1] < data[start2] ? data[start1++] : data[start2++];
        }
        while (start1 <= end1){
            temp[index++] = data[start1++];
        }
        while (start2 <= end2){
            temp[index++] = data[start2++];
        }

        for (int i = start; i <= end; i++) {
            data[i] = temp[i];
        }
    }
}
