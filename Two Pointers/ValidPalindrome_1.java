



public class ValidPalindrome_1{

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();

        for (int i = 0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(Character.isLetterOrDigit(temp))
                sb.append(temp);
        }

        int mid = sb.length()/2 ;
        int end = sb.length()-1;
        System.out.println(sb.toString());
        for (int i = 0; i < mid; i++) {
            if(sb.charAt(i)!=sb.charAt(end-i))
                return false;
        }

        return true;
        
        
    }
    
    



    public static void main(String[] args) {
        isPalindrome("race a car");
    }
    
}