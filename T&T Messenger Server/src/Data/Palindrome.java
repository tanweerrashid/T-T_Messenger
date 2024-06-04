/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author Rashid
 */
public class Palindrome {

    public static void main(String[] a) {
        printPalindromes("civiccivic");
    }

    public static void printPalindromes(String st) {
        for (int i = 0; i < st.length(); i++) {
            for (int j = i + 1; j < st.length(); j++) {
                String temp = st.substring(i, j);
                if (temp.length() > 1) {
                    if (isPalindrome(temp) == true) {
                        System.out.println(temp);
                    }
                }
            }
        }
    }

    public static boolean isPalindrome(String st) {
        boolean b = true;

        int i = 0;
        int j = st.length() - 1;

        while ((i < j) && (b == true)) {
            String left = st.charAt(i) + "";
            String right = st.charAt(j) + "";;

            if  (right.compareTo(left) == 0) {
                i = i + 1;
                j = j - 1;
            }
            else {
                b = false;
            }
        }

        return b;
    }

}
