package HotelReview.Controller;

import HotelReview.Entity.Hotel;
import HotelReview.Repository.HotelRepository;
import HotelReview.Servcie.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveinfo(@RequestBody Hotel hotel){
        return  new ResponseEntity<>(hotelService.saveinfo(hotel), HttpStatus.CREATED);
    }

    @GetMapping ("/getall")
    public ResponseEntity<List<Hotel>> getAllinfo(){
        return new ResponseEntity<>(hotelService.getallinfo(),HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<Hotel> getInfoById(@RequestParam("id") String id){
        return new ResponseEntity<>(hotelService.getHotelInfoById(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Hotel> upadateInfo(@RequestParam("id") String id , @RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.updateHotelInfo(id, hotel), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteInfo(@RequestParam("id")String id){
        hotelService.DeleteHotelinfo(id);
        return new ResponseEntity<>("deleted",HttpStatus.CREATED);
    }

}
