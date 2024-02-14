package UserService.Controller;

import UserService.Entity.User;
import UserService.Service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/save")
    public ResponseEntity<User> saveUSer(@RequestBody User user ){
        User saveuser = userService.Saveuser(user);
        return new ResponseEntity<>(saveuser , HttpStatus.CREATED);
    }

    // for retry instance variable
    int retryCount = 1;

    @GetMapping("/getAll")
    @CircuitBreaker(name ="GetAllRatingAndHotel" , fallbackMethod = "GetAllRatingHotelAndDetails")
 //   @Retry(name="GetAllRatingAndHotel" , fallbackMethod = "GetAllRatingHotelAndDetails")
    public ResponseEntity<List<User>> getAllUSer(){
        logger.info("logger Count");
        logger.info("loggerCount {}",retryCount);
        retryCount++;
        List<User> aLlUser = userService.getALlUser();
        return new ResponseEntity<>(aLlUser,HttpStatus.OK);
    }

    // return method for Circuit Breaker
    public ResponseEntity<List<User>>GetAllRatingHotelAndDetails (Exception ex){
        logger.info(" Get all method is not working properly so check all implementation ",ex.getMessage());
        List<User> aLlUser = userService.getALlUser();
        return new ResponseEntity<>(aLlUser,HttpStatus.OK);
    }


    @GetMapping("/get")
   // @Retry(name="GetAllRatingAndHotel" , fallbackMethod = "GetAllRatingHotelAndDetails")
     @RateLimiter(name="GetAllRatingAndHotel",fallbackMethod = "GetAllRatingHotelAndDetails")
    public ResponseEntity<User> getUSer(@RequestParam("id")String id){
        logger.info("logger in : User Controller ");
        logger.info("loggerCount {}",retryCount);
        retryCount++;
        User user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/update")
    public  ResponseEntity<User> updateUser(@RequestParam("id") String id ,@RequestBody User user){
        User user1 = userService.updateUser(id, user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("id") String id){
        userService.deleteUser(id);
        return new ResponseEntity<>("id is deleted +"+id,HttpStatus.OK);

    }

}
