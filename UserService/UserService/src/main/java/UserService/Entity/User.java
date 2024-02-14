package UserService.Entity;


import UserService.Dto.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    private  String id;
    @Column(name="name", nullable = false,length = 15)
    private String name;
    @Column(name="email",nullable = false,length = 20)
    private  String email;
    @Column(name="about",nullable = false)
    private String about;
    @Transient
    private List<Rating> rating = new ArrayList<Rating>();

}
