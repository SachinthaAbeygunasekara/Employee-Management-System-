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

    public static List<Employee> getAllByDesignation(Designation designation) {
        String qry = "Select * from employee where designation_id = " + designation.getId() + " ";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static List<Employee> getAllByNameAndGender(String name, Gender gender) {

        String qry = "Select * from employee where name like '" + name + "%' and gender_id = " + gender.getId() + " ";
        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByNameAndDesignation(String name, Designation designation) {
        String qry = "Select * from employee where name like '" + name + "%' and designation_id = " + designation.getId() + " ";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static List<Employee> getAllByGenderAndDesignation(Gender gender, Designation designation) {
        String qry = "Select * from employee where designation_id= " + designation.getId() + " and gender_id = " + gender.getId() + " ";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static List<Employee> getAllByNameAndGenderAndDesignation(String name,Gender gender, Designation designation) {
        String qry = "Select * from employee where name like '" + name + "%' and gender_id = " + gender.getId() + " and designation_id=" + designation.getId() +" ";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static Employee getByNic(String nic) {

        Employee employee = null;

        String qry = "select * from employee where nic='" + nic + "' ";

        try {
            ResultSet rslt = CommonDao.get(qry);

            if (rslt != null && rslt.next()) {

                employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getObject("name").toString());
                employee.setNic(rslt.getObject("nic").toString());
                employee.setDob(LocalDate.parse((rslt.getObject("dob").toString())));
                employee.setMobile(rslt.getObject("mobile").toString());
                employee.setEmail(rslt.getObject("email").toString());
                employee.setDesignation(DesignationDao.getById(rslt.getInt("designation_id")));
                employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));
                employee.setEmployeeStatus(EmployeeStatusDao.getById(rslt.getInt("employeestatus_id")));
            }
        } catch (Exception e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return employee;
    }

    public static String save(Employee employee) {

        String msg = "";

        String qry = "insert into employee(name,dob,nic,mobile,email,gender_id,employeestatus_id,designation_id) values ('"
                + employee.getName()
                + "','" + employee.getDob()
                + "','" + employee.getNic()
                + "','" + employee.getMobile() + "','" + employee.getEmail() + "'," + employee.getGender().getId() + ","
                + employee.getEmployeeStatus().getId() + "," + employee.getDesignation().getId() + ")";

        msg = CommonDao.modify(qry);
        return msg;
    }

    public static String update(Employee employee) {
        String msg = "";

        String qry = "UPDATE employee set name='" + employee.getName() + "',dob='" + employee.getDob() + "',nic='"
                + employee.getNic() + "',mobile='" + employee.getMobile() + "',email='" + employee.getEmail()
                + "',gender_id=" + employee.getGender().getId() + ",employeestatus_id="
                + employee.getEmployeeStatus().getId() + ",designation_id=" + employee.getDesignation().getId()
                + " where id=" + employee.getId() + " ";

        msg = CommonDao.modify(qry);
        return msg;
    }

    public static String delete(Employee oldEmployee) {
        String msg = "";

        String qry = "DELETE from employee where id=" + oldEmployee.getId() + "";

        msg = CommonDao.modify(qry);
        return msg;
    }

}
