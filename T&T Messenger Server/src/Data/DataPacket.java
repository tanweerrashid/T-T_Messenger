/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.io.Serializable;

/**
 *
 * @author Rashid
 */
public class DataPacket implements Serializable {

    public static final int LOGIN_DATA = 1;
    public static final int LOGOUT_DATA = 2;
    public static final int MESSAGE_DATA = 3;
    public static final int LOGIN_AUTHENTICATION_SUCCESSFULL = 4;
    public static final int LOGIN_AUTHENTICATION_FAILED = 5;
    public static final int REQUEST_FOR_STARTUP_DATA = 6;

    private int id;
    private Object[] data;

    public DataPacket(int id, Object[] data) {
        this.id = id;
        this.data = data;
    }

    public int getID() {
        return id;
    }

    public Object[] getData() {
        return data;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + id + "\n";

        int i = 0;
        while (i < data.length) {
            s = s + data[i] + "\n";
            i++;
        }

        return s;
    }

}
