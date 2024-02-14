package Ratiing.Repositroy;

import Ratiing.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
public interface RatingRepository extends JpaRepository<Rating,String > {


    List<Rating> findByUserId(String id);

}
