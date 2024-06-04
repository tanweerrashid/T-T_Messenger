/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerCore;

import Data.DataPacket;
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
            Socket s = new Socket(Global.SERVER_IP, Global.PORT_NO_SERVER_TO_CLIENT);
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

    public static void receive() {
        try {
            ServerSocket ss = new ServerSocket(Global.PORT_NO_CLIENT_TO_SERVER);
            while (true) {
                Socket s = ss.accept();
                ObjectInputStream fromClient = new ObjectInputStream(s.getInputStream());

                DataPacket dp = (DataPacket)fromClient.readObject();

                System.out.println("RECIEVED DATA FROM CLIENT");
                
                switch (dp.getID()) {
                    case DataPacket.LOGIN_DATA: Actions.initLogin(dp.getData());
                    break;
                    
                    case DataPacket.LOGOUT_DATA: Actions.initLogout();
                    break;
                }
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "Receiver: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
        }
    }

}
