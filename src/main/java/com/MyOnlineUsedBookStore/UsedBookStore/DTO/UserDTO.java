package com.MyOnlineUsedBookStore.UsedBookStore.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Long user_id;
    private String f_name;
    private String l_name;
    private String userName;
    private String email;
    private String password;


}
