package com.teamchallenge.chat.controller;

import com.teamchallenge.chat.dto.UserDTO;
import com.teamchallenge.chat.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome-page")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/set-username")
    public ResponseEntity<?> setUsername(HttpServletRequest request, @RequestBody UserDTO userDTO, HttpServletResponse response){
        System.out.println(userDTO);
        return ResponseEntity.ok(userService.setUsername(request,userDTO, response));
    }
}
