package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Users;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
public class AccountService extends AppDataContext{
    private JsonNodeFactory factory;
    private ArrayNode userList;

    public AccountService(){
        factory = new JsonNodeFactory(false);
        userList = factory.arrayNode();
        fillUsers();
    }

    private void fillUsers(){

        String query = "SELECT * FROM users";

        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                ObjectNode user = factory.objectNode();
                user.put("id", rs.getString("id"));
                user.put("firstname", rs.getString("firstname"));
                user.put("lastname", rs.getString("lastname"));
                user.put("usernam", rs.getString("username"));
                user.put("password", rs.getString("password"));
                user.put("email", rs.getString("email"));
                user.put("admin", rs.getBoolean("admin"));

                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fill Array");
            e.printStackTrace();
        }
    }

    public ArrayNode getUsers() {
        return userList;
    }
}
