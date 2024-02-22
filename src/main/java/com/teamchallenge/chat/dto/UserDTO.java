package com.teamchallenge.chat.dto;

import com.teamchallenge.chat.entities.User;

public record UserDTO (String username) {
    public User convertToUser(){
        User user = new User();
        user.setUsername(this.username);
        return user;
    }
}
