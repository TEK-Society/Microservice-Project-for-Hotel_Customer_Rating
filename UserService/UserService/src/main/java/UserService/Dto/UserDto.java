package UserService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  String id;
    private String name;
    private  String email;
    private String about;
}
