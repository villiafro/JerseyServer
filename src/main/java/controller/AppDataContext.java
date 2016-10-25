package controller;

import java.sql.*;
import models.Users;
import java.util.ArrayList;

/**
 * Created by VilhjalmurAlex on 25/10/2016.
 */
public class AppDataContext {
    private Connection connection;
    private ArrayList<Users> users;

    String url;
    String username;
    String password;

    public AppDataContext(){
        url = "jdbc:mysql://localhost:3306/javabase";
        username = "java";
        password = "password";

        users = new ArrayList<>();

        System.out.println("Loading driver...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        System.out.println("Connecting database...");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    private void fillUsers(){
        String query = "SELECT * FROM users";

        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");

                Users user = new Users(id,firstname,lastname,username,password,email,admin);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fill Array");
            e.printStackTrace();
        }
    }

    public ArrayList<Users> getUsers() {
        fillUsers();
        return users;
    }
}
