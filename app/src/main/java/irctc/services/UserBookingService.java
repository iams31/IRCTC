package irctc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import irctc.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class UserBookingService  {
    private User user;
    private static ArrayList<User> userList;
    private static final ObjectMapper objectMapper=new ObjectMapper();
    private static final String PATH_USER ="../localDB/users";
    public UserBookingService(User user) throws IOException {
        this.user=user;
        File users=new File(PATH_USER);
        userList=objectMapper.readValue(users, new TypeReference<ArrayList<User>>() {});
    }
    public Boolean loginUser(){
        Optional<User> foundUser=userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword())
        }).findFirst();
    }
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

}
