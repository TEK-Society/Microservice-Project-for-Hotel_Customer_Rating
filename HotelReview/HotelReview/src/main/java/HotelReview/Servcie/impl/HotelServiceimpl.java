package HotelReview.Servcie.impl;

import HotelReview.Entity.Hotel;
import HotelReview.Exception.ResourceNotFind;
import HotelReview.Repository.HotelRepository;
import HotelReview.Servcie.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveinfo(Hotel hotel) {
        String sid = UUID.randomUUID().toString();
        hotel.setId(sid);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getallinfo() {
        return  hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelInfoById(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFind("id is not find in hotel data :" + id));

        return hotel;
    }

    @Override
    public Hotel updateHotelInfo(String id, Hotel hotel) {
        Hotel hotel1 = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFind("id is not find in hotel data :" + id));

        hotel1.setName(hotel.getName());
        hotel1.setLocation(hotel.getLocation());
        hotel1.setAbout(hotel.getAbout());
        return hotelRepository.save(hotel1);
    }

    @Override
    public void DeleteHotelinfo(String id) {
        Hotel hotel1 = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFind("id is not find in hotel data :" + id));
        hotelRepository.deleteById(hotel1.getId());

    }
}
