package UserService.Service.impl;

import UserService.Dto.Hotel;
import UserService.Dto.Rating;
import UserService.Entity.User;
import UserService.Exception.ResourceNotFoundException;
import UserService.ExternalServices.HotelService;
import UserService.Repository.UserRepository;
import UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    @Override
    public User Saveuser(User dto) {
        User u  = new User();
        u.setId(UUID.randomUUID().toString());
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setAbout(dto.getAbout());
        User save = userRepository.save(u);

        return save;
    }

    @Override
    public List<User> getALlUser() {
        // getting all user details with review and to whome he rate and what rate
        List<User> all = userRepository.findAll();
        all.stream().map(x ->{

            Rating[] rating = restTemplate.getForObject("http://RATING-CLIENT/api/rating/get/user?id=" + x.getId(), Rating[].class);
            List<Rating> collect = Arrays.stream(rating).collect(Collectors.toList());
            collect.stream().map(y -> {

                // map hotel id for data from hotel and save it to rating

                Hotel forObject1 = restTemplate.getForObject("http://HOTEL-CLIENT/api/hotel/get?id=" + y.getHotelId(), Hotel.class);
                y.setHotel(forObject1);
             return y;
            }).collect(Collectors.toList());
            x.setRating(collect);
                return x;
        }).collect(Collectors.toList());
        return all;
    }

    @Override
    public User updateUser(String id, User u) {

        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("id is not Present in database " + id));

        user.setName(u.getName());
        user.setEmail(u.getEmail());
        user.setAbout(u.getAbout());
        User save = userRepository.save(user);


        return save;
    }

    @Override
    public void deleteUser (String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID is not present in database " + id));
        userRepository.deleteById(user.getId());
    }

    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id is not Found:" + id));
       // http://localhost:8083/api/rating/get/user?id=

        Rating[] forObject = restTemplate.getForObject("http://RATING-CLIENT/api/rating/get/user?id=" + user.getId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(forObject).collect(Collectors.toList());
        List<Rating> ratingStream = ratings.stream().map(x -> {

            // map hotel id for data from hotel and save it to

            Hotel hotel = hotelService.getHotel(x.getHotelId());
            // using RestTemplete
            //  Hotel forObject1 = restTemplate.getForObject("http://HOTEL-CLIENT/api/hotel/get?id=" + x.getHotelId(), Hotel.class);

            // using Feign Interface
            x.setHotel(hotel);


            return x;
        }).collect(Collectors.toList());
        user.setRating(ratings);

        return user;
    }
}
