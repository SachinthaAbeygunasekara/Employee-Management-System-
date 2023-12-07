import java.util.List;

public class EmployeeController {
    public static List<Employee> get(){

        List<Employee> employees = EmployeeDao.getAll();

        return employees;
        
    }
}
