import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonDao {

    public static ResultSet get(String qry) {

        ResultSet rslt = null;

        try {
            Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost/harvest", "root", "1234");
            Statement stm = dbcon.createStatement();

            rslt = stm.executeQuery(qry);

        } catch (Exception e) {
            System.out.println("Database Error" + e);
        }
        return rslt;
    }

    public static String modify(String qry) {

        String msg ="0";

        try {
            Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost/harvest", "root", "1234");
            Statement stm = dbcon.createStatement();
            int rows = stm.executeUpdate(qry);

            if (rows!=0) {
                msg="1";
            }

        } catch (Exception e) {
            System.out.println("Database Error as : " + e);
            msg = "Database Error";
        }
        return msg;
    }
}
