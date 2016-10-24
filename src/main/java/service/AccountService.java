package service;

import java.util.ArrayList;
import models.Users;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
public class AccountService {
    private static ArrayList<Users> users;

    public AccountService(){
        users = new ArrayList<>();
    }

    public void addUsers(Users user) {
        users.add(user);
    }

    public static ArrayList<Users> getUsers() {
        return users;
    }
}
