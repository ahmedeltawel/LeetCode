public class ProductofArrayExceptSelf_6 {
    
    public static int[] productExceptSelf(int[] nums) {

        int[] ascd = new int[nums.length];
        int[] desc = new int[nums.length];

        int sofar = 1; 
        for (int i = 0; i < nums.length; i++) {
            sofar *= nums[i];
            ascd[i] = sofar;
        }

        sofar = 1; 
        for (int i = nums.length - 1; i >= 0; i--) {
            sofar *= nums[i];
            desc[i] = sofar;
        }

        int [] result = new int[nums.length];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = ascd[i-1] * desc[i+1];
        }
        result[0] = desc[1];
        result[nums.length-1] = ascd[nums.length-2];

        return result;
        
    }



    public static void main(String[] args) {
        int[] test = new int[] { 2,4,6,8 };
        System.out.println(productExceptSelf(test));
    }



    
}
