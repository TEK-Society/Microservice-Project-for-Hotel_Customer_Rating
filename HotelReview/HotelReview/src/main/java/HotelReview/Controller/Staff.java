package HotelReview.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/staff")
public class Staff {
    @GetMapping
    ResponseEntity<List<String>> getallstaff(){
        List<String> list = Arrays.asList("mihul","pappu","priyanshu","jay","suresh","arnav");
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
