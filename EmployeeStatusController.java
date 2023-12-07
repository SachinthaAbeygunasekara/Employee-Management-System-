import java.util.List;

public class EmployeeStatusController {
        public static List<EmployeeStatus> get() {

        List<EmployeeStatus>  employeestatus =EmployeeStatusDao.getAll();

        return employeestatus;

    }
}
