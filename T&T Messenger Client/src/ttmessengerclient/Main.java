/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ttmessengerclient;

import ClientCore.Comm;
import ClientGUI.LoginScreen;

/**
 *
 * @author Rashid
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginScreen ls = new LoginScreen();
        ls.setVisible(true);
        ls.receive();
        
        Comm.receive();
    }

}
