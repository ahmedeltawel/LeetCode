import java.util.*;

public class containDuplicates_1 {

  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> unique = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (unique.contains(nums[i])) {
        return true;
      } else {
        unique.add(nums[i]);
      }
    }

    return false;
  }
}
