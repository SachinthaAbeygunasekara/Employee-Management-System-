import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesignationDao {

    public static Designation getById(int id) {

        Designation designation = new Designation();

        try {

            String qry = "Select * from designation where id=" + id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();

            designation.setId(rslt.getInt("id"));
            designation.setName(rslt.getObject("name").toString());

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return designation;

    }

    public static List<Designation> getAll() {

        List<Designation> designations = new ArrayList<Designation>();

        try {

            String qry = "Select * from designation";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                Designation designation = new Designation();
                designation.setId(rslt.getInt("id"));
                designation.setName(rslt.getObject("name").toString());

                designations.add(designation);
            }

        }

        catch (SQLException e) {
            System.out.println("Database Error" + e.getMessage());
        }
        return designations;

    }

}
