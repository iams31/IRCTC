package irctc.entities;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private Integer mobile;
    private  String password;
    private  String hashedPassword;
    private ArrayList<Ticket> ticketsBooked;

}
