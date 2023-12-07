import java.util.List;

public class DesignationController {

    public static List<Designation> get() {

        List<Designation> designation =DesignationDao.getAll();

        return designation;

    }
}
