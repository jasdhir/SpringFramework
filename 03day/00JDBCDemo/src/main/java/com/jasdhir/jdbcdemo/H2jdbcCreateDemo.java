package com.jasdhir.jdbcdemo;

import java.sql.*;

public class H2jdbcCreateDemo {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
           // stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            // STEP 3: Execute a query
            stmt = conn.createStatement();
            /*String sql1 = "INSERT INTO Registration " + "VALUES (210, 'Zara', 'Ali', 18)";

            stmt.executeUpdate(sql1);

            sql1 = "INSERT INTO Registration " + "VALUES (201, 'Mahnaz', 'Fatma', 25)";

            stmt.executeUpdate(sql1);
            sql1 = "INSERT INTO Registration " + "VALUES (202, 'Zaid', 'Khan', 30)";

            stmt.executeUpdate(sql1);
            sql1 = "INSERT INTO Registration " + "VALUES(203, 'Sumit', 'Mittal', 28)";

            stmt.executeUpdate(sql1);*/
            System.out.println("Inserted records into the table...");


            String sql2="select * from Registration";
            ResultSet rs=stmt.executeQuery(sql2);
            while(rs.next()) {
                System.out.print(rs.getInt("id"));
                System.out.println(rs.getString("first"));
            }
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }
}