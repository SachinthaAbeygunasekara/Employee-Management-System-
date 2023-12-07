import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderDao {

    public static Gender getById(int id){

    Gender gender = new Gender();

        try {
            
            String qry = "Select * from gender where id="+id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();

            gender.setId(rslt.getInt(1));
            gender.setName(rslt.getObject(2).toString());

        } 
        
        catch (SQLException e) {
            System.out.println("Database Error"+e);
        }
        return gender;

        
    }
    
}
