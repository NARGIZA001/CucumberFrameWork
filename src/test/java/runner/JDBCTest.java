package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    // JDBC java data base connectivity
    // to connect to data base

    public static void main (String args []) throws IOException, SQLException {

        // Connection class
        // statement class
        // resultSet class these results we need to make connection with data base

        Connection connection= DriverManager.getConnection(
                Configuration.getProperties("dbHost"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword")); // we need to provide host name user name , and password

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from employees"); // it is the actual values of the table


        resultSet.next();
        resultSet.next();
        resultSet.next();
        String myFirstData= resultSet.getString("FIRST_NAME");
        System.out.println(myFirstData);
        resultSet.next();
        System.out.println(resultSet.getObject("FIRST_NAME")); // WE SHOULD ALWAYS USE OBJECT NOT A STRING TO MAKE IT MORE DYNAMIC
        resultSet.next();
        System.out.println(resultSet.getObject("employee_id"));
        System.out.println(resultSet.getRow());

        // metadat is what provides the structure of the table
        // resultsdata means data that is in the table

        ResultSetMetaData rsMetaData= resultSet.getMetaData();
        System.out.println("_________________________________");
        System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(5));
        System.out.println(rsMetaData.getColumnType(4));
        System.out.println(rsMetaData.getColumnClassName(1));

        List<Map<String , Object>> listOfMaps=new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
                row.put(rsMetaData.getColumnName(i), resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            listOfMaps.add(row);
        }

        for (int i=0; i<listOfMaps.size();i++){
            for (Object key: listOfMaps.get(i).keySet()){
                System.out.println(listOfMaps.get(i).get(key));

            }
        }

    }
}
