public class MostWater_3 {

    public int maxArea(int[] height) {
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int w = 0;
        int h = 0;
        while(left<right){
            h = Math.min(height[right],height[left]);
            w = right - left ;
            if(max<(w*h)){
                max = w*h;
            }

        if(height[right]>height[left])
            left++;
        else
            right--;    
            
    }

        return max;
    
    }
    
}
