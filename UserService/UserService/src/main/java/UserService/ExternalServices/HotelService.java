package UserService.ExternalServices;

import UserService.Dto.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="HOTEL-CLIENT")
public interface HotelService {

    @GetMapping("/api/hotel/get")
    Hotel  getHotel(@RequestParam("id") String id);


}
