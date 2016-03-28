import java.util.*;
import java.io.*;

class RandomNumber {

	private Random random = new Random();
	
	public void getIntArray(int[] array,int count){
		for(int i=0;i<array.length;i++){
			array[i] = getIntRandom(count);
		}
	}
	public void getDoubleArray(double[] array,int integerCount,int decimalCount){
		for(int i=0;i<array.length;i++){
			array[i] = getDoubleRandom(integerCount,decimalCount);
		}
	}

	/**
	 * 获取一个随机整数
	 * @param count 整数位数
	 * @return 随机整数
     */
	private  int getIntRandom(int count){
		int max = 1;
		for (int i=0;i<count && i<10;i++) {  //int型最大位数10位
			max *= 10;
		}
		int result;
		if(random.nextInt(2)==0){  //随机正负值
			result = random.nextInt(max);
		}else {
			result = random.nextInt(max)*(-1);
			
		}
		return result;
	}

	/**
	 * 获取一个随机小数
	 * @param integerCount 小数的整数位数
	 * @param decimalCount 小数的小数位数
     * @return 随机小数
     */
	private double getDoubleRandom(int integerCount,int decimalCount){
		int integerMax =1, decimalMax = 1;
		double decimal = 1;
		for (int i=0;i<integerCount && i<10;i++) {//位数太多显示时是科学计数法,所以做了限制
			integerMax *= 10;
		}
		for (int i=0;i<decimalCount && i<10;i++) {
			decimalMax *= 10;
			decimal *= 0.1;
		}
		double result;
		if(random.nextInt(2)==0){     //随机正负值
			result = random.nextInt(integerMax);
		}else {
			result = random.nextInt(integerMax)*(-1);
		}
		result += random.nextInt(decimalMax)*decimal;
		return result;
	}
}