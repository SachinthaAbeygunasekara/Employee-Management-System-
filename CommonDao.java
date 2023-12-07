import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonDao {
    
    public static ResultSet get(String qry){

        ResultSet rslt=null;

        try {
        Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost/harvest","root","1234");
        Statement stm = dbcon.createStatement();

        rslt = stm.executeQuery(qry);

        } catch (Exception e) {
            System.out.println("Database Error"+e);
        }
        return rslt;
    }
}
