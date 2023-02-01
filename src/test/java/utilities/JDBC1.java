package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBC1 {
    public static void main(String[] args) throws SQLException {


        //Create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin");

        //Statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //stt.execute("Select * from jobs");

        //READ DATA
      //  ResultSet rs = stt.executeQuery("select * from jobs");
        //printing all the job_title
//        while(rs.next()) {
//            System.out.println(rs.getString("job_id"));
//            System.out.println(rs.getString("job_title"));
//            System.out.println(rs.getString("min_salary"));
//            System.out.println(rs.getString("max_salary"));
//            System.out.println("   ");
//        }
//

       // printCountries(stt); //calling method into main method
        //   printDepartments(stt);

        //updateEmail(stt);

        updateAllEmails(stt);

    }

    private static void updateAllEmails(Statement stt) throws SQLException{
        //1 write a query to get all emails in a result set
        String emailQuery = "Select email from employees";
        ResultSet rs= stt.executeQuery(emailQuery);
        rs.next();

       // 2 iterate through your rs and put all emails into arraylist
        ArrayList<String> emailList = new ArrayList<>();
        while(rs.next()) emailList.add(rs.getString("email"));
        System.out.println(emailList);

        ArrayList<String> newEmailList = new ArrayList<>();
        //3 iterate thruogh arraylist and change emails from @tutorial.org to @mindtek.edu
        for(String email: emailList){
            System.out.println("Current: " + email);
           email =  email.substring(0,email.indexOf('@')) + "@mindtek.edu"; // replacing with @mindtek.edu
            System.out.println("New: " +email);
           newEmailList.add(email);
        }
        //4 print your new list
        System.out.println(emailList);
        System.out.println(newEmailList);

        //Adding changes to DataBase
        String updateQuery = "update employees set email = newEmail where employees.email = oldEmail";

        int i=0;
        for (String email: emailList) {
           updateQuery =  "update employees set email = '" + newEmailList.get(i) +"' where employees.email = '" +emailList.get(i) +"'";
           stt.executeUpdate(updateQuery);
           i++;
        }
        System.out.println(updateQuery);





    }

    private static void updateEmail(Statement stt) throws SQLException{

        ResultSet rs = stt.executeQuery("update employees set email = 'asg@gmail.com' where employees.employee_id = 103");
    }

    private static void printDepartments(Statement stt) throws SQLException{

        ResultSet rs = stt.executeQuery("select  country_id,count(department_name)from departments d, locations l\n" +
                "where d.location_id = l.location_id\n" +
                "group by country_id");
        while (rs.next()) {
            System.out.println(rs.getString("country_id")+ " -> "+rs.getString("count"));
        }


    }

    public static void printCountries(Statement stt) throws SQLException{
        ResultSet rs = stt.executeQuery("Select * from countries");
        int i=1;
        while (rs.next()){
            System.out.println(i+" -> " + rs.getString("country_name"));
            i++;
        }






    }






}
