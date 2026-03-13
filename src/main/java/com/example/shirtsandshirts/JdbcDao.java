package com.example.shirtsandshirts;

import java.sql.*;

public class JdbcDao {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/forum_shirts?useSSL=false";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "root";
    private static final String INSERT_QUERY = "INSERT INTO Customers (first_name, last_name," +
            " email_address, address, phone) VALUES (?,?,?,?,?)";

    public void orderRecord(String firstName, String lastName,
                            String email, String address, String phoneNum) throws SQLException {
        //Establishing Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, phoneNum);

            //Executes the query
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

        public static void printSQLException (SQLException ex){
            for (Throwable e : ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable throwable = ex.getCause();
                    while (throwable != null) {
                        System.out.println("Cause: " + throwable);
                        throwable = throwable.getCause();
                    }
                }
            }
        }
    }
