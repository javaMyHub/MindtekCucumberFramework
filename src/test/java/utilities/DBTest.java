package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        DB db = new DB();

//        String query = "insert into countries values ('TU', 'Turkiye', 3)";
//        db.runInsertQuery(query);


        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("first_name");
        columnNames.add("last_name");
        columnNames.add("phone_number");

       ResultSet rs = db.runSelectQuery(columnNames,"employees");
       while (rs.next()) System.out.println(rs.getString("first_name") + " " + rs.getString("phone_number"));
       // List<Map<String,Object>> list = db.getTableForQuery(q);
       // System.out.println(list);

        db.close(); // this is to close connection with dataBase
    }
}
