package com.v4lo.client.user.entity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "user", schema = "client")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_2fa_enabled")
    private boolean is2faEnabled;
    @Column(name = "is_account_locked")
    private boolean isAccountLocked;
    @Column(name = "false_login_attempts")
    private Integer falseLoginAttempts;

}
