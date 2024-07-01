import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class threeSum_2 {


    static Set<List<Integer>> unique = new LinkedHashSet<List<Integer>>();
    static List<List<Integer>> result = new ArrayList<List<Integer>>();



    public static void addUniqueList(List<Integer> newList) {
        List<Integer> copyOfNewList = new ArrayList<>(newList);
        if (unique.add(copyOfNewList)) {
            result.add(copyOfNewList);
        }
    }
        public static List<List<Integer>> threeSum_2(int[] nums) { // Input: nums = [-1,0,1,2,-1,-4]

            Arrays.sort(nums);


            int l = 0;
            int r = nums.length-1;
            int sum = 0;
            int first = 0;
            List<Integer> sums = new ArrayList<Integer>(3);
           
            for (int i=0;i<nums.length;i++) {
                first = nums[i];
                l = i+1;
                r = nums.length-1;
                while(l<r){
                sum = first + nums[l] + nums[r]; 
                if(sum<0){
                    l++;
                }
                else if(sum>0){
                    r--;
                }
                else {
                    sums.add(first);
                    sums.add(nums[l]);
                    sums.add(nums[r]);
                    addUniqueList(sums);
                    sum = 0;
                    sums.clear();
                    l++;
                    r = nums.length-1;
                }
            }
            

        }

            return result;
            

    }

    public static void main(String[] args) {
        int[] test = {-2,0,1,1,2};
        System.out.println(threeSum_2(test));

    }




}
