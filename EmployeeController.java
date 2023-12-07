import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class EmployeeController {
    public static List<Employee> get(Hashtable<String, Object> ht) {

        List<Employee> employees = new ArrayList<>();

        if (ht == null) {
            employees = EmployeeDao.getAll();
        }

        else {

            String name = (String) ht.get("name");
            Gender gender = (Gender) ht.get("gender");
            Designation designation = (Designation) ht.get("designation");
            /*
             * if (gender == null) {
             * employees = EmployeeDao.getAllByName(name);
             * } else if (name == null) {
             * employees = EmployeeDao.getAllByGender(gender);
             * } else {
             * employees = EmployeeDao.getAllByNameAndGender(name, gender);
             * }
             */

            if (!name.isEmpty() && gender == null && designation == null) {
                employees = EmployeeDao.getAllByName(name);
            }

            if (name.isEmpty() && gender != null && designation == null) {
                employees = EmployeeDao.getAllByGender(gender);
            }

            if (!name.isEmpty() && gender != null && designation == null) {
                employees = EmployeeDao.getAllByNameAndGender(name, gender);
            }

            if (name.isEmpty() && gender==null && designation!=null) {
                employees = EmployeeDao.getAllByDesignation(designation);
            }

            if (!name.isEmpty() && gender==null && designation!=null) {
                employees = EmployeeDao.getAllByNameAndDesignation(name,designation);
            }

            if (name.isEmpty() && gender!=null && designation!=null) {
                employees = EmployeeDao.getAllByGenderAndDesignation(gender,designation);
            }

            if (!name.isEmpty() && gender!=null && designation!=null) {
                employees = EmployeeDao.getAllByNameAndGenderAndDesignation(name,gender,designation);
            }
        }

        return employees;

    }

    public static String post(Employee employee) {
        String msg = "";
        String err = "";

        LocalDate today = LocalDate.now();
        int age = today.getYear() - employee.getDob().getYear();

        if (age <= 18) {
            err = err + "\nMust at least be 18 years";
        }

        Employee empNic = EmployeeDao.getByNic(employee.getNic());

        if (empNic != null) {
            err = err + "\nNic Exits";
        }

        if (err.isEmpty()) {
            String dberr = EmployeeDao.save(employee);
            if (dberr.equals("1")) {
                msg = "1";
            } else {
                msg = "DB Error as : " + dberr;
            }

        } else {
            msg = "Data Errors : \n" + err;
        }

        return msg;
    }

    public static String put(Employee employee) {
        String msg = "";
        String err = "";

        LocalDate today = LocalDate.now();
        int age = today.getYear() - employee.getDob().getYear();

        if (age < 20) {
            err = err + "\nMust be 20 years";
        }

        Employee empNic = EmployeeDao.getByNic(employee.getNic());

        if ((empNic != null) && empNic.getId() != employee.getId()) {
            err = err + "\nNic Exits";
        }

        if (err.isEmpty()) {
            String dberr = EmployeeDao.update(employee);
            if (dberr.equals("1")) {
                msg = "1";
            } else {
                msg = "DB Error as : " + dberr;
            }

        } else {
            msg = "Validation Errors : \n" + err;
        }

        return msg;
    }

    public static String delete(Employee oldEmployee) {

        String msg = "";

        String dberr = EmployeeDao.delete(oldEmployee);
        if (dberr.equals("1")) {
            msg = "1";
        } else {
            msg = "DB error as : " + dberr;
        }
        return msg;
    }
}
