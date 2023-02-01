package utilities;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC2 {
    public static void main(String[] args) throws SQLException {
        //Create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin");

        //Statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from employees";
        ResultSet rs = stt.executeQuery(query);
//        rs.next();
//        rs.next();
//        System.out.println(rs.getString("first_name") + " " +  rs.getString("email"));
        ResultSetMetaData rsMeta = rs.getMetaData();
//        System.out.println("Column count: " + rsMeta.getColumnCount());
//        System.out.println("Column name: " + rsMeta.getColumnName(2));
//        System.out.println("Table name: " + rsMeta.getTableName(4));
//        System.out.println(rsMeta.isCurrency(8));
//        System.out.println("Is THIS Nullable: " + rsMeta.isNullable(5));
//
//        for (int i=1; i<=rsMeta.getColumnCount(); i++){
//            System.out.println("Column number " + i + ": " + rsMeta.getColumnName(i));
//        }

        Map<Integer, String> map = new HashMap<>();
        map.put(5,"Madison");
        map.put(6,"Wisconsin");
        map.put(7,"Milwaukee");

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(5,"Appleton");
        map1.put(6,"Oshkosh");
        map1.put(7,"Sun Prairie");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(5,"Paris");
        map2.put(6,"Milan");
        map2.put(7,"Venice");

       List<Map<Integer,String>> list = new ArrayList<>();
       list.add(map);
       list.add(map1);
       list.add(map2);
       System.out.println(list);

       for(int i=0; i<list.size(); i++){
           System.out.println("Map #"+(i+1));
           for(int j=5; j<8; j++){
               System.out.println(list.get(i).get(j));
           }
           System.out.println("---------");
       }
    }
}
