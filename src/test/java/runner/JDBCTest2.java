package runner;

import utilities.JDBCutils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {

    public static void main(String[] args) throws SQLException{


        try {
            JDBCutils.establishedConnection();
            List<Map<String, Object>> dbData= JDBCutils.runSQLQuery("select first_name, last_name, salary from employees");
            System.out.println(dbData.get(0).get("FIRST_NAME"));
            System.out.println(dbData.get(0).get("SALARY"));
            System.out.println(JDBCutils.countRows("select first_name, last_name, salary from employees"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeConnection();
        }
    }





}

