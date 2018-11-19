/**
 * Created by Payne on 3/26/16.
 * 原理:
 *     希尔排序是在直接插入排序的基础上进行的优化,通过将比较的的全部元素分为几个区域来提升插入排序的性能,这样可以让一个元素可以
 *     一次性朝最终位置前进一大步.
 *
 * 算法描述
 * 1.将待排序数据分为长度为gap的片段(最后一个片段长度可以小于n)
 * 2.将每个片段的相同位置的数视为一列,对每一列进行直接插入排序
 * 3.减小gap,重复2的操作
 * 4.直到gap为1,即得到有序列
 */

public class ShellSort {

    /**
     * 简洁高效版本
     * @param data 待排序数组
     */
    public static void shellSort(int data[]){
        int gap = 1,i,j,len = data.length,temp;
        while (gap < len){
            gap = gap * 3 + 1;   //这个步长时间复杂度比较好,<O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121,....
        }
        for (; gap > 0 ; gap/=3) { //步长按照上面的序列,从大到小减到1
            for ( i = gap; i < len; i++) {  //对i所在的这列进行插入排序
                temp = data[i];
                for (j = (i-gap); j >= 0 && temp < data[j] ; j-=gap) {  //直接插入排序的算法,不过注意下标,直接插入排序中找前一个数下标-1,
                    data[j+gap] = data[j];                              //这找前一个数应该减去步长
                }
                data[j+gap] = temp;
            }
        }

    }

    /**
     * myShellSort(my*) 函数自己根据算法原理写的,基础水平捉急,很多bug,调了很久,也分析为啥会这样写,为啥会出错等问题
     * @param data 待排序数组
     */
    public static void myShellSort1(int data[]){
        int gap = data.length/2;
        for (; gap > 0; gap/=2) {
                for (int i = gap; i <data.length ; i++) { //开始我尝试按照列,一列一列进行插入排序,但看到i++之后分析一下觉得没必要那样做了
                    int temp = data[i],index = i;         //感觉按列的话,比较的次数也不会少,因为
                    for (int j = (i-gap); j >= 0 ; j-=gap) {
                        if(temp<data[j]){          // 之前temp写成data[i],第一次循环时没什么问题,但在第二次时data[i]已经可能被后移的数替换
                            data[j+gap] = data[j]; //这是插入排序的最核心的地方,就是后移,为更小(大)的数腾位置
                            index = j;             //标记腾出的位置
                        }else break;
                    }
                    data[index] = temp;           //可以不用这个标记,用全局的j就行
                }
                //Main.printArray(data);
        }
    }
}
