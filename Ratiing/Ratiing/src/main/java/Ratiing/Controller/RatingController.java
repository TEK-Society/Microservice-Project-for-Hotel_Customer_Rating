package Ratiing.Controller;

import Ratiing.Entity.Rating;
import Ratiing.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/save")
    public ResponseEntity<Rating> saveInfo(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Rating>> getallInfo(){
        return  new ResponseEntity<>(ratingService.getAllRating(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Rating> updateList(@RequestParam("id") String id , @RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.updateRating(id,rating),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Rating> getRatingById(@RequestParam("id") String id){
        return new ResponseEntity<>(ratingService.getRatingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public  ResponseEntity<?> deleteRating (@RequestParam("id")String id ){
        ratingService.deleteRating(id);
        return new ResponseEntity<>("Deleted: "+id,HttpStatus.OK);
    }


  //  http://localhost:8083/api/rating/get/user?id=7f55b2d2-5ee1-4660-a135-b3749f58a1ce
    @GetMapping("/get/user")
    public ResponseEntity<List<Rating>> getallRatingByUserId(@RequestParam("id") String id){
        return new ResponseEntity<>(ratingService.getRatingByUserid(id) , HttpStatus.OK);
    }


}
