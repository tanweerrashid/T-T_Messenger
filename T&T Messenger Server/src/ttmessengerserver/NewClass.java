/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ttmessengerserver;

/**
 *
 * @author Rashid
 */
public class NewClass {

    public static void main(String[] args) {
        System.out.println(a(0));
    }
    public static int a(int i) {
        return b(i - 3) + c(2 + i);
    }
    public static int b(int i) {
        return c(i - 2) + 2;
    }
    public static int c(int i) {
        int j = ++i;
        return j - 2;
    }

}
