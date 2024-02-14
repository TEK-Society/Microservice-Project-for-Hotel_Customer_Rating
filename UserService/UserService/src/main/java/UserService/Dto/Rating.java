package UserService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rating {
    private String id;
    private String hotelId;
    private String userId;
    private String comment;
    private Hotel hotel;
}
