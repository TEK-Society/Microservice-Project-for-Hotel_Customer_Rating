package Ratiing.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="rating")
public class Rating {
    @Id
    private String id;
    private String hotelId;
    private String userId;
    private String comment;

}
