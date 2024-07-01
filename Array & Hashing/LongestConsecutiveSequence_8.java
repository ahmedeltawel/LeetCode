import java.util.*;


public class LongestConsecutiveSequence_8 {


    public static int longestConsecutive(int[] nums) {
    
        Set<Integer> mySet = new HashSet<Integer> ();

        HashMap<Integer, List<Integer>> seq = new HashMap<Integer, List<Integer>>();

        for (int i : nums) {
            mySet.add(i);
        }

        
        for (Integer i : mySet) {
            if(!mySet.contains(i-1)){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                for(int x = i+1; mySet.contains(x); x++){
                    temp.add(x);
                }
                seq.put(i,temp);
            }
        }

        int highest = 0;
        for (Integer key : seq.keySet()) {
            List<Integer> temp = seq.get(key);
            int len = temp.size();
            if(len>highest) highest=len;
        }

     

        return highest;

    }

    public static void main(String[] args) {
        
        int[] test = new int[] {1,3,5,2,4};
        System.out.println(longestConsecutive(test));
    }
    
}
