/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerCore;

import Data.DataPacket;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Rashid
 */
public class Actions {

    public static void initLogin(Object[] data) {
        try {
            String username = ((String[])data)[0];
            String password = ((String[])data)[1];

            System.out.println("QUERYING DATABASE");
            
            
            String query = "SELECT * FROM tblContactInformation";
            ResultSet rs = DBC.runQueryWithResult(query, Global.TBL_CONTACT_INFORMATION);

            System.out.println("AUTHENTICATING CONTACT INFO");
            
            boolean b = false;
            while (rs.next() == true) {
                if ((rs.getString(1).compareTo(username) == 0) && (rs.getString(2).compareTo(password) == 0)) {
                    b = true;
                }
            }

            if (b == true) {
                DataPacket dp = new DataPacket(DataPacket.LOGIN_AUTHENTICATION_SUCCESSFULL, null);
                Comm.transmit(dp);
            }
            else if (b == false) {
                DataPacket dp = new DataPacket(DataPacket.LOGIN_AUTHENTICATION_FAILED, null);
                Comm.transmit(dp);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "initLogin: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void initLogout() {

    }

}
