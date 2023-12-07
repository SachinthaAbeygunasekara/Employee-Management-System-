import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeStatusDao {

    public static EmployeeStatus getById(int id){

    EmployeeStatus employeeStatus = new EmployeeStatus();

        try {
            
            String qry = "Select * from employeeStatus where id="+id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();

            employeeStatus.setId(rslt.getInt("id"));
            employeeStatus.setName(rslt.getObject("name").toString());

        } 
        
        catch (SQLException e) {
            System.out.println("Database Error"+e.getMessage());
        }
        return employeeStatus;

        
    }
    
}

