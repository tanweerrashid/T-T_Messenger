/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientCore;

import Data.DataPacket;
import ClientGUI.MainScreen;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Rashid
 */
public class Comm {

    public static void transmit(DataPacket dp) {
        try {
            Socket s = new Socket(Global.SERVER_IP, Global.PORT_NO_CLIENT_TO_SERVER);
            ObjectOutputStream toServer = new ObjectOutputStream(s.getOutputStream());

            toServer.writeObject(dp);
            toServer.flush();
            toServer.close();

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "Transmitter: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static String receive() {
        String res = "";
        try {
            ServerSocket ss = new ServerSocket(Global.PORT_NO_SERVER_TO_CLIENT);
            while (true) {
                Socket s = ss.accept();
                ObjectInputStream fromServer = new ObjectInputStream(s.getInputStream());

                DataPacket dp = (DataPacket)fromServer.readObject();

                switch (dp.getID()) {
                    case DataPacket.REQUEST_FOR_STARTUP_DATA:
                        
                }
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "Receiver: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

}
