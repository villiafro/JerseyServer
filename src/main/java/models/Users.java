package models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */

@XmlRootElement
public class Users {
    private int Id;
    private String FirstName;
    private String UserName;
    private String LastName;
    private String Email;
    private String Password;
    private boolean Admin;

    public Users(int id, String fname, String lname, String uname, String pw, String email, boolean admin){
        this.Id = id;
        this.FirstName = fname;
        this.UserName = uname;
        this.LastName = lname;
        this.Email = email;
        this.Password = pw;
        this.Admin = admin;
    }
}
