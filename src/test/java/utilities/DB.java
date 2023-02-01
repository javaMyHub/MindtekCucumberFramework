package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB implements DBMethods{
    //Create connection:
    private Connection cnn;
    private Statement stt;
    private ResultSet rs;
    private ResultSetMetaData rsMeta;

    public Connection getCnn() {
        return cnn;
    }

    public Statement getStt() {
        return stt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public ResultSetMetaData getRsMeta() {
        return rsMeta;
    }

    public DB() throws SQLException {
        cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin");
        stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public ResultSet executeSelectQuery(String query) throws SQLException {
        rs = stt.executeQuery(query);
        return rs;
    }

    public ResultSetMetaData getMetaForRs(ResultSet resultSet) throws SQLException {
        rsMeta = resultSet.getMetaData();
        return  rsMeta;
    }

    public List<Map<String, Object>> getTableForQuery(String query) throws SQLException {
        rs = executeSelectQuery(query);
        rsMeta = getMetaForRs(rs);
        List<Map<String, Object>> tableData = new ArrayList<>();
        while(this.rs.next()){
            Map<String, Object> rowData = new HashMap<>();
            for (int order = 1; order <= rsMeta.getColumnCount(); order++){
                rowData.put(rsMeta.getColumnName(order),rs.getString(rsMeta.getColumnName(order)));
            }
            tableData.add(rowData);
        }
        return tableData;
    }

    @Override
    public ResultSet runSelectQuery(String query) throws SQLException {
        rs = stt.executeQuery(query);
        return rs;
    }

    public ResultSet runSelectQuery(String columnName, String tableName) throws SQLException {
        String query ="Select"+ columnName+" from "+tableName;
        rs = stt.executeQuery(query);
        return rs;
    }

    @Override
    public void runUpdateQuery(String query) throws SQLException {
        stt.executeUpdate(query);
        System.out.println("DB was updated ");

    }

    @Override
    public void runInsertQuery(String query) throws SQLException {
      stt.executeUpdate(query);
        System.out.println("DB was inserted");
    }

    @Override
    public void runDeleteQuery(String query) throws SQLException {
        stt.executeUpdate(query);
        System.out.println("Delete was successful");
    }


    public ResultSet runSelectQuery(ArrayList<String> columnNames, String tableName) throws SQLException {
        //select first_name, last_name, phone_number from jobs
        String query ="select " ;
        for(String cName: columnNames){
            query = query + cName + ", ";
        }
        //select first_name, last_name, phone_number
        query = query.substring(0,query.length()-2);
        query = query + " from " + tableName;
        rs = stt.executeQuery(query);
        return rs;
    }

    public void close() throws SQLException {
        stt.close();
        cnn.close();
    }
}
