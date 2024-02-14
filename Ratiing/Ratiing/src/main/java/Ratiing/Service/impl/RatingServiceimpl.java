package Ratiing.Service.impl;

import Ratiing.Entity.Rating;
import Ratiing.Exception.ResourceNotFoundException;
import Ratiing.Repositroy.RatingRepository;
import Ratiing.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceimpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating saveRating(Rating rating) {
        String s = UUID.randomUUID().toString();
        rating.setId(s);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id is not present " + id)
        );

        return rating;
    }

    @Override
    public Rating updateRating(String id, Rating rating) {
        Rating rating1 = ratingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("id is not present :" + id)
        );
        rating1.setComment(rating.getComment());
        return ratingRepository.save(rating1) ;
    }

    @Override
    public void deleteRating(String id) {



    }

    @Override
    public List<Rating> getRatingByUserid(String id) {
        List<Rating> byUserId = ratingRepository.findByUserId(id);
        return byUserId;
    }
}
