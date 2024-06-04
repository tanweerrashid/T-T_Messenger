package Data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 08127340
 */
public class palin {

    public static void printPalindromes(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String str2=str.substring(i, j);
                    if(str2.length()<=1) continue;

                else if(isPalindrome(str2)==true){
                    System.out.println(str2);
                }
            }
        }
    }

    public static boolean isPalindrome(String st){
        String strev=new StringBuffer(st).reverse().toString();
        if(strev.equals(st)==true)
            return true;
        else
            return false;
    }


    public static void main(String[] arfs) {
        printPalindromes("civiccivic");
    }
}
  
