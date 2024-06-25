package com.MyOnlineUsedBookStore.UsedBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table // (name = "user-data") this is how we can change the table name for database
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    @Column
    private String f_name;
    @Column
    private String l_name;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;


}
