import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenderDao {

    public static Gender getById(int id) {

        Gender gender = new Gender();

        try {

            String qry = "Select * from gender where id=" + id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();

            gender.setId(rslt.getInt(1));
            gender.setName(rslt.getObject(2).toString());

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e);
        }
        return gender;

    }

    public static List<Gender> getAll() {

        List<Gender> genders = new ArrayList<Gender>();

        try {

            String qry = "Select * from gender";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                Gender gender = new Gender();
                gender.setId(rslt.getInt("id"));
                gender.setName(rslt.getObject("name").toString());

                genders.add(gender);
            }

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return genders;

    }

}
