package com.example.picpaydesafio.domain.user;

import com.example.picpaydesafio.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;//CPF
    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;//Saldo
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){
        this.firstName=data.firstName();
        this.lastName= data.lastName();
        this.balance= data.balance();
        this.userType=data.userType();
        this.email=data.email();
        this.document= data.document();
        this.password=data.password();
    }

}
