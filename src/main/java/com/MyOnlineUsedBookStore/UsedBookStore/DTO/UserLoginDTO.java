package com.MyOnlineUsedBookStore.UsedBookStore.DTO;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDTO {

    private Long userId;
    private String email;
    private String password;

}
