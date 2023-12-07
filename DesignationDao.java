import java.sql.ResultSet;
import java.sql.SQLException;

public class DesignationDao {

    public static Designation getById(int id){

    Designation designation = new Designation();

        try {
            
            String qry = "Select * from designation where id="+id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();

            designation.setId(rslt.getInt("id"));
            designation.setName(rslt.getObject("name").toString());

        } 
        
        catch (SQLException e) {
            System.out.println("Database Error"+e.getMessage());
        }
        return designation;

        
    }
    
}

