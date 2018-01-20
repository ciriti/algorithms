package it.car.wayfair.string;

/**
 * Created by carmeloiriti, 28/09/16.
 */
public class LongestPalindromicSubstring {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     *
     * @param s
     * @return
     */

    public static String longestPalindrome(String s) {
        int first = s.length();
        int second = 0;

        for (int i = 0; i < s.length(); i++) {

            int lo = i;
            int up = i;

            for (int q = 0; q < 2; q++) {

                up = up + q;

                while (lo >= 0 && up <= s.length() - 1) {

                    if (s.charAt(lo) == s.charAt(up)) {
                        if ((up - lo) > (second - first)) {
                            first = lo;
                            second = up;
                        }
                        lo--;
                        up++;

                    } else {
                        break;
                    }
                }
            }
        }

        return s.substring(first, second + 1);
    }


    public static void main(String args[]) {
        String s = "90_aba_qwertzu_bbbb_iop";
        System.out.println(longestPalindrome(s));
    }

}
