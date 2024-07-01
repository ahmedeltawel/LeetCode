import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements_5 {
    

    public static int[] topKFrequent(int[] nums, int k) {


    List<Integer> temp = new ArrayList<>();
    HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();


  

    for (int i = 0; i < nums.length; i++) {
        Integer value = maps.get(nums[i]);
        if (value != null)
         maps.put(nums[i], value+1);
        else   
         maps.put(nums[i], 1); 
    }

    List<Integer>[] arrayOfLists = new ArrayList[nums.length + 1];

    for (int i = 0; i < arrayOfLists.length; i++) {
        arrayOfLists[i] = new ArrayList<>();
    }

    for (Integer key : maps.keySet()) {
        int occ = maps.get(key);
        arrayOfLists[occ].add(key);
    }


    int[] result = new int[k];

int i = 0;

    for (int j = arrayOfLists.length - 1; j >= 0; j--) {
       while (arrayOfLists[j].size() != 0){
            result[i] = arrayOfLists[j].get(0);
            arrayOfLists[j].remove(0);
            i++;
            if(i==k)
                break;
       } 
       if(i==k)
       break;
    }
        

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 1,1,1,2,2,2 };
        System.out.println(topKFrequent(test, 2));
      }


}
