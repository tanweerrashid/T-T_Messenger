/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rashid
 */
public class DBC {

    public static ResultSet runQueryWithResult(String query, String tblName) {
        ResultSet rs = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:" + tblName);
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "DBC: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public static void runQueryWithoutResult(String query, String tblName) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:" + tblName);
            Statement st = con.createStatement();
            st.execute(query);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "DBC: " + Global.PRODUCT_NAME, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:tblContactInformation");
            Statement st = con.createStatement();


            String query = "SELECT * FROM tblContactInformation";

            String query1 = "INSERT INTO tblContactInformation VALUES('rafee1', '123', 'Tanweer1 Rashid1', 'Rafee1', 'rafee2+rafee3+rafee4+rafee5+rafee6')";
            String query2 = "INSERT INTO tblContactInformation VALUES('rafee2', '456', 'Tanweer2 Rashid2', 'Rafee2', 'rafee1+rafee3+rafee4+rafee5+rafee6')";
            String query3 = "INSERT INTO tblContactInformation VALUES('rafee3', '789', 'Tanweer3 Rashid3', 'Rafee3', 'rafee1+rafee2+rafee4+rafee5+rafee6')";
            String query4 = "INSERT INTO tblContactInformation VALUES('rafee4', '101112', 'Tanweer4 Rashid4', 'Rafee4', 'rafee1+rafee2+rafee3+rafee5+rafee6')";
            String query5 = "INSERT INTO tblContactInformation VALUES('rafee5', '131415', 'Tanweer5 Rashid5', 'Rafee5', 'rafee1+rafee2+rafee3+rafee4+rafee6')";
            String query6 = "INSERT INTO tblContactInformation VALUES('rafee6', '161718', 'Tanweer6 Rashid6', 'Rafee6', 'rafee1+rafee2+rafee3+rafee4+rafee5')";

            
            //st.execute(query2);
            //st.execute(query3);
            //st.execute(query4);
            //st.execute(query5);
            //st.execute(query6);


            //st.execute("DELETE FROM tblContactInformation WHERE username='rafee4'");

            ResultSet rs = st.executeQuery(query);

            while (rs.next() == true) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t");
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex, "DB Testing", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }
}
