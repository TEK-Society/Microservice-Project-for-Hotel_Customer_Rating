package HotelReview.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotels")
public class Hotel {


    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
