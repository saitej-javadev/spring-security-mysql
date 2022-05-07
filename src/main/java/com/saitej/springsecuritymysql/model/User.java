package com.saitej.springsecuritymysql.model;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_users")
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
}
