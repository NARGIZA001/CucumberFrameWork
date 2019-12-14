package utilities;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCutils {


    // method should be static
    // establishConnections
    //  run SQL query method  to save the data in list of maps to return the list of maps .
    //  close Database ()
    //  countrows method will count all the number of rows and return number of rows in int .


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * this method is establishing the connection to data
     * @throws IOException
     * @throws SQLException
     */

    public static void establishedConnection() throws IOException, SQLException {
                connection=DriverManager.getConnection(
                Configuration.getProperties("dbHost"), Configuration.getProperties("dbUsername"), Configuration.getProperties("dbPassword"));
                statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * This method will run query to data base and will return the data as List of Maps
     * @param query
     * @return
     * @throws SQLException
     */

        public  static List <Map<String, Object>> runSQLQuery (String query) throws  SQLException{
                resultSet=statement.executeQuery(query);
                ResultSetMetaData rsMetaData=resultSet.getMetaData();
                List<Map<String, Object>> listOfMaps=new ArrayList<>();
                int columnCount= rsMetaData.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = rsMetaData.getColumnName(i);
                        Object columnValue = resultSet.getObject(columnName);
                        row.put(columnName, columnValue);
                    }

                    listOfMaps.add(row);
                }
                return listOfMaps;
        }

    /**
     * This method will count the rows and return the number of rows.
     * @param query
     * @return
     * @throws SQLException
     */

        public  static int countRows (String query ) throws SQLException{

            resultSet=statement.executeQuery(query);

            resultSet.last();

           return resultSet.getRow();

        }

    /**
     * This method close DataBase connection , statemnet and result;
     * @throws SQLException
     */

    public static void closeConnection () throws  SQLException{
            if (connection!=null){
                connection.close();
            }
            if (statement!= null){
                statement.close();
            }
            if (resultSet!= null){
                resultSet.close();
            }
     }















}
