package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TryMySQL {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/student?"
                            + "user=root&password=25122001Ayush");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from student.student");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  student.student values (?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, "7");
            preparedStatement.setString(2, "Tony");
            preparedStatement.setString(3, "Computer");
           preparedStatement.executeUpdate();
//
//            preparedStatement = connect
//                    .prepareStatement("SELECT college,state,nrif rank,fees, COMMENTS from student.student");
//            resultSet = preparedStatement.executeQuery();
//            writeResultSet(resultSet);
//
//            // Remove again the insert comment
//            preparedStatement = connect
//                    .prepareStatement("delete from student.student where myuser= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();
            //writeResultSet(resultSet);
            resultSet = statement
                    .executeQuery("select * from student.student");
            writeResultSet(resultSet);
            //writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            String student_id = resultSet.getString("student_id");
            String name = resultSet.getString("name");
            String major = resultSet.getString("major");

            System.out.println("student_id: " + student_id);
            System.out.println("name: " + name);
            System.out.println("major: " + major);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}