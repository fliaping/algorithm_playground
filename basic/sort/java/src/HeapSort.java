/**
 * Created by Payne on 3/26/16.
 * 堆排序
 *
 * 原理:
 *     利用堆这种数据结构的性质:即子节点的键值或索引总是大(小)于它的父节点.
 *     那么经过堆调整,根节点一定是最大(小),这时,将最后一个数和根节点互换,那么最后一个数为最大,可看做有序列.
 *     此时有序列从后往前,从大(小)到小(大)扩展.
 *     再对(n-1)长度的数进行堆调整,根节点(第一个数)为未排序中最大,再次与未排序中最后一个交换,此时有序列长度+1,无序列长度-1
 *     再对(n-2)长度的数进行堆调整,以此类推,直到有序列长度扩展到n
 *
 *
 */
public class HeapSort {


    public static void heapSort(int data[]){
        buildMaxHeapify(data);   //得到大根堆
        print(data);
        System.out.println("");
        System.out.println("");
        for (int i = data.length-1; i > 0; i--) { //将大根堆最大值逐步加入有序列
            int temp = data[0];    //交换未排序中最大值到已排序位置
            data[0] = data[i];
            data[i] = temp;

            max_Heapify2(data,i,0);  //交换破坏了大根堆的结构,需要再次调整为大根堆
            //max_Heapify1(data,0,i-1);
        }

    }

    /**
     * 创建大根堆
     * 因为大根堆调整函数max_Heapify有局部性,只保证最末端子节点小于父节点,不保证整个结构为大根堆
     * 所以,需要自下而上逐步调整,使所有节点都满足子节点小于父节点
     * @param data 待调整数据
     */
    public static void buildMaxHeapify(int data[]){
        //有子节点的才需要创建最大堆,从最后一个父节点开始
        for (int i = (data.length-1-1)/2; i >= 0; i--) { //从倒数第一个父节点开始,最后一层叶子节点不需要调整
            max_Heapify2(data,data.length,i);
            //max_Heapify1(data,i,data.length);
        }
    }

    /**
     * 循环实现
     * @param data
     * @param start
     * @param end
     */
    public static void max_Heapify1(int data[],int start,int end){
        int dad = start;
        int son = dad*2+1;
        while (son < end){
            int maxSon = ((son+1)<end) && (data[son+1] > data[son]) ? (son+1) : son;
            if(data[dad] < data[maxSon]){
                int temp = data[dad];
                data[dad] = data[maxSon];
                data[maxSon] = temp;

                dad = maxSon;
                son = dad * 2 + 1;
            }else return;
        }

    }

    /**
     * 递归实现
     * @param data  待排序数组
     * @param heapSize 需创建最大堆的大小,即
     * @param dad 父节点下标
     */
    public static void max_Heapify2(int data[],int heapSize,int dad){

        int sonL = dad*2+1;
        int sonR = sonL+1;
        int max = dad;         //检测以该父节点和两个子节点是否满足堆要求
        if(sonL < heapSize && data[dad]<data[sonL]){
            max = sonL;
        }
        if(sonR < heapSize && data[max]<data[sonR]){
            max = sonR;
        }
        if(max != dad){             //若不符合要求,交换最大子节点与父节点的值,将最大子节点的位置看做新的父节点,递归处理
            int temp = data[dad];
            data[dad] = data[max];
            data[max] = temp;

            max_Heapify2(data,heapSize,max);
        }
    }

    private static void print(int[] data){
        int pre = -2;
        for (int i = 0; i < data.length; i++) {
            if (pre < (int)getLog(i+1)) {
                pre = (int)getLog(i+1);
                System.out.println();
            }
            System.out.print(data[i] + " |");
        }
    }

    /**
     * 以2为底的对数
     * @param param
     * @return
     */
    private static double getLog(double param){
        return Math.log(param)/Math.log(2);
    }
}
