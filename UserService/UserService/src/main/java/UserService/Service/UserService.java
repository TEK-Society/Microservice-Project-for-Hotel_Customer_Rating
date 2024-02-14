package UserService.Service;

import UserService.Dto.UserDto;
import UserService.Entity.User;

import javax.xml.stream.events.Comment;
import java.util.*;

public interface UserService {

    // Create
    User Saveuser(User dto);
    // get
    List<User> getALlUser ();
    // update
    User updateUser(String id , User user);
    //delete
    void deleteUser(String id);
    User getUser(String id);


}

