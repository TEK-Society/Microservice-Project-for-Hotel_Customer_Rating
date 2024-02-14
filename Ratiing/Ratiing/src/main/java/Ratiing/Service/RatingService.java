package Ratiing.Service;

import Ratiing.Entity.Rating;
import java.util.*;

public interface RatingService {

    Rating  saveRating(Rating rating);

    List<Rating> getAllRating();
    Rating getRatingById(String id);
    Rating updateRating(String id , Rating rating);
    void deleteRating (String id);

    List<Rating> getRatingByUserid(String id);


}
