package login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String type;
    private String password;


    public User(String username, String type, String password)
    {
        this.username = username;
        this.type = type;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }


    public String getPassword() {
        return password;
    }




}
