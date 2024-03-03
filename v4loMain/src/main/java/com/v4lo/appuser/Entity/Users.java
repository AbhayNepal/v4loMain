package com.v4lo.appuser.Entity;

import com.v4lo.appuser.AppUserRole;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;
}
