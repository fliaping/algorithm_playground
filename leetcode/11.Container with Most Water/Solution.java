public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        /*
        for(int i = 0; i< height.length; i++){
            if(i>0 && height[i]<height[i-1]) continue;
            for(int j=i+1; j< height.length;j++){
                int minHeight = height[i] > height[j] ? height[j] : height[i];
                int area = (j-i) * minHeight;
                if(area > max) max = area;
            }
        }*/
        int l = 0, r = height.length-1;
        while (l<r){
            
            int minHeight = height[l] > height[r] ? height[r] : height[l];
            int area = (r-l) * minHeight;
            //第一次手写比较不过，用了 Math.max/min 就过，然后手动比较的也过了？？？
            //max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
             //System.out.println(area);
             
            if(area > max) max = area;
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
           
        }
        
        return max;
    }
}
