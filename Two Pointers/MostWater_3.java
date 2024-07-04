public class MostWater_3 {

    public static int maxArea(int[] height) {
        
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

        while(left<right && height[left]<=h)
            left++;
        while(left<right && height[right]<=h)
            right--;    
            
    }

        return max;
    
    }


    public static void main(String[] args) {
        int[] test = {2,3,10,5,7,8,9};
        System.out.println(maxArea(test));
    }
    
}
