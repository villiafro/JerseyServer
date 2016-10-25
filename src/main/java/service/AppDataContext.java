package service;

import java.sql.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Users;
import scala.util.parsing.json.JSONArray;
import scala.util.parsing.json.JSONObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 25/10/2016.
 */

@XmlRootElement
public class AppDataContext {
    protected Connection connection;

    String url;
    String username;
    String password;

    public AppDataContext(){
        url = "jdbc:mysql://localhost:3306/javabase";
        username = "java";
        password = "password";

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
}
