import java.io.*;
import java.util.ArrayList;

public class Employee extends User {
    private String type;
    static ArrayList<Employee>employees=new ArrayList<>();
    public Employee(){

    }

    public Employee(String username, String password, long idCounter) {
        super(username,password,idCounter);
    }



    public Employee(String username, String password, String type) {
        super(username, password);
        this.type = type;}



    public  String getUsername(){
        return username;
    }

    }

