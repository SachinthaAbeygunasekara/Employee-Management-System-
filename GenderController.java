import java.util.List;

public class GenderController {

    public static List<Gender> get() {

        List<Gender> genders = GenderDao.getAll();

        return genders;

    }
}
