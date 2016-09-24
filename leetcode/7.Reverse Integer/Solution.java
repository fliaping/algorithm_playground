class Solution {
  //该方法比较愚蠢，先将整数放入字符数组，再从字符数组中逐个读取并加到结果整数上，还要处理相关的溢出，
  //包括位阶相乘的溢出和结果相加的溢出。
  /**
  关于溢出又可以说一通，加减法的溢出，异号不溢出，同号才会溢，判断结果如果和加数符号不同即溢出。
  乘法的溢出，可以用一个大的数据类型保存结果，与需要判断溢出的类型的最大/最小值比较，这个方法不好，
  再大的类型总会有溢出，一种方法是将结果除以一个乘数，看结果是不是另一乘数。
  
  当然从汇编的角度来判断溢出可以用双符号位
  **/
  public int reverse(int x) {
    char[] number = new char[10];
    for (int i = 0; i < number.length; i++) {
      number[i] = '\n';
    }
    boolean isNegative = false;
    if(x < 0){
      isNegative = true;
      x *= -1;
    }
    int p = 0;
    while (x != 0) {
      number[p++] = (char)(x % 10 + '0');
      x /= 10;
    }
    int result = 0;
    long b = 1;
    for (int i = 9; i >= 0; i--) {
      if (number[i]!='\n') {
        
        int m = number[i] - '0';
        
        long add = m * b; //位阶相乘的溢出
        if (add > Integer.MAX_VALUE || add < Integer.MIN_VALUE) {
          return 0 ;
        }
        result += add;
        b*=10;
        
      }
    }
    //System.out.println(result);
    if (isNegative) { //
      result *= -1;
      if (result > 0) {
        return 0;
      }
    }else {
      if (result < 0) {
        return 0;
      }
    }
    
    return result ;
  }
  
  public static void main(String[] args) {
    
    Solution s = new Solution();
    
    System.out.println(-32%10);
    
  }
  
}
