import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<EmployeeStatus> getAll() {

        List<EmployeeStatus> employeesStatus = new ArrayList<EmployeeStatus>();

        try {

            String qry = "Select * from employeestatus";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                EmployeeStatus employeeStatus = new EmployeeStatus();
                employeeStatus.setId(rslt.getInt("id"));
                employeeStatus.setName(rslt.getObject("name").toString());

                employeesStatus.add(employeeStatus);
            }

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return employeesStatus;

    }
    
}

