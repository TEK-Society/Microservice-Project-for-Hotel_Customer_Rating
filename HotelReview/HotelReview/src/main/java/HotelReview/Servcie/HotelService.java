package HotelReview.Servcie;

import HotelReview.Entity.Hotel;
import java.util.*;

public interface HotelService {

    // cereate
    Hotel saveinfo(Hotel hotel);

    // getall
    List<Hotel> getallinfo();

    // getbyid
    Hotel getHotelInfoById(String id);
    // update
    Hotel updateHotelInfo(String id, Hotel hotel);
    // delete
    void DeleteHotelinfo(String id );


}
