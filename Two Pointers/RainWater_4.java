public class RainWater_4 {

    public int trap(int[] height) {
    
            int left = 0;
            int right = 1;
    
            int max = height[0];
            int max2 = 0;
    
            for(int i =1; i< height.length; i++){
                if(height[i]>=height[i-1]){
                if(height[i]> max){
                    max = height[i];
                    left = i;
                    right = i+1;
                    break;
                }
                }
                else{
                    left = i-1;
                    right = i;
                    max = height[i-1];
                    break;
                }
    
            }
            
            max2 = height[right];
             for(int i =right+1; i< height.length; i++){
                if(height[right]>max2){
                    max2 = height[right];
                    left = i;
                    right = i+1;
                    break;
                }
             }
             return -1;
        }
    }
    

