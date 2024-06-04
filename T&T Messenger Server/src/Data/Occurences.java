/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.util.StringTokenizer;

/**
 *
 * @author Rashid
 */
public class Occurences {

    public static void printOccurences(String para, String words) {
        StringTokenizer stWords = new StringTokenizer(words, " ");
        int count = 0;

        while (stWords.hasMoreTokens()) {
            StringTokenizer stPara = new StringTokenizer(para, " ");
            count = 0;
            String temp = stWords.nextToken();
            while (stPara.hasMoreTokens()) {
                if (temp.compareToIgnoreCase(stPara.nextToken()) == 0) {
                    count = count + 1;
                }
            }
            System.out.println(temp + ": " + count);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        printOccurences("I am sooo happy after this test. " +
                "I think I am going to get an A. I am sooo happy. Happy is my life",
                "happy sooo am");
    }

}
