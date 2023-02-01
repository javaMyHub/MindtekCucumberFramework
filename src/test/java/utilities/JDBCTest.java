package utilities;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        //Create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin");

        //Statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //stt.execute("Select * from jobs");
        stt.execute("Select * from dependents");


        //read data
//        ResultSet rs = stt.executeQuery("select concat(e.first_name,' ', e.last_name) as parent_name, concat(d.first_name,' ', d.last_name) as child_name\n" +
//                "from employees e, dependents d\n" +
//                "where e.employee_id = d.employee_id");
//        while (rs.next()) {
//            System.out.println(rs.getString("parent_name" )+" is parent of " + rs.getString("child_name"));
//        }

//        System.out.println("                      ");
//        ResultSet rs2 = stt.executeQuery("select concat(e.first_name,' ', e.last_name) as parent_name, concat(d.first_name,' ', d.last_name) as child_name\n" +
//                "from employees e\n" +
//                "inner join dependents d\n" +
//                "on e.employee_id = d.employee_id");
//        while (rs2.next()) {
//            System.out.println(rs2.getString("parent_name" )+" is parent of " + rs2.getString("child_name"));
//        }



        //putting all emails in arrayList
       // ResultSet rs3 = stt.executeQuery("select email from employees");



//        rs.next();
//        rs.next();
//
//        System.out.println(rs.getString("job_title"));
//       rs.next();
//        System.out.println(rs.getString(1));
//
//         while(rs.next()) System.out.println(rs.getString("job_title")); //getting all the job titles
//        while(rs.next()) {
//            System.out.println(rs.getString("job_title"));
//            System.out.println(rs.getString("max_salary"));
//        }

        findDifferentEmail(cnn,stt);

        }

        private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException{

                ResultSet rs = stt.executeQuery("Select email from employees");

                ArrayList<String> emailList = new ArrayList<>();

                while(rs.next()) emailList.add(rs.getString("email"));

                boolean isWrongEmail = false;

                for (String em: emailList) {
                    if(!em.endsWith("@sqltutorial.org")) {
                        System.out.println("Wrong email: " + em);
                        isWrongEmail = true;
                    }
                }
                if(isWrongEmail) System.out.println("Found different email");
                else System.out.println("All emails are the same");

        }

    }

