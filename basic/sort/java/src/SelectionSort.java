/**
 * Created by Payne on 3/26/16.
 * 直接选择排序
 *
 * 原理:
 *      逐步找出数列中第一小(大),第二小(大)........第N小(大)
 *
 * 算法描述:
 *      总:从未排序中找出最小(大),放到已排序尾部,直到未排序为空
 *      1.整个数列可看做是未排序数列,找到最小(大)值,与数列第一个交换,则有序数列长度为1,未排序数列长度为n-1
 *      2.继续在未排序中找最小(大),与数列第二个交换
 *      3.以此类推,直到所有元素排序完毕
 */
public class SelectionSort {
    public static  void selectionSort(int data[]){
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int min = data[i],minIndex = i;
            for (int j = i; j < len; j++) {
                if(data[j] < min){
                    min = data[j];
                    minIndex = j;
                }
            }
            data[minIndex] = data[i];
            data[i] = min;
        }
    }
}
