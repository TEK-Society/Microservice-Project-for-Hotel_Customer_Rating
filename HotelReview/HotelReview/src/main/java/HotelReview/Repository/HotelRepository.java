package HotelReview.Repository;

import HotelReview.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel , String > {

}
