import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class EmployeeController {
    public static List<Employee> get(Hashtable<String,Object> ht){

        List<Employee> employees = new ArrayList<>();

        if(ht == null){
            employees = EmployeeDao.getAll();
        }

        else{

            String name = (String) ht.get("name");
            Gender gender = (Gender) ht.get("gender");

            if (gender == null) {
                employees = EmployeeDao.getAllByName(name);
            }
            else if (name == null){
                employees = EmployeeDao.getAllByGender(gender);
            }
            else{
                employees = EmployeeDao.getAllByNameAndGender(name,gender);
            }
        }

        return employees;
        
    }

    public static String post(Employee employee) {
        String msg="";
        String err="";

        LocalDate today = LocalDate.now();
        int age = today.getYear() - employee.getDob().getYear();

        if(age<20){
            err = err +"\nMust be 20 years";
        }

        Employee empNic = EmployeeDao.getByNic(employee.getNic());

        if (empNic != null) {
            err = err + "\nNic Exits";
        }

        if (err.isEmpty()) {
            String dberr = EmployeeDao.save(employee);
            if (dberr.equals("1")) {
                msg="1";
            }else{
                msg = "DB Error as : "+dberr;
            }
             
        }
        else{
            msg = "Data Errors : \n"+err; 
        }
       
        return msg;
    }
}
