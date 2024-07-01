import java.sql.Array;

class Longest_Palindrom_5 {

    public static String longestPalindrome(String s) {
        String srev = new StringBuilder(s).reverse().toString();
        int[][] dpArray = new int[s.length()][s.length()];
        for (int i = 0; i < dpArray.length; i++) {
            dpArray[i][i] = 1;
        }
        int max = 1;
        int newmax = 1;
        int from = 0;
        int to = 0;
        for (int i = 0; i < dpArray.length; i++) {
            int t = i;
            for (int j = 0; j < dpArray.length - i; j++) {
                if (j == t)
                    dpArray[j][t] = 1;
                else {
                    int diff = t - j;
                    if (diff == 1) {
                        if (s.charAt(j) == s.charAt(t)) {
                            dpArray[j][t] = 1;
                            from = j;
                            to = t;
                        } else
                            dpArray[j][t] = 0;
                    } else {
                        if (dpArray[j + 1][t - 1] > 0) {
                            if (s.charAt(j) == s.charAt(t)) {
                                newmax = dpArray[j + 1][t - 1] + 1;
                                dpArray[j][t] = newmax;
                                from = j;
                                to = t;
                                if (newmax > max)
                                    max = newmax;
                            } else
                                dpArray[j][t] = 0;
                        } else
                            dpArray[j][t] = 0;
                    }

                }
                t++;
            }
        }
        return s.substring(from, to+1);
    }

    public static void main(String[] args) {
        System.out.println( longestPalindrome("cbbabbabbbabbd"));
           
    }
}