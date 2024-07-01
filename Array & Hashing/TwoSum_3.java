import java.util.*;

public class TwoSum_3 {

    public int[] twoSum(int[] nums, int target) {

    int[] results = new int[2];

    HashMap<Integer, Integer> maps = new  HashMap<Integer, Integer>();
        
    
    for(int i=0; i<nums.length;i++){
        if(maps.containsKey(nums[i])){
            results[0] = maps.get(nums[i]);
            results[1] = i;
                break;
        }
        else
            maps.put(target - nums[i], i);
    }
    
    return results;
  }

  public static void main(String[] args) {
    // int result[] = twoSum(new int[] { 3, 2 , 3 }, 6);
    // System.out.println(result[0]);
    // System.out.println(result[1]);
  }
}
