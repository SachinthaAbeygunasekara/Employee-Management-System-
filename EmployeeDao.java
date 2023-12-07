import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static List<Employee> get(String qry) {

        List<Employee> employees = new ArrayList<Employee>();

        try {

            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                Employee employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getObject("name").toString());
                employee.setNic(rslt.getObject("nic").toString());
                employee.setDob(LocalDate.parse((rslt.getObject("dob").toString())));
                employee.setMobile(rslt.getObject("mobile").toString());
                employee.setEmail(rslt.getObject("email").toString());
                employee.setDesignation(DesignationDao.getById(rslt.getInt("designation_id")));
                employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));
                employee.setEmployeeStatus(EmployeeStatusDao.getById(rslt.getInt("employeestatus_id")));

                employees.add(employee);
            }

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return employees;

    }

    public static List<Employee> getAll() {

        String qry = "Select * from employee";
        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByName(String name) {

        String qry = "Select * from employee where name like '" + name + "%' ";
        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByGender(Gender gender) {

        String qry = "Select * from employee where gender_id = " + gender.getId() + " ";
        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByNameAndGender(String name, Gender gender) {

        String qry = "Select * from employee where name like '" + name + "%' and gender_id = " + gender.getId() +" ";
        List<Employee> employees = get(qry);
        return employees;

    }

}
