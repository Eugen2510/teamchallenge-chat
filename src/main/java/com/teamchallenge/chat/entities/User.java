package com.teamchallenge.chat.entities;

import com.teamchallenge.chat.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    @Column(name = "username")
    private String username;

    public UserDTO convertToUserDTO(){
        return new UserDTO(this.username);
    }

}
