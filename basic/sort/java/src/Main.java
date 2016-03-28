/**
 * Created by Payne on 3/26/16.
 */
public class Main {
    public static void main(String[] args) {
        //随机生成待排序的数据
        RandomNumber rn = new RandomNumber();
        int data[] = new int[9];
        rn.getIntArray(data,2);
        //data = new int[]{-95, -80, -51, 32, -19, 82, -51, 78, 16};
        printArray(data);

        //InsertionSort.insertionSort(data);
        //ShellSort.shellSort(data);
        //SelectionSort.selectionSort(data);
        //HeapSort.heapSort(data);
        //QuickSort.quickSort(data);
        MergeSort.mergeSort(data);
        printArray(data);

    }

    public static void printArray(int arr[]){
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}
