/**
 * Created by Payne on 3/25/16.
 * 直接插入排序
 *
 * 原理:
 * 对于每个未排序数据,在已排序中从后向前扫描,找到相应位置并插入
 *
 * 步骤:
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果被扫描的元素（已排序）大于新元素，将该元素后移一位
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤2~5
 */
class InsertionSort {

	//插入排序
	public static void insertionSort(int data[]){
		int length = data.length;
		for(int i=1;i<length;i++){
			if(data[i] < data[i-1]){  //未排序中的第一个数(data[i])小于已排序中最后一个数(data[i-1])
				int temp = data[i];   //表明data[i]一定要插在已排序中,不能作为(新有序)中的最后一个,将这个数暂存temp
				data[i]=data[i-1];    //前面已经经过比较,应该在data[i-1]之前,直接将data[i-1]后移
				int index = i-1;      //此时temp的位置暂定为data[i-1]之前的位置,但此时data[i-1]看一看做空
				for(int j=i-2;j>=0;j--){  //从data[i-2]开始,倒着和temp比较,注意此时和temp比较的都是有序列
					if(temp<data[j]){    //如果temp小于有序列中的一个数,将这个数后移,
						data[j+1]=data[j];
						index = j;       //temp暂定为这个数的位置
					}else break;        //temp大于有序列中一个数,表明temp就在这个数后面,不用再比较了
				}
				data[index] = temp;    //将temp放到正确的位置
			}
		}
	}
}