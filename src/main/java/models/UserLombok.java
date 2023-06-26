package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString

public class UserLombok {

    String name;
    String lastname;
    String email;
    String psw;



}
